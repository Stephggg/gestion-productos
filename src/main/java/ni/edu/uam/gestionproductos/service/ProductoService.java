package ni.edu.uam.gestionproductos.service;

import ni.edu.uam.gestionproductos.dto.ProductoRequestDTO;
import ni.edu.uam.gestionproductos.entity.Categoria;
import ni.edu.uam.gestionproductos.entity.Etiqueta;
import ni.edu.uam.gestionproductos.entity.Producto;
import ni.edu.uam.gestionproductos.entity.Proveedor;
import ni.edu.uam.gestionproductos.repository.CategoriaRepository;
import ni.edu.uam.gestionproductos.repository.EtiquetaRepository;
import ni.edu.uam.gestionproductos.repository.ProductoRepository;
import ni.edu.uam.gestionproductos.repository.ProveedorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;
    private final ProveedorRepository proveedorRepository;
    private final EtiquetaRepository etiquetaRepository;

    public ProductoService(
            ProductoRepository productoRepository,
            CategoriaRepository categoriaRepository,
            ProveedorRepository proveedorRepository,
            EtiquetaRepository etiquetaRepository) {
        this.productoRepository = productoRepository;
        this.categoriaRepository = categoriaRepository;
        this.proveedorRepository = proveedorRepository;
        this.etiquetaRepository = etiquetaRepository;
    }

    @Transactional(readOnly = true)
    public List<Producto> listar() {
        return productoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Producto buscarPorId(Integer id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    @Transactional
    public Producto guardar(ProductoRequestDTO dto) {
        Producto producto = new Producto();
        copiarDatos(dto, producto);
        return productoRepository.save(producto);
    }

    @Transactional
    public Producto actualizar(Integer id, ProductoRequestDTO dto) {
        Producto producto = buscarPorId(id);
        copiarDatos(dto, producto);
        return productoRepository.save(producto);
    }

    @Transactional
    public void eliminar(Integer id) {
        productoRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<Producto> listarPorCategoria(Integer categoriaId) {
        return productoRepository.findByCategoriaId(categoriaId);
    }

    @Transactional
    public Producto agregarEtiqueta(Integer productoId, Integer etiquetaId) {
        Producto producto = buscarPorId(productoId);
        Etiqueta etiqueta = etiquetaRepository.findById(etiquetaId)
                .orElseThrow(() -> new RuntimeException("Etiqueta no encontrada"));
        producto.getEtiquetas().add(etiqueta);
        return productoRepository.save(producto);
    }

    @Transactional
    public void eliminarEtiqueta(Integer productoId, Integer etiquetaId) {
        Producto producto = buscarPorId(productoId);
        producto.getEtiquetas().removeIf(etiqueta -> etiqueta.getId().equals(etiquetaId));
        productoRepository.save(producto);
    }

    @Transactional(readOnly = true)
    public List<Producto> listarPorEtiqueta(Integer etiquetaId) {
        return productoRepository.findDistinctByEtiquetasId(etiquetaId);
    }

    private void copiarDatos(ProductoRequestDTO dto, Producto producto) {
        Categoria categoria = categoriaRepository.findById(dto.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoria no encontrada"));

        Proveedor proveedor = null;
        if (dto.getProveedorId() != null) {
            proveedor = proveedorRepository.findById(dto.getProveedorId())
                    .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));
        }

        producto.setCodigo(dto.getCodigo());
        producto.setNombre(dto.getNombre());
        producto.setPrecioVenta(dto.getPrecioVenta());
        producto.setExistencia(dto.getExistencia());
        producto.setCategoria(categoria);
        producto.setProveedor(proveedor);
        producto.setDescripcion(dto.getDescripcion());
    }
}

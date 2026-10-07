package ni.edu.uam.gestionproductos.dto;

import ni.edu.uam.gestionproductos.entity.Categoria;
import ni.edu.uam.gestionproductos.entity.Etiqueta;
import ni.edu.uam.gestionproductos.entity.Producto;
import ni.edu.uam.gestionproductos.entity.Proveedor;

import java.util.stream.Collectors;

public final class DtoMapper {

    private DtoMapper() {
    }

    public static CategoriaResponseDTO toResponse(Categoria categoria) {
        return new CategoriaResponseDTO(categoria.getId(), categoria.getNombre(), categoria.isActiva());
    }

    public static ProveedorResponseDTO toResponse(Proveedor proveedor) {
        return new ProveedorResponseDTO(
                proveedor.getId(),
                proveedor.getNombre(),
                proveedor.getTelefono(),
                proveedor.getCorreo(),
                proveedor.isActivo());
    }

    public static EtiquetaResponseDTO toResponse(Etiqueta etiqueta) {
        return new EtiquetaResponseDTO(etiqueta.getId(), etiqueta.getNombre());
    }

    public static ProductoResponseDTO toResponse(Producto producto) {
        return new ProductoResponseDTO(
                producto.getId(),
                producto.getCodigo(),
                producto.getNombre(),
                producto.getPrecioVenta(),
                producto.getExistencia(),
                producto.getDescripcion(),
                producto.getCategoria().getId(),
                producto.getCategoria().getNombre(),
                producto.getProveedor() == null ? null : producto.getProveedor().getId(),
                producto.getProveedor() == null ? null : producto.getProveedor().getNombre(),
                producto.getEtiquetas().stream()
                        .map(DtoMapper::toResponse)
                        .collect(Collectors.toSet()));
    }
}

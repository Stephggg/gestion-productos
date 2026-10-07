package ni.edu.uam.gestionproductos.controller;

import jakarta.validation.Valid;
import ni.edu.uam.gestionproductos.dto.DtoMapper;
import ni.edu.uam.gestionproductos.dto.ProductoRequestDTO;
import ni.edu.uam.gestionproductos.dto.ProductoResponseDTO;
import ni.edu.uam.gestionproductos.entity.Producto;
import ni.edu.uam.gestionproductos.service.ProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public List<ProductoResponseDTO> listar() {
        return productoService.listar().stream()
                .map(DtoMapper::toResponse)
                .toList();
    }

    @GetMapping("/categoria/{categoriaId}")
    public List<ProductoResponseDTO> listarPorCategoria(@PathVariable Integer categoriaId) {
        return productoService.listarPorCategoria(categoriaId).stream()
                .map(DtoMapper::toResponse)
                .toList();
    }

    @GetMapping("/etiqueta/{etiquetaId}")
    public List<ProductoResponseDTO> listarPorEtiqueta(@PathVariable Integer etiquetaId) {
        return productoService.listarPorEtiqueta(etiquetaId).stream()
                .map(DtoMapper::toResponse)
                .toList();
    }

    @GetMapping("/{id}")
    public ProductoResponseDTO buscar(@PathVariable Integer id) {
        return DtoMapper.toResponse(productoService.buscarPorId(id));
    }

    @PostMapping
    public ProductoResponseDTO guardar(@Valid @RequestBody ProductoRequestDTO dto) {
        return DtoMapper.toResponse(productoService.guardar(dto));
    }

    @PutMapping("/{id}")
    public ProductoResponseDTO actualizar(
            @PathVariable Integer id,
            @Valid @RequestBody ProductoRequestDTO dto) {
        return DtoMapper.toResponse(productoService.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        productoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{productoId}/etiquetas/{etiquetaId}")
    public ProductoResponseDTO agregarEtiqueta(
            @PathVariable Integer productoId,
            @PathVariable Integer etiquetaId) {
        return DtoMapper.toResponse(productoService.agregarEtiqueta(productoId, etiquetaId));
    }

    @DeleteMapping("/{productoId}/etiquetas/{etiquetaId}")
    public ResponseEntity<Void> eliminarEtiqueta(
            @PathVariable Integer productoId,
            @PathVariable Integer etiquetaId) {
        productoService.eliminarEtiqueta(productoId, etiquetaId);
        return ResponseEntity.noContent().build();
    }
}

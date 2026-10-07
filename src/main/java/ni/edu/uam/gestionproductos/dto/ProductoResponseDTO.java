package ni.edu.uam.gestionproductos.dto;

import java.math.BigDecimal;
import java.util.Set;

public class ProductoResponseDTO {

    private Integer id;
    private String codigo;
    private String nombre;
    private BigDecimal precioVenta;
    private Integer existencia;
    private String descripcion;
    private Integer categoriaId;
    private String categoriaNombre;
    private Integer proveedorId;
    private String proveedorNombre;
    private Set<EtiquetaResponseDTO> etiquetas;

    public ProductoResponseDTO(
            Integer id,
            String codigo,
            String nombre,
            BigDecimal precioVenta,
            Integer existencia,
            String descripcion,
            Integer categoriaId,
            String categoriaNombre,
            Integer proveedorId,
            String proveedorNombre,
            Set<EtiquetaResponseDTO> etiquetas) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioVenta = precioVenta;
        this.existencia = existencia;
        this.descripcion = descripcion;
        this.categoriaId = categoriaId;
        this.categoriaNombre = categoriaNombre;
        this.proveedorId = proveedorId;
        this.proveedorNombre = proveedorNombre;
        this.etiquetas = etiquetas;
    }

    public Integer getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public BigDecimal getPrecioVenta() {
        return precioVenta;
    }

    public Integer getExistencia() {
        return existencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Integer getCategoriaId() {
        return categoriaId;
    }

    public String getCategoriaNombre() {
        return categoriaNombre;
    }

    public Integer getProveedorId() {
        return proveedorId;
    }

    public String getProveedorNombre() {
        return proveedorNombre;
    }

    public Set<EtiquetaResponseDTO> getEtiquetas() {
        return etiquetas;
    }
}

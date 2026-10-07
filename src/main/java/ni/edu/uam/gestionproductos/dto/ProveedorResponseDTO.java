package ni.edu.uam.gestionproductos.dto;

public class ProveedorResponseDTO {

    private Integer id;
    private String nombre;
    private String telefono;
    private String correo;
    private boolean activo;

    public ProveedorResponseDTO(Integer id, String nombre, String telefono, String correo, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.activo = activo;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public boolean isActivo() {
        return activo;
    }
}

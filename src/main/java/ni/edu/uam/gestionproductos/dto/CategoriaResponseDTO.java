package ni.edu.uam.gestionproductos.dto;

public class CategoriaResponseDTO {

    private Integer id;
    private String nombre;
    private boolean activa;

    public CategoriaResponseDTO(Integer id, String nombre, boolean activa) {
        this.id = id;
        this.nombre = nombre;
        this.activa = activa;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isActiva() {
        return activa;
    }
}

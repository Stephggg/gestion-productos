package ni.edu.uam.gestionproductos.dto;

public class EtiquetaResponseDTO {

    private Integer id;
    private String nombre;

    public EtiquetaResponseDTO(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
}

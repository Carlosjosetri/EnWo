package EnWo.data.entidades;

/**
 *
 * @author Tania Orellana
 */
public class Habilidad {

    private int idHabilidad, nivelDisponibilidad, costoHabilidad;
    private String nombreHabilidad, descripcionHabilidad;

    public int getIdHabilidad() {
        return idHabilidad;
    }

    public void setIdHabilidad(int idHabilidad) {
        this.idHabilidad = idHabilidad;
    }

    public int getNivelDisponibilidad() {
        return nivelDisponibilidad;
    }

    public void setNivelDisponibilidad(int nivelDisponibilidad) {
        this.nivelDisponibilidad = nivelDisponibilidad;
    }

    public int getCostoHabilidad() {
        return costoHabilidad;
    }

    public void setCostoHabilidad(int costoHabilidad) {
        this.costoHabilidad = costoHabilidad;
    }

    public String getNombreHabilidad() {
        return nombreHabilidad;
    }

    public void setNombreHabilidad(String nombreHabilidad) {
        this.nombreHabilidad = nombreHabilidad;
    }

    public String getDescripcionHabilidad() {
        return descripcionHabilidad;
    }

    public void setDescripcionHabilidad(String descripcionHabilidad) {
        this.descripcionHabilidad = descripcionHabilidad;
    }

}

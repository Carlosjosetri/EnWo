package EnWo.data.entidades;

import java.util.ArrayList;

/**
 *
 * @author Tania Orellana
 */
public class Jugador {

    private int idJugador, idUsuario, maximoNivelAlcanzado, cantMonedas, puntajeMax;
    private ArrayList<Habilidad> habilidades;

    public int getPuntajeMax() {
        return puntajeMax;
    }

    public void setPuntajeMax(int puntajeMax) {
        this.puntajeMax = puntajeMax;
    }

    public ArrayList<Habilidad> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(ArrayList<Habilidad> habilidades) {
        this.habilidades = habilidades;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public int getMaximoNivelAlcanzado() {
        return maximoNivelAlcanzado;
    }

    public void setMaximoNivelAlcanzado(int maximoNivelAlcanzado) {
        this.maximoNivelAlcanzado = maximoNivelAlcanzado;
    }

    public int getCantMonedas() {
        return cantMonedas;
    }

    public void setCantMonedas(int cantMonedas) {
        this.cantMonedas = cantMonedas;
    }

    @Override
    public String toString() {
        return "Jugador{" + "idJugador=" + idJugador + ", idUsuario=" + idUsuario + ", maximoNivelAlcanzado=" + maximoNivelAlcanzado + ", cantMonedas=" + cantMonedas + ", puntajeMax=" + puntajeMax + '}';
    }

}

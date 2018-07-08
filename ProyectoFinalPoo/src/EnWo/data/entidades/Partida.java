package EnWo.data.entidades;

/**
 *
 * @author Tania Orellana
 */
public class Partida {

    private int idPartida, idJugador, puntajeObtenido, monedasObtenidas;

    public int getPuntajeObtenido() {
        return puntajeObtenido;
    }

    public void setPuntajeObtenido(int puntajeObtenido) {
        this.puntajeObtenido = puntajeObtenido;
    }

    public int getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(int idPartida) {
        this.idPartida = idPartida;
    }

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public int getMonedasObtenidas() {
        return monedasObtenidas;
    }

    public void setMonedasObtenidas(int monedasObtenidas) {
        this.monedasObtenidas = monedasObtenidas;
    }

}

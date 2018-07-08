package EnWo;

import EnWo.data.dao.JugadoresDAO;
import EnWo.data.entidades.Jugador;

/**
 *
 * @author Tania Orellana
 */
public class Admin {

    JugadoresDAO jd = new JugadoresDAO();

    private Admin() {
    }

    public static Admin getInstance() {
        return AdminHolder.INSTANCE;
    }

    private static class AdminHolder {

        private static final Admin INSTANCE = new Admin();
    }

    private static Jugador jugadorActual = new Jugador();

    private static int vida, monedasAtrapadas, obstaculosEsquivados, puntajeTotal, tiempo, condicionNivel;

    public Jugador getJugadorActual() {
        return jugadorActual;
    }

    public void setJugadorActual(Jugador jugadorActual) {
        Admin.jugadorActual = jugadorActual;
    }

    public void getInfoJugadorActual() {
        Jugador j = jd.findFromUser(getJugadorActual());
        if (j != null) {
            setJugadorActual(j);
        }
    }

    public void actualizarJugador() {
        this.jugadorActual.setCantMonedas(jugadorActual.getCantMonedas() + monedasAtrapadas);
        if (puntajeTotal > jugadorActual.getPuntajeMax()) {
            this.jugadorActual.setPuntajeMax(puntajeTotal);
        }
        if (jugadorActual.getMaximoNivelAlcanzado() == 1 && puntajeTotal >= condicionNivel) {
            this.jugadorActual.setPuntajeMax(2);
        }
    }

    public void actualizarRegistroJugador() {
        actualizarJugador();
        jd.update(getJugadorActual());
    }
}

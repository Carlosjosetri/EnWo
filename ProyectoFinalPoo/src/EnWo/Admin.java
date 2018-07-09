package EnWo;

import EnWo.data.dao.JugadoresDAO;
import EnWo.data.entidades.Jugador;

/**
 *
 * @author Tania Orellana
 */
public class Admin {

    JugadoresDAO jd = new JugadoresDAO();
    private static Jugador jugadorActual = new Jugador();
    private final int condicionNivel = 20000;
    private static int vida, monedasAtrapadas, puntajeTotal, tiempo;
    private static boolean haGanado;

    private Admin() {
    }

    public static Admin getInstance() {
        return AdminHolder.INSTANCE;
    }

    private static class AdminHolder {

        private static final Admin INSTANCE = new Admin();
    }

    public Jugador getJugadorActual() {
        return jugadorActual;
    }

    public void setJugadorActual(Jugador jugadorActual) {
        Admin.jugadorActual = jugadorActual;
    }

    public JugadoresDAO getJd() {
        return jd;
    }

    public void setJd(JugadoresDAO jd) {
        this.jd = jd;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        Admin.vida = vida;
    }

    public int getMonedasAtrapadas() {
        return monedasAtrapadas;
    }

    public void setMonedasAtrapadas(int monedasAtrapadas) {
        Admin.monedasAtrapadas = monedasAtrapadas;
    }

    public int getPuntajeTotal() {
        return puntajeTotal;
    }

    public void setPuntajeTotal(int puntajeTotal) {
        Admin.puntajeTotal = puntajeTotal;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        Admin.tiempo = tiempo;
    }

    public boolean getHaGanado() {
        return haGanado;
    }

    public void setHaGanado(boolean haGanado) {
        Admin.haGanado = haGanado;
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

    public void resultadosJuego(boolean haGanado, int vida, int monedasAtrapadas, int tiempo) {
        this.setHaGanado(haGanado);
        this.setVida(vida);
        this.setMonedasAtrapadas(monedasAtrapadas);
        this.setTiempo(tiempo);
        this.setPuntajeTotal(calcularPuntaje());
        actualizarRegistroJugador();
    }

    public int calcularPuntaje() {
        int puntaje = 0;
        puntaje = (monedasAtrapadas * 800 + vida * 3000 - tiempo * 10 + 1000);
        if (haGanado) {
            puntaje += 10000;
        }
        return puntaje;
    }
}

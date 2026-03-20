package controlador;

import model.*;

/**
 * Controlador que gestiona las acciones relacionadas con los jugadores.
 */
public class GestorJugador {

    /**
     * Carga o actualiza el nombre de un jugador nuevo.
     * @param nombre     nombre del jugador
     * @param nombreItem nombre del ítem (no usado aquí, reservado)
     */
    public void jugadorUsaNuevo(String nombre, String nombreItem) {
        // Reservado para integración con vista
    }

    /**
     * Guarda o actualiza el nombre del jugador y su posición en el tablero.
     * @param pase    número de casillas a mover (pasos del dado)
     * @param nombre  nombre del jugador
     * @param tablero tablero en curso
     */
    public void jugadorSetNuevo(Jugador j, int pase, String nombre, Tablero tablero) {
        j.setNombre(nombre);
        j.moverPosicion(pase);
        int max = tablero.getTotalCasillas() - 1;
        if (j.getPosicion() > max) j.setPosicion(max);
    }

    /**
     * Marca al jugador como finalizado el turno (reservado para la vista).
     * @param j jugador
     */
    public void jugadorFinalizaTurno(Jugador j) {
        // Reservado para integración con vista
    }

    /**
     * Lanza el evento de un pingüino (delega al GestorPartida).
     * @param p pingüino
     */
    public void pinguinoEsEvento(Pinguino p) {
        // Reservado para integración
    }

    /**
     * Lanza la lógica de guerra entre dos pingüinos.
     * El que tiene más bolas de nieve gana; el perdedor retrocede la diferencia.
     * En caso de empate, ninguno retrocede.
     * Ambos gastan todas sus bolas de nieve.
     * @param p1 primer pingüino
     * @param p2 segundo pingüino
     */
   
    /**
     * Gestiona la interacción del pingüino con la foca.
     * Si tiene pez, la alimenta (bloqueo 2 turnos). Si no, la foca lo envía al forat anterior.
     * @param p    pingüino
     * @param foca la foca CPU
     */
    public void focaInteraccion(Pinguino p, Foca foca) {
        Item pez = p.getInv().getItem(Pez.class);
        if (pez != null) {
            pez.setCantidad(pez.getCantidad() - 1);
            if (pez.getCantidad() <= 0) p.getInv().quitarItem(pez);
            foca.activarSoborno();
        } else {
            // La foca envía al pingüino al forat anterior (se calculará en GestorPartida)
            foca.apalizarJugador(p);
        }
    }
}

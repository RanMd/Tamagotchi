package food;

import sistemas.SistemaEventos;

public enum Comida {
    PAN(SistemaEventos.COMIDA_PAN, (byte) 1, (byte) 0, (byte) 1),
    CARNE(SistemaEventos.COMIDA_CARNE, (byte) 2, (byte) 0, (byte) 2),
    ZANAHORIA(SistemaEventos.COMIDA_ZANAHORIA, (byte) 1, (byte) 0, (byte) 0),
    HELADO(SistemaEventos.COMIDA_HELADO, (byte) 0, (byte) 1, (byte) 1),
    PASTEL(SistemaEventos.COMIDA_PASTEL, (byte) 0, (byte) 2, (byte) 2);

    public final byte id;
    public final byte lifeRestored;
    public final byte funRestored;
    public final byte weightGain;

    private Comida(byte id, byte lifeRestored, byte funRestored, byte weightGain) {
        this.id = id;
        this.lifeRestored = lifeRestored;
        this.funRestored = funRestored;
        this.weightGain = weightGain;
    }

    public static Comida find(int id) {
        if (PAN.id == id) {
            return PAN;
        } else if (CARNE.id == id) {
            return CARNE;
        } else if (ZANAHORIA.id == id) {
            return ZANAHORIA;
        } else if (HELADO.id == id) {
            return HELADO;
        } else {
            return PASTEL;
        }
    }
}

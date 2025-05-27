package sistemas;

import assets.Assets;
import assets.Constants;
import engine.Vector2;
import gameObjects.Evento;
import gameObjects.Player;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class SistemaEventos {

    public static final byte COMIDA_PAN = 1;
    public static final byte COMIDA_CARNE = 2;
    public static final byte COMIDA_ZANAHORIA = 3;
    public static final byte COMIDA_HELADO = 4;
    public static final byte COMIDA_PASTEL = 5;
    private final static EventoComida eventoComida = new EventoComida();
    private Evento evento = null;

    public static final Evento eventoCortina = new Evento(Assets.lobbyImgs.get("efectoAseo"),
            new Vector2(425, 144)) {

        private final BufferedImage paredFalsa = Assets.lobbyImgs.get("pared");
        private final byte speed = 5;

        @Override
        public void update(float delta) {
            if (rect.x > Constants.GAME_POINT.getIntX()) {
                rect.x -= speed;
            } else {
                activo = false;
                rect.x = 425;
            }
        }

        @Override
        public void draw(Graphics g) {
            g.drawImage(texture, (int) rect.x, (int) rect.y, null);
            g.drawImage(paredFalsa, 416, (int) rect.y, null);
        }
    };

    private static class EventoComida extends Evento {

        private float timer = 0;
        private float tiempoDesfase = 0.75f;
        private float tiempoDevorado = 2f;
        private boolean desfasando = false;
        private boolean visible = true;
        private boolean serComida = true;
        private final short alturaSuelo = 288;
        private final short speed = 96;
        private int indexFrame = 0;

        public EventoComida() {
            super(new Vector2(200, 144));
        }

        public void reset() {
            activo = false;
            timer = 0;
            tiempoDesfase = 0.75f;
            tiempoDevorado = 2f;
            desfasando = false;
            visible = true;
            indexFrame = 0;
            rect.y = 144;
        }

        @Override
        public void update(float delta) {
            texture = fases[indexFrame];

            if (rect.getBottom() < alturaSuelo) {
                rect.y += speed * delta;
                return;
            }

            timer += delta;

            if (!serComida) {
                desfasando = true;
                if (desfasando && timer > tiempoDesfase) {
                    visible = !visible;
                    tiempoDesfase += 0.18f;
                }
                if (tiempoDesfase >= 2f) {
                    reset();
                }
            } else {
                if (timer >= tiempoDevorado) {
                    if (indexFrame < fases.length - 1) {
                        indexFrame++;
                        tiempoDevorado += 1.2f;
                    } else {
                        reset();
                    }
                }
            }
        }

        @Override
        public void draw(Graphics g) {
            if (!visible) {
                return;
            }

            g.drawImage(texture, (int) rect.x, (int) rect.y, null);
        }
    }

    public static Evento addEventoComida(int tipoComida, boolean comida) {
        if (eventoComida.activo) {
            return eventoComida;
        }

        switch (tipoComida) {
            case COMIDA_PAN:
                eventoComida.fases = Assets.panAnim;
                break;
            case COMIDA_CARNE:
                eventoComida.fases = Assets.carneAnim;
                break;
            case COMIDA_ZANAHORIA:
                eventoComida.fases = Assets.carrotAnim;
                break;
            case COMIDA_HELADO:
                eventoComida.fases = Assets.heladoAnim;
                break;
            case COMIDA_PASTEL:
                eventoComida.fases = Assets.pastelAnim;
                break;
            default:
                eventoComida.fases = Assets.panAnim;
        }
        eventoComida.serComida = comida;

        return eventoComida;
    }

    public void addEvento(Evento evento) {
        if (this.evento == null || !this.evento.activo) {
            this.evento = evento;
            evento.activo = true;
        }
    }

    public void update(float delta) {
        if (evento != null && evento.activo) {
            this.evento.update(delta);
        }
    }

    public void draw(Graphics g) {
        if (evento != null && evento.activo) {
            this.evento.draw(g);
        }
    }
}

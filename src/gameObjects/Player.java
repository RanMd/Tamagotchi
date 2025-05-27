package gameObjects;

import animations.StateMachine;
import engine.Vector2;
import food.Comida;
import java.awt.Graphics;
import playerStates.HapDownState;
import playerStates.HoppingState;
import sistemas.EventManager;
import static sistemas.SistemaEventos.COMIDA_HELADO;
import static sistemas.SistemaEventos.COMIDA_PASTEL;
import static sistemas.SistemaEventos.addEventoComida;
import static states.GameStates.LOBBY;

public final class Player extends GameObject {

    private static Player instance;
    private final EventManager eventManager;
    private final Comida like;
    private final Comida dislike;
    public final StateMachine stateMachine;
    public boolean ocupado = false;
    public boolean enfermo = false;
    public boolean duchandose = false;
    public byte ultimaComida = 0;
    public byte cacas = 0;
    public byte life;
    public byte fun;

    private Player() {
        super(Vector2.zero);
        this.like = Comida.PAN;
        this.dislike = Comida.CARNE;
        this.stateMachine = new StateMachine(this);
        this.eventManager = new EventManager();
        this.life = 0;
        this.fun = 0;
        //verifyState();
    }

    public static Player getInstance() {
        if (instance == null) {
            instance = new Player();
        }
        return instance;
    }

    @Override
    public void update(float delta) {
        if (duchandose) {
            rect.x -= 5;

            if (rect.x <= -86) {
                duchandose = false;
                verifyShower();
            }
            return;
        }
        
        stateMachine.stateUpdate(delta);
    }

    @Override
    public void draw(Graphics g) {
        stateMachine.stateDraw(g);
    }

    public void eat(int cantidad) {
        life = life + cantidad > 4 ? 4 : (byte) (life + cantidad);
    }

    public void play(int cantidad) {
        if (fun + cantidad > 4) {
            enfermo = true;
            fun = 4;
        } else {
            fun += cantidad;
        }
    }
    
    public void verifyShower() {
        if (cacas > 0) {
            stateMachine.setState("Happy2");
        } else {
            stateMachine.setState("HappinessDown");
        }
    }

    public void verifyFood() {
        switch (ultimaComida) {
            case COMIDA_PASTEL, COMIDA_HELADO ->
                stateMachine.setState("Happy2");
            default -> {
                if (life == 4) {
                    stateMachine.setState("Full");
                } else {
                    verifyState();
                }
            }
        }
    }

    public void verifyState() {
        if (enfermo) {
            stateMachine.setState("Unhappy");
            return;
        }

        if (life == 0 && fun == 0 || fun > 0 && life == 0) {
            stateMachine.setState("Shy");
        } else if (fun == 4 && life > 0) {
            if (!(stateMachine.currentState instanceof HoppingState)) {
                stateMachine.setState("Hopping");
            }
        } else if ((fun > 0 && fun < 4) && life > 0) {
            if (!(stateMachine.currentState instanceof HapDownState)) {
                stateMachine.setState("HappinessDown");
            }
        } else if (fun == 0 && (life > 0 && life < 4)) {
            stateMachine.setState("Sad");
        }
    }

    public void eatAnimation(int comida) {
        if (life == 4 && comida != COMIDA_PASTEL && comida != COMIDA_HELADO) {
            stateMachine.setState("NoEating");
            LOBBY.eventos.addEvento(addEventoComida(comida, false));
            return;
        }

        Comida actual = Comida.find(comida);
        ultimaComida = actual.id;

        if (actual == like || actual.id == COMIDA_PASTEL) {
            stateMachine.setState("EatingExited");
        } else if (actual == dislike) {
            stateMachine.setState("EatingDislike");
        } else if (actual.id == COMIDA_HELADO) {
            stateMachine.setState("EatingIceCream");
        } else {
            stateMachine.setState("EatingNeutral");
        }

        eat(actual.lifeRestored);
        play(actual.funRestored);

        LOBBY.eventos.addEvento(addEventoComida(comida, true));
    }
}

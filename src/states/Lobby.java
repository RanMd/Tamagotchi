package states;

import sistemas.SistemaEventos;
import assets.Assets;
import assets.Constants;
import engine.Animation;
import engine.RectangleButton;
import engine.Text;
import gameObjects.Clock;
import gameObjects.Player;
import input.Keyboard;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import sistemas.EventListener;

public final class Lobby extends State implements EventListener {

    private final Clock clock = Clock.getInstance();
    private final Player tamagotchi = Player.getInstance();
    private final BufferedImage background;
    private final RectangleButton[] buttons;
    private BufferedImage selectBoxTexture;
    private BufferedImage iconTexture;
    private int indexButton;
    private final Animation cuadroAnimation;
    private final Animation iconAnimation;
    public final SistemaEventos eventos;
    private final Text nombre;
    private boolean wasPressed = false;
    private boolean wasleftPressed = false;

    public Lobby() {
        this.nombre = new Text("EXCRET", Constants.NAME_POINT, true);
        this.eventos = new SistemaEventos();
        this.background = Assets.backgrounds.get("backgroundRoom");
        this.cuadroAnimation = new Animation(Assets.cuadroAnim, 3);
        this.iconAnimation = new Animation(Assets.iconShirobabytchi, 4);
        this.cuadroAnimation.play();
        this.iconAnimation.play();
        this.buttons = new RectangleButton[8];
        this.indexButton = 0;
        initButtons();
    }

    public void initButtons() {
        this.buttons[0] = new RectangleButton(new Rectangle(112, 322, 32, 32),
                () -> {
                    State.changeState(GameStates.KITCHEN);
                });
        this.buttons[1] = new RectangleButton(new Rectangle(144, 322, 32, 32),
                () -> {
                    tamagotchi.stateMachine.setState("Hopping");
                });
        this.buttons[2] = new RectangleButton(new Rectangle(176, 322, 32, 32),
                () -> {
                });
        this.buttons[3] = new RectangleButton(new Rectangle(208, 322, 32, 32),
                () -> {
                });
        this.buttons[4] = new RectangleButton(new Rectangle(240, 322, 32, 32),
                () -> {
                    this.eventos.addEvento(SistemaEventos.eventoCortina);
                    tamagotchi.duchandose = true;
                });
        this.buttons[5] = new RectangleButton(new Rectangle(272, 322, 32, 32),
                () -> {
                    State.changeState(GameStates.STATS);
                });
        this.buttons[6] = new RectangleButton(new Rectangle(304, 322, 32, 32),
                () -> {
                });
        this.buttons[7] = new RectangleButton(new Rectangle(368, 322, 32, 32),
                () -> {
                });
    }

    public void keyboardHandler(float delta) {

        if (Keyboard.ENTER && !State.isEnterPressed) {
            if (!tamagotchi.ocupado) {
                buttons[indexButton].action.doAction();
            }
        }

        boolean keyPressed = Keyboard.RIGHT;
        boolean keyLeftPressed = Keyboard.LEFT;

        if (keyPressed && !wasPressed) {
            indexButton++;
        }

        if (keyLeftPressed && !wasleftPressed) {
            indexButton--;
        }

        wasPressed = keyPressed;
        wasleftPressed = keyLeftPressed;

        indexButton = (indexButton + buttons.length) % buttons.length;
    }

    @Override
    public void update(float delta) {
        this.eventos.update(delta);
        clock.update(delta);

        tamagotchi.update(delta);
        keyboardHandler(delta);
        for (RectangleButton button : buttons) {
            button.update(delta);
        }

        this.selectBoxTexture = this.cuadroAnimation.animationUpdate(delta);
        this.iconTexture = this.iconAnimation.animationUpdate(delta);

    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(background, Constants.GAME_POINT.getIntX(), Constants.GAME_POINT.getIntY(), null);
        nombre.draw(g);
        this.eventos.draw(g);
        clock.draw(g);
        tamagotchi.draw(g);

        g.drawImage(iconTexture, Constants.ICON_POINT.getIntX(), Constants.ICON_POINT.getIntY(), null);
        g.drawImage(selectBoxTexture, buttons[indexButton].rect.x - 6, 316, null);
    }

    @Override
    public void update() {
    }
}

// <editor-fold defaultstate="collapsed" desc="Intentos fallidos del manejo del teclado">
//if (Keyboard.RIGHT) {
//                position.setX(position.getIntX() + 64);
//            }else if (Keyboard.LEFT) {
//                position.setX(position.getIntX() - 64);
//            }
//        if (Keyboard.RIGHT && !Keyboard.isPressed) {
//            position.setX(position.getIntX() + 64);
//            aplasto = false;
//        } else if (Keyboard.LEFT && !Keyboard.isPressed) {
//            position.setX(position.getIntX() - 64);
//            aplasto = false;
//        }
//if (Keyboard.getKeyDown(KeyCodes.VK_RIGHT)) {
//            indexButton++;
//        } else if (Keyboard.getKeyDown(KeyCodes.VK_LEFT)){
//            indexButton--;
//        } else if (Keyboard.getKeyDown(KeyCodes.VK_ENTER)){
//            this.buttons.get(indexButton).action.doAction();
//        }
//if (!Keyboard.RIGHT && !Keyboard.LEFT) {
//            speed = 0;
//            primera = false;
//        }
//        
//        if (Keyboard.RIGHT && !primera) {
//            indexButton++;
//            primera = true;
//        }
//        
//        if (Keyboard.LEFT && !primera) {
//            indexButton--;
//            primera = true;
//        }
//        
//        if(primera){
//            speed += delta;
//        }
//        
//        if (speed >= 0.15) {
//            indexButton++;
//            speed = 0;
//        } else if(speed >= 0.15 && Keyboard.LEFT){
//            indexButton--;
//            speed = 0;
//        }
//        
//        if (indexButton == buttons.size()) {
//            indexButton = 0;
//        } else if (indexButton < 0) {
//            indexButton = buttons.size() - 1;
//        }
// Este funciona, no como quiero, pero funca
//if (Keyboard.ENTER) {
//            buttons[indexButton].action.doAction();
//        }
//
//        boolean keyPressed = Keyboard.RIGHT || Keyboard.LEFT;
//
//        if (!keyPressed) {
//            selectBoxSpeed = 0;
//            initialPress = false;
//            return;
//        }
//
//        int direction = (Keyboard.RIGHT) ? 1 : -1;
//
//        if (!initialPress) {
//            indexButton += 1 * direction;
//            initialPress = true;
//        } else {
//            selectBoxSpeed += delta;
//        }
//
//        if (selectBoxSpeed >= 0.2f) {
//            indexButton += 1 * direction;
//            selectBoxSpeed = 0;
//        }
//
//        indexButton = (indexButton + buttons.length) % buttons.length;
//Aqui
//if (Keyboard.ENTER) {
//            buttons[indexButton].action.doAction();
//        }
//        
//        boolean keyPressed = Keyboard.RIGHT || Keyboard.LEFT;
//        
//        if (keyPressed && !wasPressed) {
//            int direction = (Keyboard.RIGHT) ? 1 : -1;
//            indexButton += 1 * direction;
//        }
//        
//        wasPressed = keyPressed;
//
//        indexButton = (indexButton + buttons.length) % buttons.length;


// </editor-fold>

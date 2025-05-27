package states;

import assets.Assets;
import assets.Constants;
import engine.RectangleButton;
import engine.Text;
import gameObjects.Clock;
import gameObjects.Player;
import input.Keyboard;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import sistemas.SistemaEventos;

public class Kitchen extends State {

    private final Clock clock = Clock.getInstance();
    private final Player tamagotchi = Player.getInstance();
    private final BufferedImage background;
    private final Text nombre;
    private final BufferedImage iconTexture;
    private final RectangleButton[] buttons;
    private int indexButton;
    private boolean wasPressed = false;
    private boolean wasleftPressed = false;
    private boolean wasDownPressed = false;
    private boolean wasUpPressed = false;

    public Kitchen() {
        this.background = Assets.backgrounds.get("backgroundKitchen");
        this.nombre = new Text("EXCRET", Constants.NAME_POINT, true);;
        this.iconTexture = Assets.lobbyImgs.get("foodSelector");
        this.buttons = new RectangleButton[5];
        this.indexButton = 0;
        initButtons();
    }

    public final void initButtons() {
        this.buttons[0] = new RectangleButton(new Rectangle(104, 178, 2, 2),
                () -> {
                    tamagotchi.eatAnimation(SistemaEventos.COMIDA_PAN);
                });
        this.buttons[1] = new RectangleButton(new Rectangle(198, 178, 2, 2),
                () -> {
                    tamagotchi.eatAnimation(SistemaEventos.COMIDA_CARNE);
                });
        this.buttons[2] = new RectangleButton(new Rectangle(294, 178, 2, 2),
                () -> {
                    tamagotchi.eatAnimation(SistemaEventos.COMIDA_ZANAHORIA);
                });
        this.buttons[3] = new RectangleButton(new Rectangle(104, 288, 2, 2),
                () -> {
                    tamagotchi.eatAnimation(SistemaEventos.COMIDA_HELADO);
                });
        this.buttons[4] = new RectangleButton(new Rectangle(198, 288, 2, 2),
                () -> {
                    tamagotchi.eatAnimation(SistemaEventos.COMIDA_PASTEL);
                });
    }

    @Override
    public void update(float delta) {
        clock.update(delta);

        tamagotchi.update(delta);
        keyboardHandler();
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(background, Constants.GAME_POINT.getIntX(), Constants.GAME_POINT.getIntY(), null);
        nombre.draw(g);
        clock.draw(g);

        g.drawImage(iconTexture, buttons[indexButton].rect.x, buttons[indexButton].rect.y, null);
    }

    public void keyboardHandler() {
        if (Keyboard.ENTER && !State.isEnterPressed) {
            State.changeState(GameStates.LOBBY);
            buttons[indexButton].action.doAction();
            indexButton = 0;
        } else if (Keyboard.K) {
            State.changeState(GameStates.LOBBY);
        }

        boolean keyPressed = Keyboard.RIGHT;
        boolean keyLeftPressed = Keyboard.LEFT;
        boolean keyDownPressed = Keyboard.DOWN;
        boolean keyUpPressed = Keyboard.UP;

        if (keyPressed && !wasPressed) {
            indexButton++;
        } else if (keyLeftPressed && !wasleftPressed) {
            indexButton--;
        } else if ((keyDownPressed && !wasDownPressed) || (keyUpPressed && !wasUpPressed)) {
            switch (indexButton) {
                case 0 ->
                    indexButton = 3;
                case 1 ->
                    indexButton = 4;
                case 2 ->
                    indexButton = 4;
                case 3 ->
                    indexButton = 0;
                case 4 ->
                    indexButton = 1;
            }
        }

        wasPressed = keyPressed;
        wasleftPressed = keyLeftPressed;
        wasDownPressed = keyDownPressed;
        wasUpPressed = keyUpPressed;

        indexButton = (indexButton + buttons.length) % buttons.length;
    }
}

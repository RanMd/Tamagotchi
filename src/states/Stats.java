package states;

import assets.Assets;
import assets.Constants;
import engine.Animation;
import engine.Text;
import engine.Vector2;
import gameObjects.Clock;
import gameObjects.Player;
import input.Keyboard;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Stats extends State{

    private final Clock clock = Clock.getInstance();
    private final Player tamagotchi = Player.getInstance();
    private final BufferedImage background;
    private final Animation iconAnimation;
    private final Text nombre;
    private final BufferedImage corazon;
    private final BufferedImage palo;
    private BufferedImage iconTexture;
    byte iq = 4;
    byte body = 2;
    byte deed = 3;

    public Stats() {
        this.background = Assets.backgrounds.get("backgroundStats");
        this.iconAnimation = new Animation(Assets.iconShirobabytchi, 4);
        this.iconAnimation.play();
        this.nombre = new Text("EXCRET", Constants.NAME_POINT, true);
        this.corazon = Assets.icons.get("corazon");
        this.palo = Assets.icons.get("palo");
    }
    
    public void drawMultipleImages(Graphics g, BufferedImage image, int count, Vector2 point, int offsetX){
        for (int i = 0; i < count; i++) {
            g.drawImage(image, point.getIntX() + (offsetX * i), point.getIntY(), null);
        }
    }

    @Override
    public void update(float delta) {
        clock.update(delta);

        tamagotchi.update(delta);
        keyboardHandler();

        this.iconTexture = this.iconAnimation.animationUpdate(delta);
    }
    
    
    public void keyboardHandler() {
        if (Keyboard.K) {
            State.changeState(GameStates.LOBBY);
        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(background, Constants.GAME_POINT.getIntX(), Constants.GAME_POINT.getIntY(), null);
        nombre.draw(g);
        clock.draw(g);
        
        drawMultipleImages(g, corazon, tamagotchi.life, Constants.LIFE_POINT, 16);
        drawMultipleImages(g, corazon, tamagotchi.fun, Constants.FUN_POINT, 16);
        drawMultipleImages(g, palo, iq, Constants.IQ_POINT, 4);
        drawMultipleImages(g, palo, body, Constants.BODY_POINT, 4);
        drawMultipleImages(g, palo, deed, Constants.DEED_POINT, 4);
        
        g.drawImage(iconTexture, Constants.ICON_POINT.getIntX(), Constants.ICON_POINT.getIntY(), null);
        g.drawImage(iconTexture, Constants.ICON2_POINT.getIntX(), Constants.ICON2_POINT.getIntY(), null);
    }

}

package playerStates;

import assets.Assets;
import engine.Animation;
import engine.Rectangle;
import gameObjects.Player;
import java.awt.Graphics;
import java.awt.image.BufferedImage;


public class ShyState extends PlayerState{
    public final Animation animation;
    public final BufferedImage image;
    
    public BufferedImage cosaTexture;

    public ShyState(Player tamagotchi) {
        super(tamagotchi);
        this.animation = new Animation(Assets.efectos.get("cosa"), 4);
        animation.play();
        this.image = Assets.unhappyAnimation.get("Shirobabytchi")[0];
    }

    @Override
    public void update(float delta) {
        cosaTexture = animation.animationUpdate(delta);
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(image, (int) tamagotchi.rect.x, (int) tamagotchi.rect.y, null);
        g.drawImage(cosaTexture, (int) tamagotchi.rect.x - 44, (int) tamagotchi.rect.y - 12, null);
    }

    @Override
    public void setRectangle() {
        tamagotchi.rect = new Rectangle(244, 0, image.getWidth(), image.getHeight());
        tamagotchi.rect.setBottom(ALTURA_PISO);
    }
    
}

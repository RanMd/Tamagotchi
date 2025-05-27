package playerStates;

import assets.Assets;
import engine.Rectangle;
import gameObjects.Player;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class FullState extends PlayerState {

    public final BufferedImage image;
    public final BufferedImage imageEfecto;
    public int frameCounter = 0;

    public FullState(Player tamagotchi) {
        super(tamagotchi);
        this.image = Assets.fullAnimation.get("Shirobabytchi");
        this.imageEfecto = Assets.efectos.get("llenura")[0];
    }

    @Override
    public void update(float delta) {
        frameCounter++;
        
        if (frameCounter == 64) {
            frameCounter = 0;
            tamagotchi.verifyState();
        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(image, (int) tamagotchi.rect.x, (int) tamagotchi.rect.y, null);
        g.drawImage(imageEfecto, (int) tamagotchi.rect.x - 32, (int) tamagotchi.rect.y - 30, null);
    }

    @Override
    public void setRectangle() {
        tamagotchi.rect = new Rectangle(234, 0, image.getWidth(), image.getHeight());
        tamagotchi.rect.setBottom(ALTURA_PISO);
    }

}

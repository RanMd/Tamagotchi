package playerStates;

import assets.Assets;
import engine.Rectangle;
import gameObjects.Player;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class NoEating extends PlayerState{
    
    private final BufferedImage[] images;
    private byte indexFrame = 0;
    private int frameCounter = 0;

    public NoEating(Player tamagotchi) {
        super(tamagotchi);
        images = Assets.eatingNoAnimation.get("Shirobabytchi");
    }

    @Override
    public void update(float delta) {
        frameCounter++;
        
        if (frameCounter == 59) {
            indexFrame++;
        } else if (frameCounter == 158) {
            tamagotchi.verifyState();
        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(images[indexFrame], (int) tamagotchi.rect.x, (int) tamagotchi.rect.y, null);
    }

    @Override
    public void setRectangle() {
        tamagotchi.rect = new Rectangle(244, 0, images[0].getWidth(), images[0].getHeight());
        tamagotchi.rect.setBottom(ALTURA_PISO);
        indexFrame = 0;
        frameCounter = 0;
    }
    
}

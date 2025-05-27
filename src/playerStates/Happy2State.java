package playerStates;

import assets.Assets;
import engine.Rectangle;
import gameObjects.Player;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Happy2State extends PlayerState {

    private final BufferedImage[] images;
    private final BufferedImage[] imagesEfecto;
    private byte indexFrame = 0;
    private byte indexFrameEfecto = 0;
    private byte salto = 0;
    private int frameCounter = 0;
    private boolean efectoVisible = false;

    public Happy2State(Player tamagotchi) {
        super(tamagotchi);
        images = Assets.happy2Animation.get("Shirobabytchi");
        imagesEfecto = Assets.efectos.get("sol");
    }

    @Override
    public void update(float delta) {
        frameCounter++;

        switch (frameCounter) {
            case 21 -> {
                indexFrame++;
                tamagotchi.rect.y -= 12;
                efectoVisible = true;
                salto++;
            }
            case 45 -> {
                indexFrame--;
                indexFrameEfecto--;
                frameCounter = 0;
                tamagotchi.rect.y += 12;
                efectoVisible = false;
                
                if (salto == 3) {
                    tamagotchi.verifyState();
                }
            } 
        }
        
        if (efectoVisible) {
            switch (frameCounter) {
                case 32 -> indexFrameEfecto++;
            }
        }
        
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(images[indexFrame], (int) tamagotchi.rect.x, (int) tamagotchi.rect.y, null);
        if (efectoVisible) {
            g.drawImage(imagesEfecto[indexFrameEfecto], (int) tamagotchi.rect.x + 36, (int) tamagotchi.rect.y - 36, null);
        }
    }

    @Override
    public void setRectangle() {
        tamagotchi.rect = new Rectangle(244, 0, images[0].getWidth(), images[0].getHeight());
        tamagotchi.rect.setBottom(ALTURA_PISO);
        frameCounter = 0;
        indexFrame = 0;
        indexFrameEfecto = 0;
        efectoVisible = false;
        salto = 0;
    }

}

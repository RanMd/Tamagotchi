package playerStates;

import assets.Assets;
import engine.Rectangle;
import gameObjects.Player;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class EatingNeState extends PlayerState {

    private final BufferedImage[] images;
    private byte indexFrame = 0;
    private byte mordidas = 0;
    private boolean comiendo = false;
    private int frameCounter = 0;

    public EatingNeState(Player tamagotchi) {
        super(tamagotchi);
        images = Assets.eatingNeAnimation.get("Shirobabytchi");
    }

    @Override
    public void update(float delta) {
        frameCounter++;

        if (!comiendo) {
            if (frameCounter == 108) {
                indexFrame++;
                comiendo = true;
                frameCounter = 0;
            }
        } else {
            switch (frameCounter) {
                case 32 -> {
                    indexFrame++;
                }
                case 72 -> {
                    if (mordidas != 2) {
                        mordidas++;
                        indexFrame--;
                        frameCounter = 0;
                    } else {
                        indexFrame = 0;
                    }
                }

                case 144 -> {
                    tamagotchi.ocupado = false;
                    tamagotchi.verifyFood();
                }
                    
            }
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
        tamagotchi.ocupado = true;
        indexFrame = 0;
        comiendo = false;
        frameCounter = 0;
        mordidas = 0;
    }
}

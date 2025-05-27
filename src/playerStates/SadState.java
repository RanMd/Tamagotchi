package playerStates;

import assets.Assets;
import engine.Rectangle;
import gameObjects.Player;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class SadState extends PlayerState {

    private final BufferedImage[] images;
    private final BufferedImage[] imagesEfecto;
    private byte indexFrame = 0;
    private byte indexEfectoFrame = 0;
    private int frameCounter = 0;
    private boolean efectoVisible = true;

    public SadState(Player tamagotchi) {
        super(tamagotchi);
        images = Assets.sadAnimation.get("Shirobabytchi");
        imagesEfecto = Assets.efectos.get("pancake");
    }

    @Override
    public void update(float delta) {
        frameCounter++;

        switch (frameCounter) {
            case 23 -> {
                indexFrame++;
                efectoVisible = true;
            }

            case 37 -> {
                indexEfectoFrame++;
            }

            case 72 -> {
                indexEfectoFrame--;
                indexFrame--;
                efectoVisible = false;
                frameCounter = 0;
            }
        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(images[indexFrame], (int) tamagotchi.rect.x, (int) tamagotchi.rect.y, null);

        if (efectoVisible) {
            g.drawImage(imagesEfecto[indexEfectoFrame], (int) tamagotchi.rect.x + 36, (int) tamagotchi.rect.y - 36, null);
        }
    }

    @Override
    public void setRectangle() {
        tamagotchi.rect = new Rectangle(244, 0, images[0].getWidth(), images[0].getHeight());
        tamagotchi.rect.setBottom(ALTURA_PISO);
    }

}

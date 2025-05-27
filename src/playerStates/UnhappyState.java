package playerStates;

import assets.Assets;
import engine.Rectangle;
import gameObjects.Player;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class UnhappyState extends PlayerState {

    private final BufferedImage[] images;
    private final BufferedImage[] imagesEfecto;
    private byte indexFrame = 0;
    private int frameCounter = 0;
    private byte indexFrameEfecto = 0;
    private boolean efectoVisible = false;

    public UnhappyState(Player tamagotchi) {
        super(tamagotchi);
        images = Assets.unhappyAnimation.get("Shirobabytchi");
        imagesEfecto = Assets.efectos.get("rayon");
    }

    @Override
    public void update(float delta) {
        frameCounter++;

        switch (frameCounter) {
            case 21 ->
                indexFrame++;
            case 46 ->
                indexFrame--;
            case 71 -> {
                indexFrame++;
                efectoVisible = true;
            }
            case 92 ->
                indexFrameEfecto++;
            case 117 -> {
                indexFrameEfecto--;
                efectoVisible = false;
            }
            case 143 -> {
                indexFrame--;
                frameCounter = 0;
            }
        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(images[indexFrame], (int) tamagotchi.rect.x, (int) tamagotchi.rect.y, null);

        if (efectoVisible) {
            g.drawImage(imagesEfecto[indexFrameEfecto], (int) tamagotchi.rect.x - 52, (int) tamagotchi.rect.y - 44, null);
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
    }

}

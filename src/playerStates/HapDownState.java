package playerStates;

import assets.Assets;
import engine.Rectangle;
import gameObjects.Player;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class HapDownState extends PlayerState {

    public final BufferedImage image;
    public final BufferedImage[] imagesEfecto;
    private byte indexEfectoFrame = 0;
    private boolean efectoVisible = false;
    private int frameCounter = 0;

    public HapDownState(Player tamagotchi) {
        super(tamagotchi);
        this.image = Assets.hapDownAnimation.get("Shirobabytchi");
        this.imagesEfecto = Assets.efectos.get("signo");
    }

    @Override
    public void update(float delta) {
        frameCounter++;

        switch (frameCounter) {
            case 81 -> {
                efectoVisible = true;
            }
            case 89 -> {
                indexEfectoFrame++;
            }
            case 133 -> {
                efectoVisible = false;
                indexEfectoFrame--;
                frameCounter = 0;
                tamagotchi.verifyState();
            }
        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(image, (int) tamagotchi.rect.x, (int) tamagotchi.rect.y, null);

        if (efectoVisible) {
            g.drawImage(imagesEfecto[indexEfectoFrame], (int) tamagotchi.rect.x + 36, (int) tamagotchi.rect.y - 38, null);
        }
    }

    @Override
    public void setRectangle() {
        tamagotchi.rect = new Rectangle(244, 0, image.getWidth(), image.getHeight());
        tamagotchi.rect.setBottom(ALTURA_PISO);
        indexEfectoFrame = 0;
        frameCounter = 0;
        efectoVisible = false;
    }

}


package playerStates;

import assets.Assets;
import engine.Rectangle;
import gameObjects.Player;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class EatingDiState extends PlayerState{
    
    private final BufferedImage[] images;
    private final BufferedImage[] imagesEfecto;
    private byte indexFrame = 0;
    private byte indexEfectoFrame = 0;
    private byte mordidas = 0;
    private boolean comiendo = false;
    private boolean efectoVisible = false;
    private int frameCounter = 0;

    public EatingDiState(Player tamagotchi) {
        super(tamagotchi);
        images = Assets.eatingDiAnimation.get("Shirobabytchi");
        imagesEfecto = new BufferedImage[] {
            Assets.reflectHorizontal(Assets.efectos.get("cosa")[1]),
            Assets.reflectHorizontal(Assets.efectos.get("cosa")[0])
        };
    }

    @Override
    public void update(float delta) {
        frameCounter++;

        if (!comiendo) {
            switch (frameCounter) {
                case 44 -> {
                    indexFrame++;
                    efectoVisible = true;
                }
                case 61 -> {
                    indexEfectoFrame++;
                }
                case 108 -> {
                    indexFrame--;
                    comiendo = true;
                    efectoVisible = false;
                    frameCounter = 0;
                }
            }
        } else {
            switch (frameCounter) {
                case 32 -> {
                    indexFrame = 2;
                }
                case 72 -> {
                    if (mordidas != 2) {
                        mordidas++;
                        indexFrame = 3;
                        frameCounter = 0;
                    } else {
                        tamagotchi.rect.y -= 8;
                        indexFrame = 4;
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
        
        if (efectoVisible) {
            g.drawImage(imagesEfecto[indexEfectoFrame], (int) tamagotchi.rect.x + 36, (int) tamagotchi.rect.y - 36, null);
        }
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

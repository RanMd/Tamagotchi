package playerStates;

import assets.Assets;
import engine.Rectangle;
import gameObjects.Player;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class EatingExState extends PlayerState {

    private final BufferedImage[] images;
    private byte indexFrame = 0;
    private byte mordidas = 0;
    private boolean comiendo = false;
    private int frameCounter = 0;

    public EatingExState(Player tamagotchi) {
        super(tamagotchi);
        images = Assets.eatingExAnimation.get("Shirobabytchi");
    }

    @Override
    public void update(float delta) {
        frameCounter++;

        if (!comiendo) {
            switch (frameCounter) {
                case 44 ->
                    indexFrame++;
                case 108 -> {
                    indexFrame--;
                    comiendo = true;
                    frameCounter = 0;
                }
            }
        } else {
            switch (frameCounter) {
                case 32 -> {
                    indexFrame = 2;
                    tamagotchi.rect.y -= 4;
                }
                case 72 -> {
                    if (mordidas != 2) {
                        mordidas++;
                        indexFrame = 0;
                        frameCounter = 0;
                    } else {
                        indexFrame = 3;
                    }
                    tamagotchi.rect.y += 4;
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

// <editor-fold defaultstate="collapsed" desc="Cosas utiles pero descartadas">
// ! Si funca pero voy a hacer otra cosa
// float timer = 0;
//timer += delta;
//        if (mirando) {
//            if (timer >= 0.7f && indexFrame == 0) {
//                indexFrame++;
//            }
//
//            if (timer >= 1.7f) {
//                indexFrame--;
//                timer = 0;
//                mirando = !mirando;
//            }
//
//        } else {
//            if (timer >= 0.5f && indexFrame == 0) {
//                indexFrame += 2;
//                tamagotchi.rect.y -= 5;
//            }
//            
//            if (timer >= 1.2f) {
//                timer = 0;
//                indexFrame -= 2;
//                tamagotchi.rect.y += 5;
//            }
//        }

// </editor-fold>

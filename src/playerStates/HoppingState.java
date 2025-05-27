package playerStates;

import assets.Assets;
import engine.Rectangle;
import engine.Vector2;
import gameObjects.Player;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public final class HoppingState extends PlayerState {

    private final BufferedImage[] images;
    private final BufferedImage[] reflectedImages;
    private final Vector2 speedV = new Vector2(Vector2.zero);
    private boolean reversa = false;
    private boolean reflejo = true;
    private byte indexFrame = 0;
    private int frameCounter = 0;

    public HoppingState(Player tamagotchi) {
        super(tamagotchi);
        images = Assets.hoppingAnimation.get("Shirobabytchi");
        reflectedImages = new BufferedImage[] {
            Assets.reflectHorizontal(images[0]),
            Assets.reflectHorizontal(images[1]),
            Assets.reflectHorizontal(images[2])
        };
    }

    @Override
    public void update(float delta) {
        frameCounter++;

        speedV.set(0, 0);

        switch (frameCounter) {
            case 7, 13 ->
                indexFrame++;
            case 27, 33 ->
                indexFrame--;
        }

        int directionX = reversa ? -1 : 1;

        switch (frameCounter) {
            case 1, 3, 6, 10, 11, 16 -> {
                speedV.setX(2 * directionX);
                speedV.setY(-2);
            }
            case 2, 4, 5, 8, 12 ->
                speedV.setY(-2);
            case 9, 14, 15, 17, 19, 20, 21, 23, 25, 26, 31 ->
                speedV.setX(2 * directionX);
            case 28, 32, 35, 36, 38, 39 ->
                speedV.setY(2);
            case 24, 29, 30, 34, 37 -> {
                speedV.setX(2 * directionX);
                speedV.setY(2);
            }
            case 40 ->
                frameCounter = 0;
        }

        tamagotchi.rect.x += speedV.getX();
        tamagotchi.rect.y += speedV.getY();

        if (tamagotchi.rect.x == 288) {
            reversa = true;
            reflejo = false;
        } else if (tamagotchi.rect.x == 200) {
            reversa = false;
            reflejo = true;
        } else if (tamagotchi.rect.x == 244) {
            tamagotchi.verifyState();
        }
    }

    @Override
    public void draw(Graphics g) {
        if (reflejo) {
            g.drawImage(reflectedImages[indexFrame], (int) tamagotchi.rect.x, (int) tamagotchi.rect.y, null);
        } else {
            g.drawImage(images[indexFrame], (int) tamagotchi.rect.x, (int) tamagotchi.rect.y, null);
        }

    }

    @Override
    public void setRectangle() {
        tamagotchi.rect = new Rectangle(244, 0, images[0].getWidth(), images[0].getHeight());
        tamagotchi.rect.setBottom(ALTURA_PISO);
        reversa = false;
        reflejo = true;
        indexFrame = 0;
        frameCounter = 0;
    }
}

// <editor-fold defaultstate="collapsed" desc="Cosas utiles pero descartadas">
// ! Si funca pero voy a hacer otra cosa
//if (!reversa) {
//            float frameTime = indexFrame == 0 ? 0.2f : 0.1f;
//            if (timer >= frameTime) {
//                timer = 0;
//                indexFrame++;
//            }
//            tamagotchi.rect.y -= 3;
//
//            reversa = indexFrame == 2;
//        } else {
//            float frameTime = indexFrame == 2 ? 0.2f : 0.1f;
//            if (timer >= frameTime) {
//                timer = 0;
//                indexFrame--;
//            }
//            tamagotchi.rect.y += 3;
//            reversa = !(indexFrame == 0);
//        }
//        timer += delta;
//        timerMov += delta;
//        if (timerMov >= 0.3f && !volteado) {
//            subiendo = !subiendo;
//            volteado = true;
//        } else if (timerMov >= 0.6f) {
//            timerMov = 0;
//            speed *= -1;
//            volteado = false;
//        }
//
//        if (subiendo) {
//            tamagotchi.rect.x -= speed;
//        } else {
//            tamagotchi.rect.x -= speed;
//        }

// </editor-fold>

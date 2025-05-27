
package gameObjects;

import assets.Assets;
import assets.Constants;
import engine.Vector2;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Clock extends GameObject{
    
    private static Clock instance;
    BufferedImage[] animation;
    float timer;
    float timeToChange;
    int indexFrame;
    int hora;
    
    private Clock(){
        super(new Vector2(Constants.GAME_POINT.getIntX() + 48, Constants.GAME_POINT.getIntY() + 16));
        this.timeToChange = 1f;
        this.indexFrame = 0;
        this.animation = Assets.clockAnim;
        this.timer = 0;
        this.texture = animation[indexFrame];
    }
    
    public static Clock getInstance() {
        if (instance == null) {
            instance = new Clock();
        }
        return instance;
    }
    
    @Override
    public void update(float delta){
        timer += delta;
        
        if (timer >= timeToChange) {
            timer = 0;
            indexFrame = (indexFrame > animation.length - 2) ? 0: indexFrame + 1;
            hora = indexFrame + 1;
            this.texture = animation[indexFrame];
        }
    }
    
    @Override
    public void draw(Graphics g){
        g.drawImage(texture,(int) rect.x, (int) rect.y, null);
    }
}

package engine;

import java.awt.image.BufferedImage;

public class Animation {
    
    private final float frameRate;
    private final BufferedImage[] sprites;
    private float timer = 0;
    private int frameIndex = 0;
    private boolean animationActive;
    
    public Animation (BufferedImage[] sprites, float frames){
        this.sprites = sprites;
        this.animationActive = false;
        this.frameRate = 1f / frames;
    }
    
    
    public void play(){
        this.animationActive = true; 
    }
    
    public void stop(){
        this.animationActive = false;
    }
    
    public BufferedImage animationUpdate(float delta){
        if(!this.animationActive){
            return this.sprites[frameIndex];
        }
        
        timer += delta;
        
        if (timer >= this.frameRate) {
            timer = 0;
            frameIndex++;
        }
        
        if (frameIndex > this.sprites.length - 1) {
            this.frameIndex = 0;
        }
        
        return this.sprites[frameIndex];
    }
    
}

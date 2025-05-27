package gameObjects;

import engine.Vector2;
import java.awt.Graphics;
import java.awt.image.BufferedImage;


public abstract class Evento extends GameObject{

    public boolean activo;
    public BufferedImage[] fases;

    public Evento(BufferedImage texture, Vector2 position) {
        super(texture, position);
        this.activo = false;
    }
    
    public Evento(Vector2 position) {
        super(position);
        this.activo = false;
    }
    
    public void setEnabled(boolean enabled){
        this.activo = enabled;
    }

    @Override
    public abstract void update(float delta);

    @Override
    public abstract void draw(Graphics g);
    
}

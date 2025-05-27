package playerStates;

import gameObjects.Player;
import java.awt.Graphics;

public abstract class PlayerState {
    public Player tamagotchi;
    public final short ALTURA_PISO = 272;

    public PlayerState(Player tamagotchi) {
        this.tamagotchi = tamagotchi;
    }
    
    public abstract void update(float delta);
    
    public abstract void draw(Graphics g);
    
    public abstract void setRectangle();
    
}

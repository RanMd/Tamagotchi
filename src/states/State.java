package states;

import input.Keyboard;
import java.awt.Graphics;

public abstract class State {
    private static State actualState = null;
    public static boolean isEnterPressed = false;
    
    public static void changeState(State state){
        if (Keyboard.ENTER) {
            isEnterPressed = true;
        }
        
        actualState = state;
    }
    
    public static State getCurrentState(){
        return actualState;
    }
    
    public abstract void update(float delta);
    
    public abstract void draw(Graphics g);
}


package engine;

import engine.Vector2;
import input.MouseInput;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public abstract class Button {
    protected final Vector2 position;
    public final Action action;
    protected BufferedImage buttonImg;
    public final Rectangle rect;
    protected boolean mouseIn = false;
    
    public Button(BufferedImage buttonImg, Vector2 position, Action action) {
        this.buttonImg = buttonImg;
        this.position = position;
        this.action = action;
        this.rect = new Rectangle((int) position.getX(), (int) position.getY(),
                buttonImg.getWidth(), buttonImg.getHeight());
    }
    
    public Button(Rectangle rect, Action action) {
        this.action = action;
        this.rect = rect;
        this.position = new Vector2(rect.x, rect.y);
    }
    
    public void update(float delta) {
        mouseHandler();
    }
    
    public abstract void draw(Graphics g);
    
    public void mouseHandler(){
        this.mouseIn = rect.contains(MouseInput.x, MouseInput.y);

        if (mouseIn && MouseInput.MLB) {
            this.action.doAction();
        }
    };
}

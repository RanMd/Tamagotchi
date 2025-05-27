package engine;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class ImageButton extends Button{
    
    public ImageButton(BufferedImage buttonImg, Vector2 position, Action action) {
        super(buttonImg, position, action);
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(this.buttonImg, (int) position.getX(), (int) position.getY(), null);
    }
}

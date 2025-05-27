
package engine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class RectangleButton extends Button{

    public RectangleButton(Rectangle rect, Action action) {
        super(rect, action);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.red);
        g.drawRect(rect.x, rect.y, rect.width, rect.height);
    }
    
}

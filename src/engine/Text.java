package engine;

import static assets.Assets.font;
import java.awt.Graphics;

public class Text {
    private final String texto;
    private final Vector2 posicion;
    private boolean center = false;

    public Text(String text, Vector2 position, boolean center) {
        this.texto = text;
        this.posicion = new Vector2(position);
        this.center = center;
    }
    
    public void draw(Graphics g){
        if (center) {
            center = !center;
            posicion.setX(posicion.getX() - g.getFontMetrics().stringWidth(texto) / 2);
            posicion.setY(posicion.getY() + font.getSize() / 2 - (font.getSize() / 10));
        }
        
        
        
        g.drawString(texto, posicion.getIntX(), posicion.getIntY());
    }
}
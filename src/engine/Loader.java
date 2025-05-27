package engine;

import java.awt.Font;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Loader {
    public static BufferedImage loadImage(String path){
        try {
            return ImageIO.read(Loader.class.getResource(path));
        } catch (Exception e) {
        }
        return null;
    }
    
    public static Font loadFont(String path, int size){
        try {
            return Font.createFont(Font.TRUETYPE_FONT, Loader.class.getResourceAsStream(path)).deriveFont(Font.PLAIN, size);
        } catch (Exception e) {
        }
        return null;
    }
}

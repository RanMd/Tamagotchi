package gameObjects;

import static assets.Assets.defaultTexture;
import engine.Rectangle;
import engine.Vector2;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class GameObject {

    public BufferedImage texture;
    public Rectangle rect;

    public GameObject(BufferedImage texture, Vector2 position) {
        this.texture = texture;
        this.rect = new Rectangle(position, texture.getWidth(), texture.getHeight());
    }

    public GameObject(Vector2 position) {
        this.texture = defaultTexture;
        this.rect = new Rectangle(position, texture.getWidth(), texture.getHeight());
    }
    
    public GameObject() {
        this.texture = defaultTexture;
        this.rect = new Rectangle(Vector2.zero, texture.getWidth(), texture.getHeight());
    }

    public abstract void update(float delta);

    public abstract void draw(Graphics g);

    public int getWidth() {
        return texture.getWidth();
    }

    public int getHeight() {
        return texture.getHeight();
    }

}

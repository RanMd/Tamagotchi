package engine;

public class Rectangle {
    public float x;
    public float y;
    private final int width;
    private final int height;

    public Rectangle(float x, float y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    public Rectangle(Vector2 position, int width, int height) {
        this.x = position.getX();
        this.y = position.getY();
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    
    public int getBottom() {
        return (int) (y + height);
    }
    
    public void setBottom(float bottom){
        this.y = bottom - height;
    }
    
    public void setTopLeft(float x, float y){
        this.x = x;
        this.y = y;
    }
    
    public void setTopLeft(Vector2 newPosition){
        this.x = newPosition.getX();
        this.y = newPosition.getY();
    }
    
    @Override
    public String toString(){
        return "(" + x + ", " + y + ", " + width + ", " + height + ")";
    }
    
    
}

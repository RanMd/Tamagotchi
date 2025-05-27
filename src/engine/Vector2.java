package engine;

public class Vector2 {
    
    private float x;
    private float y;
    
    // Vectores estaticos
    public final static Vector2 zero = new Vector2(0, 0);
    public final static Vector2 left = new Vector2(-1, 0);
    public final static Vector2 right = new Vector2(1, 0);
    
    public Vector2(float x, float y){
        this.x = x;
        this.y = y;
    }
    
    public Vector2(Vector2 v){
        this.x = v.getX();
        this.y = v.getY();
    }
        
    // Getters y Setters
    
    public float getX() {
        return x;
    }
    
    public int getIntX() {
        return (int) x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }
    
    public int getIntY() {
        return (int) y;
    }

    public void setY(float y) {
        this.y = y;
    }
    
    public void set(float x, float y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public String toString(){
        return ("(" + this.x + ", " + this.y +")");
    }
    
}

package assets;

import engine.Vector2;

public class Constants {
    
    // Total 512x446
    // Juego 320x288
    
    //JFrame size
    public final static int WIDTH = 512;
    public final static int HEIGHT = 446;
    
    public final static Vector2 GAME_POINT = new Vector2(96, 80);
    public final static Vector2 NAME_POINT = new Vector2(239, 110);
    public final static Vector2 ICON_POINT = new Vector2(304, 96);
    public final static Vector2 ICON2_POINT = new Vector2(113, 176);
    public final static Vector2 LIFE_POINT = new Vector2(176, 242);
    public final static Vector2 FUN_POINT = new Vector2(LIFE_POINT.getIntX(), 290);
    
    public final static Vector2 IQ_POINT = new Vector2(338, 242);
    public final static Vector2 BODY_POINT = new Vector2(IQ_POINT.getIntX(), IQ_POINT.getIntY() + 48);
    public final static Vector2 DEED_POINT = new Vector2(IQ_POINT.getIntX(), IQ_POINT.getIntY() + 96);
    
}

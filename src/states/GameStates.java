package states;

public class GameStates {
    public final static Lobby LOBBY;
    public final static Stats STATS;
    public final static Kitchen KITCHEN;
    
    
    static {
        LOBBY = new Lobby();
        STATS = new Stats();
        KITCHEN = new Kitchen();
    }
}

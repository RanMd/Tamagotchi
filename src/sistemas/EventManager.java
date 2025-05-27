
package sistemas;

public class EventManager {
    private EventListener lobbyEvents;
    
    public void notify(String key){
        lobbyEvents.update();
    }
        
}

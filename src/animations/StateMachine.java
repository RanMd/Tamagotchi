package animations;

import gameObjects.Player;
import java.awt.Graphics;
import java.util.HashMap;
import playerStates.EatingDiState;
import playerStates.EatingExState;
import playerStates.EatingICState;
import playerStates.EatingNeState;
import playerStates.FullState;
import playerStates.HapDownState;
import playerStates.Happy2State;
import playerStates.HoppingState;
import playerStates.NoEating;
import playerStates.PlayerState;
import playerStates.SadState;
import playerStates.ShyState;
import playerStates.UnhappyState;

public final class StateMachine {

    private final HashMap<String, PlayerState> playerStates;
    public PlayerState currentState;

    public StateMachine(Player tamagotchi) {
        this.playerStates = new HashMap<>();
        initPlayerStates(tamagotchi);
        setState("Shy");
    }

    private void initPlayerStates(Player tamagotchi) {
        playerStates.put("Shy", new ShyState(tamagotchi));
        playerStates.put("Sad", new SadState(tamagotchi));
        playerStates.put("HappinessDown", new HapDownState(tamagotchi));
        playerStates.put("Hopping", new HoppingState(tamagotchi));
        playerStates.put("Happy2", new Happy2State(tamagotchi));
        playerStates.put("Full", new FullState(tamagotchi));
        playerStates.put("Unhappy", new UnhappyState(tamagotchi));

        playerStates.put("EatingExited", new EatingExState(tamagotchi));
        playerStates.put("EatingNeutral", new EatingNeState(tamagotchi));
        playerStates.put("EatingDislike", new EatingDiState(tamagotchi));
        playerStates.put("EatingIceCream", new EatingICState(tamagotchi));
        playerStates.put("NoEating", new NoEating(tamagotchi));
    }

    public void stateUpdate(float delta) {
        currentState.update(delta);
    }

    public void stateDraw(Graphics g) {
        currentState.draw(g);
    }

    public void setState(String key) {
        this.currentState = this.playerStates.get(key);
        this.currentState.setRectangle();
    }
}

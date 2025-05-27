package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import states.State;

public class Keyboard implements KeyListener {

    private final boolean[] keys = new boolean[256];

    public static boolean UP, DOWN, LEFT, RIGHT, ENTER, K;

    public Keyboard() {
        UP = false;
        DOWN = false;
        LEFT = false;
        RIGHT = false;
        ENTER = false;
        K = false;
    }

    public void update() {
        UP = keys[KeyEvent.VK_UP];
        DOWN = keys[KeyEvent.VK_DOWN];
        LEFT = keys[KeyEvent.VK_LEFT];
        RIGHT = keys[KeyEvent.VK_RIGHT];
        ENTER = keys[KeyEvent.VK_ENTER];
        K = keys[KeyEvent.VK_K];
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            State.isEnterPressed = false;
        }
        keys[e.getKeyCode()] = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}

//boolean wasPressed = isPressed;
//        
//        isPressed = pressedKeys.contains(keyCode);
//        
//        if (!wasPressed && isPressed) {
//            return true;
//        }
//        
//        return false;
// Metodo para que las teclas solo se puedan pulsar una vez
//private final boolean[] keys = new boolean[256];
//    
//    public static boolean UP, DOWN, LEFT, RIGHT;
//
//    private static final Set<Integer> trackedKeys = new HashSet<>();
//    private static final Set<Integer> pressedKeys = new HashSet<>();
//    private static final Set<Integer> firstPressKeys = new HashSet<>();
//
//    public Keyboard() {
//        UP = false;
//        DOWN = false;
//        LEFT = false;
//        RIGHT = false;
//    }
//
//    public void update() {
//        UP = keys[KeyEvent.VK_UP];
//        DOWN = keys[KeyEvent.VK_DOWN];
//        LEFT = keys[KeyEvent.VK_LEFT];
//        RIGHT = keys[KeyEvent.VK_RIGHT];
//        
//        
//    }
//
//    @Override
//    public void keyPressed(KeyEvent e) {
//        keys[e.getKeyCode()] = true;
//        if (trackedKeys.contains(e.getKeyCode())) {
//            if (!pressedKeys.contains(e.getKeyCode())) {
//                firstPressKeys.add(e.getKeyCode());
//            }
//            pressedKeys.add(e.getKeyCode());
//        }
//    }
//
//    @Override
//    public void keyReleased(KeyEvent e) {
//        keys[e.getKeyCode()] = false;
//        if (trackedKeys.contains(e.getKeyCode())) {
//            pressedKeys.remove(e.getKeyCode());
//        }
//    }
//
//    @Override
//    public void keyTyped(KeyEvent e) {
//    }
//
//    public static boolean getKeyDown(int keyCode) {
//        trackedKeys.add(keyCode);
//
//        if (firstPressKeys.contains(keyCode)) {
//            firstPressKeys.remove(keyCode);
//            return true;
//        }
//
//        return false;
//    }
//}

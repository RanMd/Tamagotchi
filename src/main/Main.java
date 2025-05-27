package main;

import assets.Assets;
import assets.Constants;
import input.Keyboard;
import input.MouseInput;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;
import states.*;

public final class Main extends JFrame implements Runnable{
    Thread threadMain;
    boolean running = false;
    
    //FPS
    final int FPS = 60;
    final double TARGETTIME = 1000000000 / FPS;
    
    public float deltaTime = 0;
    
    private BufferStrategy bs;
    private final Canvas canvas;
    
    private Graphics g;
    
    private final MouseInput mouseInput;
    private final Keyboard keyboard;
    
    
    public Main(){
        setTitle("Tamagotchi");
        
        setWindowSize(Constants.WIDTH, Constants.HEIGHT);
        
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
                
        canvas = new Canvas();
        mouseInput = new MouseInput();
        keyboard = new Keyboard();
        
        canvas.setPreferredSize(new Dimension(Constants.WIDTH, Constants.HEIGHT));
        canvas.setMaximumSize(new Dimension(Constants.WIDTH, Constants.HEIGHT));
        canvas.setMinimumSize(new Dimension(Constants.WIDTH, Constants.HEIGHT));
        canvas.setFocusable(true);
        add(canvas);
        
        canvas.addKeyListener(keyboard);
        canvas.addMouseListener(mouseInput);
        canvas.addMouseMotionListener(mouseInput);
        
        setVisible(true);
    }
    
    public void init(){
        Assets.initAssets();
        State.changeState(GameStates.LOBBY);
    }
    
    public void startGame(){
        threadMain = new Thread(this);
        threadMain.start();
        running = true;
    }
    
    public static void main(String[] args) {
        new Main().startGame();
    }

    @Override
    public void run() {
        long now = 0;
        long lastTime = System.nanoTime();
        //long time = 0;
        //int frames = 0;
        
        init();
        while (running) {    
            now = System.nanoTime();
            deltaTime += (now - lastTime) / TARGETTIME;
            //time += (now - lastTime);
            
            lastTime = now;
            
            if (deltaTime >= 1) {
                update((float) 1 / FPS);
                draw();
                deltaTime--;
                //frames++;
            }
            
            /*if (time > 1000000000) {
                time = 0;
                frames = 0;
                System.out.println(frames); 
            }*/
            
            try {
                Thread.sleep(1); 
            } catch (InterruptedException e) {
            }

        }
        
    }
    
    public void update(float delta){
        keyboard.update();
        State.getCurrentState().update(delta);
    }
    
    public void draw(){
        bs = canvas.getBufferStrategy();
        
        if (bs == null) {
            canvas.createBufferStrategy(3);
            return;
        }
        
        g = bs.getDrawGraphics();
        g.setFont(Assets.font);
        g.setColor(Color.BLACK);
        
        //---------Zona de Dibujo
        
        g.drawImage(Assets.frame, 0, 0, null);
        State.getCurrentState().draw(g);
        
        //------------------------------------
        
        g.dispose();
        bs.show();
        
    }
    
    public void setWindowSize(int width, int height){
        this.pack();
        Insets insets = this.getInsets();
        
        int borderWidth = insets.left + insets.right;
        int borderHeight = insets.top + insets.bottom;
        
        int windowWidth = width + borderWidth;
        int windowHeight = height + borderHeight;
        
        setSize(windowWidth, windowHeight);
    }
    
}

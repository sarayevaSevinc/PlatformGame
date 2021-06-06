 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgsuper.mario;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sevinc Sarayeva
 */
public class Game extends Canvas implements Runnable {

    public static final int WIDTH = 1200, HEIGHT = 2 * WIDTH / 3;
    private Thread thread;
    private boolean running = false;
    private Handler handler;
    private HUD hud;
    private Spawn spawn;
    private Camera camera;

    public Game() {
        init();
        new Window(WIDTH, HEIGHT, "Game", this);
        addKeyListener(new KeyInput());
    }

    private void init() {
        this.handler = new Handler();
        StaticFields.handler = this.handler;
        StaticFields.player = new Player(100, 100, ID.Player);
        StaticFields.game = this;
        camera = new Camera(1,1, ID.Camera);
        handler.addObject(camera);
        this.hud = new HUD();
        this.spawn = new Spawn();
        handler.addObject(StaticFields.player);
         loadLevel();
      }

    public static void main(String[] args) {
        new Game();
    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();;
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    @Override
    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;

        long timer = System.currentTimeMillis();
        int frames = 0;

        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running) {
                render();
                frames++;
            }
            if ((System.currentTimeMillis() - timer) > 1000) {
                timer += 1000;
                System.out.println("FPS : " + frames);
                frames = 0;
            }
        }
        stop();
    }

    private void tick() {
        StaticFields.handler.tick();
        spawn.tick();
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.PINK);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        
        Graphics2D g2d = (Graphics2D) g;
        
       // BufferedImage image =   ImageLoader.loadImage("/background.png");
        
        g2d.translate(-camera.getX(), -camera.getY());
       // g.drawImage(image, 0, 0, this);
        handler.render(g);
        camera.render(g);
        
        g2d.translate(camera.getX(), camera.getY());
        
        hud.render(g);
        g.dispose();
        bs.show();
    }
  private void loadLevel(){
        int ara= 100;
        int pU = 120;
        int in = 10;
        for(int i = 0; i<10; i++)
        handler.addObject(new Platform(in+i*pU+i*ara, 600, ID.platform));
        for(int i = 0; i<10; i++)
        handler.addObject(new Platform(in+50+i*pU+i*ara, 900, ID.platform));   
        handler.addObject(new BoxTrigger(500, 500, ID.BoxTrigger));
  }
}

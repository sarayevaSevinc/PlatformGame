/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgsuper.mario;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author Sevinc Sarayeva
 */
public class KeyInput extends KeyAdapter{
    private Game game;
    
    private Player player;
    
    public KeyInput (){
        this.player = StaticFields.player;
        this.game = StaticFields.game;
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
     int key = e.getKeyCode();
     if(key == KeyEvent.VK_ESCAPE) System.exit(0);
     
         if(key == KeyEvent.VK_W) player.keyPressed[3] = true;
         if(key == KeyEvent.VK_A) player.keyPressed[1] = true;
         if(key == KeyEvent.VK_S) player.keyPressed[4] = true;
         if(key == KeyEvent.VK_D) player.keyPressed[2] = true;
         
          if(key == KeyEvent.VK_UP) player.keyPressed[3] = true;
         if(key == KeyEvent.VK_LEFT) player.keyPressed[1] = true;
         if(key == KeyEvent.VK_DOWN) player.keyPressed[4] = true;
         if(key == KeyEvent.VK_RIGHT) player.keyPressed[2] = true;
         if(key == KeyEvent.VK_SPACE) player.keyPressed[0] = true;
         
     
     
    }

    @Override
    public void keyReleased(KeyEvent e) {
         int key = e.getKeyCode();
     if(key == KeyEvent.VK_ESCAPE) System.exit(0);
  
         if(key == KeyEvent.VK_W) player.keyPressed[3] = false;
         if(key == KeyEvent.VK_A) player.keyPressed[1] = false;
         if(key == KeyEvent.VK_S) player.keyPressed[4] = false;
         if(key == KeyEvent.VK_D) player.keyPressed[2] = false;
         
          if(key == KeyEvent.VK_UP) player.keyPressed[3] = false;
         if(key == KeyEvent.VK_LEFT) player.keyPressed[1] = false;
         if(key == KeyEvent.VK_DOWN) player.keyPressed[4] = false;
         if(key == KeyEvent.VK_RIGHT) player.keyPressed[2] = false;
          if(key == KeyEvent.VK_SPACE) player.keyPressed[0] = false;
    }
    
  
}

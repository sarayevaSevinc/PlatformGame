/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgsuper.mario;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author user
 */
public class Camera extends GameObject{
  private Player player;
  
    public Camera(int x, int y, ID id) {
        super(x, y, id);
        player = StaticFields.player;
    }

    @Override
    public Rectangle getBounds() {
    return new Rectangle(x, y, width, height);
    }

    @Override
    public void tick() {
        this.x +=((player.getX()+player.getBounds().width-x)-Game.WIDTH/2)*0.005f;
        this.y +=((player.getY()+player.getBounds().height-y)-Game.HEIGHT/2)*0.005f;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.blue);
       g.fill3DRect(x, y, 10, 10, true);
    }
    
}

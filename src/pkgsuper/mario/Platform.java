/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgsuper.mario;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author user
 */
public class Platform extends GameObject {

//    private Handler handler;
//    BufferedImage image = null;
//
//    public Platform(int x, int y, ID id) {
//        super(x, y, id);
//        this.handler = StaticFields.handler;
//        velX = 5;
//        velY = 5;
//        width = 75;
//        height = 50;
//        hasGravity = false;
//        isFalling = false;
//        if (image == null) {
//            File file = new File("C:\\Users\\user\\Documents\\NetBeansProjects\\SuperMario\\src\\game.res\\brick.png");
//            try {
//                image = ImageIO.read(file);
//            } catch (IOException ex) {
//                Logger.getLogger(Platform.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//    }
//
//    @Override
//    public Rectangle getBounds() {
//        return new Rectangle(x, y, width, height);
//    }
//
//    @Override
//    public void tick() {
////        x += velX;
////        y += velY;
////        changeDirection();
////        x = clamp(x, 0, Game.WIDTH - width);
////        y = clamp(y, 0, Game.HEIGHT - height);
//    }
//
//    @Override
//    public void render(Graphics g) {
//
//        g.drawImage(image, (int) x, (int) y, width, height, null);
////        g.setColor(Color.MAGENTA);
////        g.fill3DRect(x, y, width, height, true);
//    }
  private final Color color;
    private boolean playerOn = false;

    public Platform(int x, int y, ID id) {
        super(x, y, id);
        this.color = Color.MAGENTA;
        width = 128;
        height = 16;
        hasGravity = false;
        isFalling = false;
    }

    @Override
    public void tick() {
        if (playerOn) {
            x += Math.round(velX);
            GSpace.getPlayer().setX(GSpace.getPlayer().getX() + Math.round(velX));
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(color);
        g.fill3DRect( x,  y, width, height, true);
//        g.drawImage(Animation.platform.get(0),  x,  y, width, height, null);
    }
}

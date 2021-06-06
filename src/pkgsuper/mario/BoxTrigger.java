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
 * @author Sevinc Sarayeva
 */
public class BoxTrigger extends GameObject {

   // private Handler handler;

    public BoxTrigger(int x, int y, ID id) {
        super(x, y, id);
    //    this.handler = StaticFields.handler;
        velX = 5;
        velY = 5;
        width = 100;
        height = 100;
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 16, 16);
    }

//    private void changeDirection() {
//        if (x == Game.WIDTH - width || x == 0) {
//            velX = -velX;
//        }
//        if (y == Game.HEIGHT - height || y == 0) {
//            velY = -velY;
//        }
//    }

    @Override
    public void tick() {
//        x += velX;
//        y += velY;
//        changeDirection();
//        x = clamp(x, 0, Game.WIDTH - width);
//        y = clamp(y, 0, Game.HEIGHT - height);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLUE);
        g.drawRect(x, y, width, height);
    }

}

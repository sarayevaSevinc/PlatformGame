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
public class FastAndUnpredictableEnemy extends GameObject {

    private Handler handler;
   Color color;
    public FastAndUnpredictableEnemy(int x, int y, ID id) {
        super(x, y, id);
        this.handler = StaticFields.handler;
        velX = 10;
        velY = 8;
        width = 30;
        height = 30;
        color = Color.red;
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);

    }

    @Override
    public void tick() {
        x += velX;
        y += velY;
//        x = clamp(x, 0, Game.WIDTH - width);
//        y = clamp(y, 0, Game.HEIGHT - height);
       changeDir();
    }

    private void changeDir() {
        if (x == Game.WIDTH - width || x == 0) {
            velX = -velX;
            color = Color.CYAN;
        }
        if (y == Game.HEIGHT - height || y == 0) {
            velY = -velY;
            color = Color.CYAN;
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, width, height);
    }

}

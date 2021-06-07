/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgsuper.mario;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Shukur
 */
public class Ground extends GameObject {

    public Ground(int x, int y, ID id) {
        super(x, y, id);
    }

    public Ground(int x, int y, ID id, int width, int height) {
        super(x, y, id);
        this.width = width;
        this.height = height;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
       g.setColor(Color.BLUE);
        g.fill3DRect( x,  y, 300, 100, true);
     //g.drawImage(Animation.ground.get(0), x, y, width, height, null);
    
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgsuper.mario;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 *
 * @author user
 */
public class HUD {

    private Player player;
    private int maxHealth;
    private Handler handler;

    public HUD() {
        this.player = StaticFields.player;
        maxHealth = 2 * player.getHealth();
        this.handler = StaticFields.handler;

    }

    public void render(Graphics g) {
        g.setColor(Color.green);
        g.fill3DRect(10, 10, maxHealth, 50, true);
        g.setColor(Color.red);
        g.fill3DRect(2 * player.getHealth() + 10, 10, (200 - 2 * player.getHealth()), 50, true);
        g.setColor(Color.BLACK);
        g.drawString("Player's health: " + player.getHealth(), 100, 50);
        g.setColor(Color.green);
         g.setFont(new Font("Arial", 20, 20));
        g.drawString("Your Coins : " + player.getCoin(), 300, 50);
        this.gameOver(g);
    }

    public void gameOver(Graphics g) {
        if (player.getHealth() <= 0) {
            g.setColor(Color.red);
            g.setFont(new Font("Arial", 40, 40));
            g.drawString("Game Over! You Lost! \n :(", 300, 300);

            handler.deleteAllObjects();
        }
    }
}

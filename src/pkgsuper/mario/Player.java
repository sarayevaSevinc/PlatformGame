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
public class Player extends Character {

    private Handler handler;
    boolean[] keyPressed = new boolean[5];
    private int health;
    private int coin;
    Color color;
    private float speed = 0.05f;
    private float jumping = 5;
    private int counterTrig = 0;
    private boolean onPlatform = false;
    private boolean onAir = false;
    private boolean isJumping = false;

    public Player(int x, int y, ID id) {
        super(x, y, id);
        this.handler = StaticFields.handler;
        velX = 0;
        velY = 0;
        width = 16 * GSpace.multSize;
        height = 16 * GSpace.multSize;
        keyPressed[0] = false;
        keyPressed[1] = false;
        keyPressed[2] = false;
        keyPressed[3] = false;
        keyPressed[4] = false;
        health = 100;
        coin = 0;

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    @Override
    public void tick() {
        System.out.println(" on air : " + onAir + " is Falling " + isFalling + " is Jumping " + isJumping);
        if (velY > 0) {
            isFalling = true;
        }
        checkKeyboard();
        if (onAir) {
            velY += gravity;
        }
        if (isFalling) {
            velY += gravity;
        } else if (velX >= 0) {
            velX -= friction;
        } else {
            velX += friction;
        }
        if (onAir) {
            isJumping = false;
        }
        x += Math.round(velX);
        y += Math.round(velY);
        collision();
        //x = clamp(x, 0, Game.WIDTH - (width + 5));
        // y = clamp(y, 0, Game.HEIGHT - (height + 18));
    }

    public int getHealth() {
        return health;
    }

    public int getCoin() {
        return coin;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, width, height);
    }

    private void checkKeyboard() {
        if (keyPressed[0] && !onAir && !isJumping) {
            velY -= jumping;
            //isFalling = true;
            isJumping = true;
            onAir = true;
        }
        if (!isFalling) {
            if (keyPressed[1]) {
                velX += -speed;
            }

            if (keyPressed[2]) {
                velX += speed;
            }
            if (keyPressed[4]) {
                velY += speed;
            }

        } else {
            if (keyPressed[1]) {
                velX += -speed / 2;
            }
            if (keyPressed[2]) {
                velX += speed / 2;
            }
            if (keyPressed[4]) {
                velY += speed;
            }
        }
    }

//    protected void collision() {
//        isFalling = true;
//        onAir = true;
//        for (int i = 0; i < handler.getObjects().size(); i++) {
//            GameObject temp = handler.getObjects().get(i);
//            if (this.getBounds().intersects(temp.getBounds())) {
//                switch (temp.getId()) {
//                    case platform:
//                        if (temp.getBounds().intersects(getBounds()) && velY > 0) {
//                            isFalling = false;
//                            velY = 0;
//                            y = temp.getY() - height - 2;
//                        }
//                        if (temp.getBounds().intersects(getUnderBounds())) {
//                            isFalling = false;
//                            onAir = false;
//                        }
//                        break;
//                }
//
//            }
//        }
//    }

    private Rectangle getHeadArea() {
        return new Rectangle((int) x + 10, (int) y - 10, 30, 30);
    }

    

//            } else if (temp.getId() == ID.SimpleEnemy) {
//                if (this.getBounds().intersects(temp.getBounds())) {
//                    StaticFields.player.health -= 2;
//                    color = Color.RED;
//                } else {
//                    color = Color.WHITE;
//                }
//            } else if (temp.getId() == ID.Health) {
//                if (this.getBounds().intersects(temp.getBounds())) {
//                    StaticFields.player.health += 10;
//                    StaticFields.player.clamp(StaticFields.player.health, 0, 100);
//                    handler.removeObject(temp);
//                }
//            } else if (temp.getId() == ID.SmartEnemy) {
//                if (this.getBounds().intersects(temp.getBounds())) {
//                    StaticFields.player.health -= 4;
//                    color = Color.RED;
//                    handler.removeObject(temp);
//                    isSmartEnemyExist = false;
//                } else {
//                    color = Color.WHITE;
//                }
//            } else if (temp.getId() == ID.FastEnemy) {
//                if (this.getBounds().intersects(temp.getBounds())) {
//                    StaticFields.player.health -= 5;
//                    color = Color.RED;
//                    handler.removeObject(temp);
//                    isFastEnemyExist = false;
//                } else {
//                    color = Color.WHITE;
//                }
//
//            } else if (temp.getId() == ID.Coin) {
//                if (this.getBounds().intersects(temp.getBounds())) {
//                    StaticFields.player.coin++;
//                    handler.removeObject(temp);
//                }
//            }
//        }
//    }
}

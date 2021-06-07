/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgsuper.mario;;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Shukur
 */
public abstract class Character extends GameObject {

    Handler handler;
    int health = 100;
    int point = 0;
    protected float speed = 0.05f;
    protected float friction = 0.0f;
    protected boolean isJumping;

    public Character(int x, int y, ID id) {
        super(x, y, id);
        this.handler = GSpace.getHandler();
    }

    protected void collision() {
        boolean floating = true;
        for (int i = 0; i < handler.getObjects().size(); i++) {
            GameObject temp = handler.getObjects().get(i);

            switch (temp.getId()) {
                case GROUND:
                    if (getBounds(boundsType.underBounds).intersects(temp.getBounds())) {
                        floating = false;
                        if (!onAir) {
                            isJumping = false;
                        }
                    }

                    if (getBounds().intersects(temp.getBounds())) {

                        if (velY > 0) {
                            if (getBounds(boundsType.downBounds).intersects(temp.getBounds(boundsType.upBounds))) {
                                y = temp.getY() - height;
                                velY = 0;
                                isJumping = false;
                            }
                        } else if (velY < 0) {
                            if (getBounds(boundsType.upBounds).intersects(temp.getBounds(boundsType.downBounds))) {
                                y = temp.getY() + temp.getBounds().height;
                                velY *= -1.2;
                            }
                        }

                        if (velX < 0) {
                            if (getBounds(boundsType.leftBounds).intersects(temp.getBounds())) {
                                x = temp.getX() - temp.getBounds().width;
                                velX = 0;
                            }
                        }

                        if (velX > 0) {
                            if (getBounds(boundsType.rightBounds).intersects(temp.getBounds())) {
                                x = temp.getX() - width;
                                velX = 0;
                            }
                        }
                    }
                    break;
                case SURPRIZE_BOX:
                    if (getBounds(boundsType.underBounds).intersects(temp.getBounds())) {
                        floating = false;
                        if (!onAir) {
                            isJumping = false;
                        }
                    }

                    if (getBounds().intersects(temp.getBounds())) {

                        if (velY > 0) {
                            if (getBounds(boundsType.downBounds).intersects(temp.getBounds(boundsType.upBounds))) {
                                y = temp.getY() - height;
                                velY = 0;
                                isJumping = false;
                            }
                        } else if (velY < 0) {
                            if (getBounds(boundsType.upBounds).intersects(temp.getBounds(boundsType.downBounds))) {
                                y = temp.getY() + temp.getBounds().height;
                                velY += -1.2;
                                health -= 0.2;
//                                ((SurprizeBox).bump(-3));
                                velY = 0.5f;
                            }
                        }

                        if (velX < 0) {
                            if (getBounds(boundsType.leftBounds).intersects(temp.getBounds())) {
                                x = temp.getX() - temp.getBounds().width;
                                velX = 0;
                            }
                        }

                        if (velX > 0) {
                            if (getBounds(boundsType.rightBounds).intersects(temp.getBounds())) {
                                x = temp.getX() - width;
                                velX = 0;
                            }
                        }
                    }
                    break;
                case PLATFORM:
//                    if (getBounds(boundsType.underBounds).intersects(temp.getBounds())) {
//                        floating = false;
//                          isFalling = false;
////                         onAir = false;
//                    }
//
//                    if (getBounds().intersects(temp.getBounds())) {
//
//                        if (velY > 0) {
//                            if (getBounds(boundsType.downBounds).intersects(temp.getBounds(boundsType.upBounds))) {
//                                y = temp.getY() - height;
//                                velY = 0;
//                                isJumping = false;
//                                 isFalling = false;
////                   
//                            }
//                        }
//                    }
//                    break;
                      if (temp.getBounds().intersects(getBounds()) && velY > 0) {
                            isFalling = false;
                            velY = 0;
                            y = temp.getY() - height - 2;
                        }
                        if (temp.getBounds().intersects(getUnderBounds())) {
                            isFalling = false;
                            onAir = false;
             
                        }
                        break;
                case ENEMY:

                    if (getBounds(boundsType.underBounds).intersects(temp.getBounds())) {
                        if (id == ID.PLAYER) {
                            temp.hit(this);
                            velY += 1;
                        }
                    }

            }

        }
        onAir = floating;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

    }
    private Rectangle getUnderBounds() {
        return new Rectangle((int) x + width / 6, (int) (y + height - 5), (int) (width - width / 3), (int) 20);
    }
}

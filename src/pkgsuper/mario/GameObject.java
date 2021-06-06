/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgsuper.mario;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.Serializable;

/**
 *
 * @author Sevinc Sarayeva
 */
public abstract class GameObject implements Serializable{
    protected int x, y;
    protected ID id;
    protected float velX, velY;
    protected int width;
    protected int height;
    protected boolean hasGravity = true;
    protected float gravity = 0.07f;
    protected boolean isFalling = true;  
    

    public GameObject(int x, int y, ID id) {
        this.x = x;
        this.y = y;
        this.id = id;
        width = 10;
        height = 10;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public ID getId() {
        return id;
    }
    public float getVelX() {
        return velX;
    }

    public void setVelX(int velX) {
        this.velX = velX;
    }

    public float getVelY() {
        return velY;
    }

    public void setVelY(int velY) {
        this.velY = velY;
    }
    
    public abstract Rectangle  getBounds();
    public abstract void tick();
    public abstract void render(Graphics g);
    
//    public static int clamp(int num, int min, int max) {
//        return num >= max ? max : num <= min ? min : num;
//    }
}

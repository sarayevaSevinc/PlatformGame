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
public abstract class GameObject implements Serializable {

    protected int x, y;
    protected ID id;
    protected float velX, velY;
    protected int height = 16 * GSpace.multSize;
    protected int width = 16 * GSpace.multSize;
    protected boolean hasGravity = true;
    protected boolean onAir = true;
    protected float gravity = 0.07f;
    protected boolean isFalling = true;
    protected int direction = 1;
    protected final int stateX;
    protected final int stateY;
    protected boolean alive = true;

    protected enum boundsType {
        upBounds, downBounds, rightBounds, leftBounds, underBounds, centerBounds, upSurface;
    }

    public GameObject(int x, int y, ID id) {
        this.x = x;
        this.y = y;
        this.id = id;
        width = 10;
        height = 10;
        this.stateX = x;
        this.stateY = y;
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

    public void setId(ID id) {
        this.id = id;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
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

    public float getGravity() {
        return gravity;
    }

    public void setGravity(float gravity) {
        this.gravity = gravity;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public void hit(GameObject object) {

    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public Rectangle getBounds(boundsType type) {
        switch (type) {
            case upSurface:
                return new Rectangle(x, y, width, height / 4);
            case upBounds:
                return new Rectangle(x + width / 6, y, width - 2 * width / 6, height / 4);
            case downBounds:
                return new Rectangle(x + width / 6, y, width - 2 * width / 6, height / 4 + height / 8);
            case underBounds:
                return new Rectangle(x + width / 6, y + 3 * height / 4, width - 2 * width / 6, height / 4);
            case leftBounds:
                return new Rectangle(x, y + height / 6, width / 4, height - height / 3);
            case rightBounds:
                return new Rectangle(x + width - width / 6, y + height / 6, width / 6, height - height / 3);
            case centerBounds:
                return new Rectangle(x + width / 4, y + height, width / 2, height / 2);
            default:
                return new Rectangle(x, y, width, height);
        }

    }

    public abstract void tick();

    public abstract void render(Graphics g);

    public static int clamp(int num, int min, int max) {
        return num >= max ? max : num <= min ? min : num;
    }
}

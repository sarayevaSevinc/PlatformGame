/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgsuper.mario;

import java.awt.Graphics;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Sevinc Sarayeva
 */
public class Handler implements Serializable{
    private ArrayList<GameObject> objects = new ArrayList<>();

    public void tick(){
        for (int i = 0; i < objects.size(); i++) {
            GameObject tempObject = objects.get(i);
            if(tempObject!= null) tempObject.tick();
            
        }
    }
    public void render(Graphics g){
        for (int i = 0; i < objects.size(); i++) {
             GameObject tempObject = objects.get(i);
             if(tempObject != null) tempObject.render(g);
        }
    }
    public void addObject(GameObject newObject){
        objects.add(newObject);
    }
      public void removeObject(GameObject newObject){
        objects.remove(newObject);
    }

    public ArrayList<GameObject> getObjects() {
        return objects;
    }
     public void  deleteAllObjects() {
       objects = new ArrayList<>();
    }
      
}

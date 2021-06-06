/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgsuper.mario;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author user
 */
public class ImageLoader {
    public static BufferedImage loadImage(String path){
        try{
            return ImageIO.read(ImageLoader.class.getClassLoader().getResource(path));
        }catch(IOException e){
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
}

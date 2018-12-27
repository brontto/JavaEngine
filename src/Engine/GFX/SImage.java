package Engine.GFX;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SImage {

    private int width, height;
    private int offSetWidth, offSetHeight;
    private int[] pixels;



    public SImage(String path){
        this.offSetHeight = 0;
        this.offSetWidth = 0;

        BufferedImage image = null;

        try{
            image = ImageIO.read(SImage.class.getClassLoader().getResourceAsStream(path));
        }catch (IOException e){
            e.printStackTrace();
        }


        width = image.getWidth();
        height = image.getHeight();
        pixels = image.getRGB(0, 0, width, height,null, 0 , width);
    }

    public SImage(String path, int offSetWidth, int offSetHeight){
        this(path);
        this.offSetWidth = offSetWidth;
        this.offSetHeight = offSetHeight;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int[] getPixels() {
        return pixels;
    }

    public void setPixels(int[] pixels) {
        this.pixels = pixels;
    }

    public int getOffSetWidth() {
        return offSetWidth;
    }

    public int getOffSetHeight() {
        return offSetHeight;
    }
}

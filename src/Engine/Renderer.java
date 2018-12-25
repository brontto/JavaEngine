package Engine;

import java.awt.image.DataBufferInt;
import Engine.GFX.SImage;
public class Renderer {

    private int pixelWidth,pixelHeight;
    private int[] pixels;

    public Renderer(Window window){
        pixelWidth = window.getWidth();
        pixelHeight = window.getHeight();
        //basicly memoryaddres to bufferedimages data, if u change this, image will change
        pixels = ((DataBufferInt)window.getBufferedImage().getRaster()
                .getDataBuffer()).getData();
    }

    public void clear(){
        for (int i = 0; i < pixels.length; i++){
            pixels[i] = 0x00000000; //change pixel
        }

    }

    public void setPixel(int x, int y, int value){
        if(x < 0 || x >= pixelWidth || y < 0 || y >= pixelHeight || value == 0xffff00ff){
            return;
        }

        pixels[x + y * pixelWidth] = value;
    }

    public void drawImage(SImage SImage, int offSetX, int offSetY){

        for(int y = 0; y < SImage.getHeight(); y++){
            for(int x = 0; x < SImage.getWidth(); x++){
                setPixel(x + offSetX, y +offSetY, SImage.getPixels()[x + y * SImage.getWidth()]);
            }
        }

    }
}

package Engine;

import java.awt.image.DataBufferInt;

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
            pixels[i] += i; //change pixel
        }

    }
}

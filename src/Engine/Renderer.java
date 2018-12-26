package Engine;

import java.awt.image.DataBufferInt;
import Engine.GFX.SImage;
import Engine.GFX.SImageTile;

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

    public void drawImage(SImage image, int offSetX, int offSetY){

        //if picture is complete out of window, it does not draw
        if(offSetX < -image.getWidth())return;
        if(offSetY < -image.getHeight())return;
        if(offSetX >= pixelWidth)return;
        if(offSetY >= pixelHeight)return;

        int newX = 0;
        int newY = 0;
        int newWidth = image.getWidth();
        int newHeight = image.getHeight();

        //check if picture is part out of window
        //and change those limits for loop
        if(offSetX < 0){newX -= offSetX;}
        if(offSetY < 0){newY -= offSetY;}
        if(newWidth + offSetX >= pixelWidth){
            newWidth -= newWidth + offSetX - pixelWidth;
        }
        if(newHeight + offSetY >= pixelHeight){
            newHeight -= newHeight + offSetY - pixelHeight;
        }

        //draw pixels from picture
        for(int y = newY; y < newHeight; y++){
            for(int x = newX; x < newWidth; x++){
                setPixel(x + offSetX, y +offSetY, image.getPixels()[x + y * image.getWidth()]);
            }
        }
    }


    public void drawImageTile(SImageTile image, int offSetX, int offSetY, int tileX, int tileY){

        //if picture is complete out of window, it does not draw
        if(offSetX < -image.getTileWidth())return;
        if(offSetY < -image.getTileHeight())return;
        if(offSetX >= pixelWidth)return;
        if(offSetY >= pixelHeight)return;

        int newX = 0;
        int newY = 0;
        int newWidth = image.getTileWidth();
        int newHeight = image.getTileHeight();

        //check if picture is part out of window
        //and change those limits for loop
        if(offSetX < 0){newX -= offSetX;}
        if(offSetY < 0){newY -= offSetY;}
        if(newWidth + offSetX >= pixelWidth){
            newWidth -= newWidth + offSetX - pixelWidth;
        }
        if(newHeight + offSetY >= pixelHeight){
            newHeight -= newHeight + offSetY - pixelHeight;
        }


        //draw pixels from picture
        for(int y = newY; y < newHeight; y++){
            for(int x = newX; x < newWidth; x++){
                setPixel(x + offSetX, y +offSetY,
                        image.getPixels()[(x + tileX * image.getTileWidth()) + (y + tileY * image.getTileHeight()) * image.getWidth()]);
            }
        }
    }
}

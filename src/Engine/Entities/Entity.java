package Engine.Entities;

import Engine.GFX.SImage;
import Engine.Renderer;

import java.util.ArrayList;

public class Entity {

    public int positionX, positionY;
    public ArrayList<Component> components;
    public ArrayList<SImage> images;


    //TODO: some way to add components on object
    //TODO: something like "getcomponent" method
    public Entity(int positionX, int positionY){
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public void update(){
        for (Component comp: components) {
            comp.update();
        }
    }

    public void render(Renderer renderer){
        for (SImage ima: images) {
            renderer.drawImage(ima, positionX + ima.getOffSetWidth(), positionY + ima.getOffSetHeight());
        }
    }
}

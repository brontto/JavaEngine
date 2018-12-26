package Game;

import Engine.Entities.Entity;
import Engine.GFX.SImage;
import Engine.GFX.SImageTile;
import Engine.GameLoop;
import Engine.Input;
import Engine.Renderer;
import Engine.Window;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Game extends AbstractGame {

    private Window window;
    private Renderer renderer;
    private Input input;

    private SImage ukkeli;
    private SImageTile explosion;
    private boolean explode = false;
    public static ArrayList<Entity> entities;


    public Game(Window window, Renderer renderer, Input input){
        this.window = window;
        this.renderer = renderer;
        this.input = input;

        this.entities = new ArrayList<>();

        this.ukkeli = new SImage("Recource\\ukkeli.png");
        this.explosion = new SImageTile("Recource\\explosion.png", 10, 10);



    }

    float temp = 0;

    @Override
    public void start() {
        System.out.println("game starting");
    }

    @Override
    public void update() {
        if(input.isKey(KeyEvent.VK_C)){

            System.out.println("C is pressed");
            explode = true;
        }else{
            explode = false;
        }
        temp += GameLoop.UPDATE_CAP * 10;
        if(temp > 3){
            temp = 0;
        }
    }

    @Override
    public void render() {
        renderer.drawImage(ukkeli, input.getMouseX() - 10, input.getMouseY() - 10);
        if(explode == true){
            renderer.drawImageTile(explosion, input.getMouseX() + 10, input.getMouseY() + 5,
                    (int)temp,0);
        }
    }
}

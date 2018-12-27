package Game;

import Engine.Entities.Entity;
import Engine.GFX.SImage;
import Engine.GFX.SImageTile;
import Engine.GameLoop;
import Engine.Input;
import Engine.Renderer;
import Engine.Window;
import Game.Components.MovePositionComponent;

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

        Entity ent = new Entity(Input.getMouseX(), Input.getMouseY());
        ent.addImage(new SImage("Recource\\ukkeli.png", -10, -10));
        ent.addComponent(new MovePositionComponent(ent));

        this.entities.add(ent);
    }



    @Override
    public void start() {
        System.out.println("game starting");
    }

    @Override
    public void update() {
        for (Entity ent: entities) {
            ent.update();
        }
    }

    @Override
    public void render() {
        for (Entity ent: entities) {
            ent.render(renderer);
        }
    }
}

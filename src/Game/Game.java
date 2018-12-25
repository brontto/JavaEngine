package Game;

import Engine.GFX.SImage;
import Engine.Input;
import Engine.Renderer;
import Engine.Window;

import java.awt.event.KeyEvent;

public class Game extends AbstractGame {

    private Window window;
    private Renderer renderer;
    private Input input;

    private SImage SImage;

    public Game(Window window, Renderer renderer, Input input){
        this.window = window;
        this.renderer = renderer;
        this.input = input;

        SImage = new SImage("Recource\\ukkeli.png");

    }

    @Override
    public void update() {
        if(input.isKey(KeyEvent.VK_C)){

            System.out.println("C is pressed");
        }

    }

    @Override
    public void render() {
        renderer.drawImage(SImage, input.getMouseX(), input.getMouseY());
    }
}

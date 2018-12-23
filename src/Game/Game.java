package Game;

import Engine.Input;
import Engine.Renderer;
import Engine.Window;

import java.awt.event.KeyEvent;

public class Game extends AbstractGame {

    private Window window;
    private Renderer renderer;
    private Input input;

    public Game(Window window, Renderer renderer, Input input){
        this.window = window;
        this.renderer = renderer;
        this.input = input;
    }

    @Override
    public void update() {
        if(input.isKey(KeyEvent.VK_C)){

            System.out.println("C is pressed");
        }

    }

    @Override
    public void render() {

    }
}

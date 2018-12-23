import Engine.GameLoop;
import Engine.Input;
import Engine.Renderer;
import Engine.Window;
import Game.Game;

public class Main {

    public static void main(String[]args){

        Window window = new Window();
        Renderer renderer = new Renderer(window);
        Input input = new Input(window);
        Game game = new Game(window, renderer, input);
        GameLoop loop = new GameLoop(window, renderer, input, game);
        loop.start();

    }
}

public class Main {

    public static void main(String[]args){


        Window window = new Window();
        Renderer renderer = new Renderer(window);
        Input input = new Input(window);
        GameLoop loop = new GameLoop(window, renderer, input);
        loop.start();

    }
}

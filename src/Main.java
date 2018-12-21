public class Main {

    public static void main(String[]args){


        Window window = new Window();
        Renderer renderer = new Renderer(window);
        GameLoop loop = new GameLoop(window, renderer);
        loop.start();

    }
}

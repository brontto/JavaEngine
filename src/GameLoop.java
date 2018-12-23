import java.awt.event.KeyEvent;

public class GameLoop implements Runnable{

    private Thread thread;

    private boolean running = false;
    private final double UPDATE_CAP = 1.0/60.0;

    private Window window;
    private Renderer renderer;
    private Input input;

    public GameLoop(Window window, Renderer renderer, Input input){
        this.window = window;
        this.renderer = renderer;
        this.input = input;
    }

    public void start(){
        thread = new Thread(this);
        thread.run();
    }

    public void stop(){

    }

    @Override
    public void run() {

        running = true;

        boolean render = false;
        double firstTime = 0;
        double lastTime = System.nanoTime() / 1000000000.0;
        double passedTime = 0;
        double unprocessedTime = 0;

        //FPS calculation
        int framePerSecond = 0;
        double frameTime = 0;
        int frames = 0;

        while(running){
            render = false;

            firstTime = System.nanoTime() / 1000000000.0;
            passedTime = firstTime - lastTime;
            lastTime = firstTime;

            unprocessedTime +=passedTime;
            frameTime +=passedTime;


            while(unprocessedTime >= UPDATE_CAP){
                //tyhjentää frame jonon
                unprocessedTime -= UPDATE_CAP;
                render = true;
                //TODO: update game

                if(input.isKey(KeyEvent.VK_C)){

                    System.out.println("C is pressed");
                }

                input.InputUpdate();

                if(frameTime >= 1.0){
                    frameTime = 0;
                    framePerSecond = frames;
                    frames = 0;
                    System.out.println("FPS: " + framePerSecond);
                }
            }

            if(render){
                frames++;
                window.UpdateWindow();
                renderer.clear();
                //TODO: render game
            } else {
                try{
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void dispose(){


    }
}

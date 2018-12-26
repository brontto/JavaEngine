package Engine;

import Game.AbstractGame;

import java.awt.event.KeyEvent;

public class GameLoop implements Runnable{

    private Thread thread;

    private boolean running = false;
    public static double UPDATE_CAP = 1.0/60.0;

    private Window window;
    private Renderer renderer;
    private Input input;
    private AbstractGame game;


    public GameLoop(Window window, Renderer renderer, Input input, AbstractGame game){
        this.window = window;
        this.renderer = renderer;
        this.input = input;
        this.game = game;
    }

    public void start(){
        thread = new Thread(this);
        thread.run();
        game.start();
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

        //for FPS meter
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

                game.update();
                input.InputUpdate();

                //FPS meter
                if(frameTime >= 1.0){
                    frameTime = 0;
                    framePerSecond = frames;
                    frames = 0;
                    System.out.println("FPS: " + framePerSecond);
                }
            }

            //rending new sitsuation
            if(render){
                frames++;
                window.UpdateWindow();

                renderer.clear();
                game.render();

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

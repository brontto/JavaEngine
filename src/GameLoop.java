
public class GameLoop implements Runnable{

    private Thread thread;

    private boolean running = false;
    private final double UPDATE_CAP = 1.0/60.0;

    public GameLoop(){


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


        while(running){
            render = false;

            firstTime = System.nanoTime() / 1000000000.0;
            passedTime = firstTime - lastTime;
            lastTime = firstTime;

            unprocessedTime +=passedTime;

            while(unprocessedTime >= UPDATE_CAP){

                unprocessedTime -= UPDATE_CAP;
                render = true;
                //TODO: update game
                System.out.println("update");
            }

            if(render){

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

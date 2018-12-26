package Engine;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Window {



    private int width = 320, height = 240;
    private float scale = 4f;
    private String title = "Stegadon Engine v. 0.9";

    private JFrame frame;


    private BufferedImage bufferedImage;
    private Canvas canvas;
    private BufferStrategy bufferStrategy;
    private Graphics graphics;

    public Window(){

        bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        canvas = new Canvas();

        Dimension dim = new Dimension((int)(width * scale), (int)(height * scale));
        canvas.setPreferredSize(dim);
        canvas.setMaximumSize(dim);
        canvas.setMinimumSize(dim);

        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(canvas, BorderLayout.CENTER);
        frame.pack();//pakkaa framen canvaksen kokoiseksi
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        canvas.createBufferStrategy(2);
        bufferStrategy = canvas.getBufferStrategy();
        graphics = bufferStrategy.getDrawGraphics();

    }

    public void UpdateWindow(){
        graphics.drawImage(bufferedImage, 0, 0, canvas.getWidth(),
                canvas.getHeight(),null);
        bufferStrategy.show();
    }

    public float getScale(){return scale;}

    public int getWidth() { return width; }

    public int getHeight() {
        return height;
    }

    public JFrame getFrame() {return frame; }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    public Canvas getCanvas(){
        return canvas;
    }

}


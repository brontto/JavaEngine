package Engine;

import java.awt.event.*;

public class Input implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener {

    private static final int NUM_KEYS = 256;
    private static boolean[] keys = new boolean[NUM_KEYS];
    private static boolean[] keysInLastFrame = new boolean[NUM_KEYS];

    private static final int NUM_BUTTONS = 5;
    private static boolean[] buttons = new boolean[NUM_BUTTONS];
    private static boolean[] buttonsInLastFrame = new boolean[NUM_BUTTONS];

    private static int mouseX, mouseY;
    private static int scroll;

    private Window window;

    public Input(Window window){
        mouseX = 0;
        mouseY = 0;
        scroll = 0;

        this.window = window;

        window.getCanvas().addKeyListener(this);
        window.getCanvas().addMouseMotionListener(this);
        window.getCanvas().addMouseListener(this);
        window.getCanvas().addMouseWheelListener(this);



    }



    public static boolean isKey(int keyCode){
        return keys[keyCode];
    }

    public static boolean isKeyUp(int keyCode){
        return !keys[keyCode] && keysInLastFrame[keyCode];
    }

    public static boolean isKeyDown(int keyCode){
        return keys[keyCode] && keysInLastFrame[keyCode];
    }

    public static boolean isButton(int button){
        return buttons[button];
    }

    public static boolean isButtonUp(int button){
        return !buttons[button] && buttonsInLastFrame[button];
    }

    public static boolean isButtonDown(int button){
        return buttons[button] && !buttonsInLastFrame[button];
    }



    public void InputUpdate(){
        for (int i= 0; i < NUM_KEYS; i++){
            keysInLastFrame[i] = keys[i];
        }
        for (int i = 0; i < NUM_BUTTONS; i++) {
            buttonsInLastFrame[i] = buttons[i];
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        buttons[e.getButton()] = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mouseX = (int)(e.getX() / window.getScale());
        mouseY = (int)(e.getY() / window.getScale());
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = (int)(e.getX() / window.getScale());
        mouseY = (int)(e.getY() / window.getScale());
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        scroll = e.getWheelRotation();
    }

    public static int getMouseX() {
        return mouseX;
    }

    public static int getMouseY() {
        return mouseY;
    }

    public static int getScroll() {
        return scroll;
    }
}

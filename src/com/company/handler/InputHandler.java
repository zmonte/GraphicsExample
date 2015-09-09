package com.company.handler;

import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 7/9/13
 * Time: 9:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class InputHandler implements KeyListener, MouseListener,
        MouseMotionListener, MouseWheelListener, FocusListener {

    public static final InputHandler SINGLETON = new InputHandler();

    private static HashMap<Integer, Key> keyMap = new HashMap<Integer, Key>();
    private static boolean mousePressed = false;
    private static Point mouseLocation = new Point(-1, -1);
    private static int mouseButton = -1;
    private static int mouseRotation = 0;

    // Keyboard
    public static boolean keyIsDown(int key) {
        return (keyMap.get(key) != null);
    }

    // Mouse
    public static boolean mouseIsPressed() {
        return mousePressed;
    }

    public static Point getMouseLocation() {
        return mouseLocation;
    }

    public static int getMouseButton() {
        return mouseButton;
    }

    public static int getMouseButtonRotation() {
        return mouseRotation;
    }

    // Key Listener
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        Key last = keyMap.get(e.getKeyCode());
        if (last == null)
            keyMap.put(e.getKeyCode(),
                    new Key(e.getKeyCode(), System.currentTimeMillis()));
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keyMap.put(e.getKeyCode(), null);
    }

    // Mouse Listener
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (!mousePressed) {
            mousePressed = true;
            mouseButton = e.getButton();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (mousePressed) {
            mousePressed = false;
            mouseButton = -1;
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    // MouseMotion Listener
    @Override
    public void mouseDragged(MouseEvent e) {
        mouseLocation = e.getPoint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseLocation = e.getPoint();
    }

    // MouseWheel Listener
    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        if (!e.isAltDown()) {
            if (e.getWheelRotation() == -1) {
                mouseRotation = 1;
                System.out.println(mouseRotation);
            } else if (e.getWheelRotation() == 1) {
                mouseRotation = -1;
                System.out.println(mouseRotation);
            }
        }
    }

    // Focus Listener
    @Override
    public void focusGained(FocusEvent e) {

    }

    @Override
    public void focusLost(FocusEvent e) {

    }

    private class Key {

        private int code;
        private long time;

        public Key(int code, long time) {
            this.code = code;
            this.time = time;
        }

        public int getCode() {
            return code;
        }

        public long getTime() {
            return time;
        }

    }
}

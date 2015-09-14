package com.company;

import com.company.renderable.Renderable;
import com.company.util.Timer;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 7/9/13
 * Time: 9:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class Engine extends Thread {

    private static boolean isRunning;
    private static boolean isPaused;
    private static double fps;
    private Timer timer;
    private Canvas canvas;
    private Window window;
    private double delta;

    public Engine(Canvas canvas) {
        this.canvas = canvas;
        this.timer = new Timer();

        timer.init();
        isRunning = true;
    }

    public static double getFps() {
        return fps;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public boolean isPaused() {
        return isPaused;
    }

    public void setPaused(boolean isPaused) {
        this.isPaused = isPaused;
    }

    public void setWindow(Window window) {
        this.window = window;
    }

    public void run() {
        while (isRunning) {
            delta = timer.getDelta();
            fps = timer.getFPS();

            if (isPaused) {
                // PAUSED
            } else {

            }

            for (Renderable renderable : Window.objects) {
                renderable.tick(isPaused ? 0 : delta);
            }
            canvas.render();
        }
        window.dispose();
    }
}

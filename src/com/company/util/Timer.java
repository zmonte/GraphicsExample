package com.company.util;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 7/9/13
 * Time: 9:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class Timer {
    private long lastFrame;
    private double fps;
    private long lastFPS;

    public long getTime() {
        return System.nanoTime();
    }

    public double getDelta() {
        long time = System.nanoTime();
        double delta = time - lastFrame;
        lastFrame = time;
        return delta / 1000000;
    }

    public void init() {
        getDelta();
        getFPS();
    }

    public double getFPS() {
        long time = System.nanoTime();
        double delta = time - lastFPS;
        lastFPS = time;
        fps = 1 / (delta / 1000000000);
        return fps;
    }
}

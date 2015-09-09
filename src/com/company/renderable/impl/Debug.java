package com.company.renderable.impl;

import com.company.Engine;
import com.company.handler.InputHandler;
import com.company.renderable.Renderable;

import java.awt.*;
import java.text.DecimalFormat;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 7/10/13
 * Time: 1:02 AM
 * To change this template use File | Settings | File Templates.
 */
public class Debug extends Renderable {
    DecimalFormat format = new DecimalFormat("000.00");
    double lastTime;
    private double delta = 0;
    private double mouseX = window.getWidth() / 2;
    private double mouseY = window.getHeight() / 2;
    private double frequency = 150;
    private double fps = 0;
    private double vel = 0;
    private double acc = -9.8;
    private double radius = 20;
    private double theta = 0;
    private double animationFactor = 0.1;

    public Debug() {

    }

    @Override
    public void tick(double delta) {
        this.delta = delta;
        this.mouseX = InputHandler.getMouseLocation().getX();
        this.mouseY = InputHandler.getMouseLocation().getY();

        if (lastTime == 0) {
            lastTime = System.currentTimeMillis();
        } else if ((System.currentTimeMillis() - lastTime) >= frequency) {
            this.fps = Engine.getFps();
            lastTime = 0;
        }

        theta += delta * animationFactor % 360;

        vel += acc * delta;
        radius += 0.5 * vel * delta;
        if (radius <= 0)
            radius = 20;
    }

    @Override
    public void render(Graphics2D g) {
        g.setColor(new Color(0, 255, 0));
        g.drawString("X: " + this.mouseX + "Y: " + this.mouseY, 10, 10);
        g.drawString("FPS: " + format.format(fps), 20, 40);
        g.drawString("Delta: " + delta, 200, 40);
        g.setColor(new Color(0, 255, 0));
        g.drawLine((int) (mouseX - (radius * Math.cos(Math.toRadians(theta)))), (int) (mouseY - (radius * Math.sin(Math.toRadians(theta)))), (int) (mouseX + ((-1 * radius / 2) * Math.cos(Math.toRadians(theta)))), (int) (mouseY + ((-1 * radius / 2) * Math.sin(Math.toRadians(theta)))));
        g.drawLine((int) (mouseX - (radius * Math.cos(Math.toRadians(theta + 90)))), (int) (mouseY - (radius * Math.sin(Math.toRadians(theta + 90)))), (int) (mouseX + ((-1 * radius / 2) * Math.cos(Math.toRadians(theta + 90)))), (int) (mouseY + ((-1 * radius / 2) * Math.sin(Math.toRadians(theta + 90)))));
        g.drawLine((int) (mouseX - (radius * Math.cos(Math.toRadians(theta + 180)))), (int) (mouseY - (radius * Math.sin(Math.toRadians(theta + 180)))), (int) (mouseX + ((-1 * radius / 2) * Math.cos(Math.toRadians(theta + 180)))), (int) (mouseY + ((-1 * radius / 2) * Math.sin(Math.toRadians(theta + 180)))));
        g.drawLine((int) (mouseX - (radius * Math.cos(Math.toRadians(theta + 270)))), (int) (mouseY - (radius * Math.sin(Math.toRadians(theta + 270)))), (int) (mouseX + ((-1 * radius / 2) * Math.cos(Math.toRadians(theta + 270)))), (int) (mouseY + ((-1 * radius / 2) * Math.sin(Math.toRadians(theta + 270)))));
        g.drawOval((int) this.mouseX - (int) radius, (int) mouseY - (int) radius, (int) radius * 2, (int) radius * 2);
        g.setColor(new Color(255, 255, 255, (int) (Math.abs(Math.random()) * 1000000) % 150));
        g.drawLine(window.getWidth() / 2 - 5, window.getHeight() / 2, window.getWidth() / 2 + 5, window.getHeight() / 2);
        g.drawLine(window.getWidth() / 2, window.getHeight() / 2 - 5, window.getWidth() / 2, window.getHeight() / 2 + 5);
    }
}

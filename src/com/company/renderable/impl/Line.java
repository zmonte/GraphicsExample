package com.company.renderable.impl;

import com.company.renderable.Renderable;
import com.company.util.Vector2d;

import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: Zach Monte
 * Date: 7/9/13
 * Time: 10:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class Line extends Renderable {
    private int x = 0;
    private int y = 0;
    private int x1 = 100;
    private int y1 = 100;

    public Line() {
    }

    @Override
    public void tick(double delta) {
    }

    @Override
    public void render(Graphics2D g) {
        g.setColor(Color.PINK);
        g.drawLine(x, y, x1, y1);
    }
}

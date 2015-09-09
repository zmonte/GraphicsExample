package com.company.renderable.impl;

import com.company.renderable.Renderable;
import com.company.util.RenderEngine3D;
import com.company.util.Vector2d;
import com.company.util.Vector3d;

import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 7/9/13
 * Time: 10:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class CubeTest extends Renderable {

    private double padFactor = 50;
    private ArrayList<Vector3d> cube = new ArrayList<Vector3d>();
    private RenderEngine3D renderEngine3D = new RenderEngine3D();
    private double theta = 0;
    private double delta = 0;
    private double animationFactor = 0.01;
    private boolean canRender = false;
    private double frequency = 100;
    private double lastTime = 0;
    private double size = 10.0;
    private double resolution = 0.5;
    private Vector2d lastPoint;

    public CubeTest() {
        /*for (int i = -5; i <= 5; i++) {
            for (int ii = -5; ii <= 5; ii++) {
                for (int iii = -5; iii <= 5; iii++) {
                    if (Math.abs(i) == 5 || Math.abs(ii) == 5 || Math.abs(iii) == 5)
                        cube.add(new Vector3d(i * padFactor, ii * padFactor, iii * padFactor));
                }
            }
        }*/
        for (double i = -size; i <= size; i += resolution) {
            for (double ii = -size; ii <= size; ii += resolution) {
                for (double iii = -size; iii <= size; iii += resolution) {
                    if (Math.abs(5 - (Math.abs(Math.sqrt((i * i) + (ii * ii) + (iii * iii))))) <= resolution)
                        cube.add(new Vector3d(i * padFactor, ii * padFactor, iii * padFactor));
                    //if (Math.abs(i) == 5.0 || Math.abs(ii) == 5.0 || Math.abs(iii) == 5.0)
                        //cube.add(new Vector3d(i * padFactor, ii * padFactor, iii * padFactor));
                }
            }
        }
        canRender = true;
    }

    @Override
    public void tick(double delta) {
        this.delta = delta;
        theta += delta * animationFactor % 360;
    }

    @Override
    public void render(Graphics2D g) {
        if (canRender)
            for (Vector3d point : cube) {
                g.setColor(new Color(54, 76, (int) Math.abs(point.z / 100.0 * 250.0 % 250), 150));
                drawPoint(renderEngine3D.project(renderEngine3D.rotX(renderEngine3D.rotY(renderEngine3D.rotZ(point, theta), theta), theta), window.getWidth() / 2, window.getHeight() / 2), g);
            }
    }

    private void drawPoint(Vector2d point, Graphics2D g) {
        /*Shape line = new Line2D.Double(point.x, point.y, point.x, point.y);
        g.setColor(new Color(255, 255, 255));
        g.draw(line);*/
        g.drawLine((int) point.x, (int) point.y, (int) point.x, (int) point.y);
        /*if (lastPoint != null) {
            g.drawLine((int) point.x, (int) point.y, (int) lastPoint.x, (int) lastPoint.y);
        }
        if (!point.equals(lastPoint)) {
            lastPoint = point;
        }*/
    }
}

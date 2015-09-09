package com.company;

import com.company.renderable.Renderable;
import com.company.renderable.impl.CubeTest;
import com.company.renderable.impl.Debug;
import com.company.renderable.impl.Line;
import com.company.util.RenderEngine3D;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 7/9/13
 * Time: 9:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class Window extends Frame {

    private static final String DEFAULT_TITLE = "Default Window";
    private static final Dimension DEFAULT_DIM = new Dimension(800, 600);
    private Engine engine;
    private Canvas canvas;
    public static ConcurrentLinkedQueue<Renderable> objects = new ConcurrentLinkedQueue<Renderable>();

    public Window(String title, Dimension dim) {
        super(title);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                engine.setRunning(false);
            }
        });

        setSize(dim);
        setPreferredSize(dim);
        setResizable(false);
        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB), new Point(0, 0), "Cursor"));
        setLocationRelativeTo(null);
        setIgnoreRepaint(true);
        requestFocus();
        pack();
        initObjects();
        setVisible(true);
    }

    public Window() {
        this(DEFAULT_TITLE, DEFAULT_DIM);
    }

    public Point getCenter(Dimension bounds) {
        return new Point((int) ((getWidth() - bounds.getWidth()) / 2), (int) ((getHeight() - bounds.getHeight()) / 2));
    }

    public Point getCenter(int width, int height) {
        return getCenter(new Dimension(width, height));
    }

    public Point getCenter() {
        return getCenter(new Dimension(0, 0));
    }

    private void initObjects() {
        RenderEngine3D.setWindow(this);
        Renderable.setWindow(this);
        canvas = new Canvas(this);
        engine = new Engine(canvas);
        engine.setWindow(this);
        engine.start();

        //new Renderable impl();
        new CubeTest();
        new Debug();
        //new Line();
    }

    public Engine getEngine() {
        return engine;
    }

    public Canvas getCanvas() {
        return canvas;
    }

}

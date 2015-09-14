package com.company;

import com.company.filter.impl.GaussianFilter;
import com.company.filter.impl.GlowFilter;
import com.company.filter.impl.MotionBlurFilter;
import com.company.renderable.Renderable;
import com.company.handler.InputHandler;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.VolatileImage;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Zach Monte
 * Date: 7/9/13
 * Time: 9:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class Canvas extends java.awt.Canvas {

    private static Map<RenderingHints.Key, Object> renderingHints = new HashMap<RenderingHints.Key, Object>();
    private Window window;
    private BufferStrategy strategy;
    private BufferedImage offScreen;
    private VolatileImage vi;
    private BufferedImage bi;
    private GlowFilter glow = new GlowFilter();
    private GaussianFilter gaussian = new GaussianFilter();

    public Canvas(Window window) {
        this.window = window;

        setIgnoreRepaint(true);
        setSize(window.getSize());
        setBackground(Color.BLACK);
        setBounds(0, 0, getWidth(), getHeight());
        window.add(this, BorderLayout.CENTER);

        addKeyListener(InputHandler.SINGLETON);
        addMouseListener(InputHandler.SINGLETON);
        addMouseMotionListener(InputHandler.SINGLETON);
        addMouseWheelListener(InputHandler.SINGLETON);
        addFocusListener(InputHandler.SINGLETON);

        vi = createVolatileImage(getWidth(), getHeight());
        createBufferStrategy(3);
        strategy = getBufferStrategy();
        updateOffscreen();
    }

    private void updateOffscreen() {
        if (offScreen == null || offScreen.getWidth() != getWidth() || offScreen.getHeight() != getHeight()) {
            offScreen = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        }
    }

    public BufferedImage getRenderedImage() {
        updateOffscreen();
        Graphics2D g = offScreen.createGraphics();
        render(g);
        return offScreen;
    }

    public void render() {
        render(null);
    }

    /*public void render(Graphics2D g) {
        if (g == null) {
            g = (Graphics2D) strategy.getDrawGraphics();
        }

        g.clearRect(0, 0, getWidth(), getHeight());
        g.setPaint(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setRenderingHints(renderingHints);

        for (Renderable renderable : Window.objects) {
            if (renderable.getShouldDestroy())
                Window.objects.remove(renderable);

            if (renderable.isVisible())
                renderable.render(g);
        }

        g.dispose();
        strategy.show();
        Toolkit.getDefaultToolkit().sync();
    }*/

    public void render(Graphics2D g) {
        do {
            do {
                g = (Graphics2D) strategy.getDrawGraphics();
                g.setRenderingHints(renderingHints);
                vi = createVolatileImage(getWidth(), getHeight());
                bi = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration().createCompatibleImage(getWidth(), getHeight());
                vi.getGraphics().fillRect(0, 0, vi.getWidth(), vi.getHeight());

                for (Renderable renderable : Window.objects) {
                    if (renderable.getShouldDestroy())
                        Window.objects.remove(renderable);
                    if (renderable.isVisible())
                        renderable.render((Graphics2D) vi.getGraphics());
                }

                bi.getGraphics().drawImage(vi.getSnapshot(), 0, 0, getWidth(), getHeight(), null);
                bi = vi.getSnapshot();
                g.drawImage(bi, 0, 0, getWidth(), getHeight(), null);
                g.dispose();
                Toolkit.getDefaultToolkit().sync();
            } while (strategy.contentsRestored());
            strategy.show();
        } while (strategy.contentsLost());
    }

    static {
        renderingHints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        renderingHints.put(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        renderingHints.put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        System.setProperty("sun.java2d.transaccel", "True");
        // System.setProperty("sun.java2d.trace", "timestamp,log,count");
        // System.setProperty("sun.java2d.opengl", "True");
        System.setProperty("sun.java2d.d3d", "True");
        System.setProperty("sun.java2d.ddforcevram", "True");
    }

}

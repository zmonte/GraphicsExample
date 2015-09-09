package com.company.renderable;

import com.company.Window;
import com.company.Engine;

import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 7/9/13
 * Time: 9:13 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class Renderable {

    protected static Window window;
    private boolean isVisible = true;
    private boolean shouldDestroy;

    public Renderable() {
        window.objects.add(this);
    }

    public static void setWindow(com.company.Window newWindow) {
        window = newWindow;
    }

    public static Window getWindow() {
        return window;
    }

    public Engine getEngine() {
        return window.getEngine();
    }

    public Canvas getCanvas() {
        return window.getCanvas();
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    public boolean isVisible() {
        return isVisible;
    };

    public void setShouldDestroy(boolean shouldDestroy) {
        this.shouldDestroy = shouldDestroy;
    }

    public boolean getShouldDestroy() {
        return shouldDestroy;
    }

    /**
     * Called every tick in game engine.
     */
    public abstract void tick(double delta);

    /**
     * Renders this object using the provided Graphics2D object.
     */
    public abstract void render(Graphics2D g);

}

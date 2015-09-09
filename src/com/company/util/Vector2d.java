package com.company.util;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 7/9/13
 * Time: 10:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class Vector2d {
    public double x;
    public double y;

    public Vector2d() {
    }

    public Vector2d(double v, double v1) {
        x = v;
        y = v1;
    }

    public Vector2d(Vector2d vector2d) {
        x = vector2d.x;
        y = vector2d.y;
    }

    public void set(Vector2d vector2d) {
        x = vector2d.x;
        y = vector2d.y;
    }

    public void set(double v, double v1) {
        x = v;
        y = v1;
    }

    public Vector2d add(Vector2d vector2d) {
        Vector2d sum = new Vector2d();
        sum.x = x + vector2d.x;
        sum.y = y + vector2d.y;
        return sum;
    }

    public Vector2d subtract(Vector2d vector2d) {
        Vector2d difference = new Vector2d();
        difference.x = x - vector2d.x;
        difference.y = y - vector2d.y;
        return difference;
    }

    public Vector2d multiply(double d) {
        Vector2d product = new Vector2d();
        product.x = x * d;
        product.y = y * d;
        return product;
    }

    public double dot(Vector2d vector2d) {
        return vector2d.x * x + vector2d.y * y;
    }

    public Vector2d divide(double d) {
        Vector2d quotient = new Vector2d();
        quotient.x = x / d;
        quotient.y = y / d;
        return quotient;
    }

    public boolean equals(Object object) {
        if (object instanceof Vector2d) {
            Vector2d vec = (Vector2d) object;
            return (vec.x == x && vec.y == y);
        }
        return false;
    }

    public double length() {
        StringBuilder builder = new StringBuilder();
        builder.append(x);
        builder.append(y);
        return builder.length();
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("x: ");
        builder.append(x);
        builder.append(" y: ");
        builder.append(y);
        return builder.toString();
    }
}

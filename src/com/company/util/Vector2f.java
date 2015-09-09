package com.company.util;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 7/9/13
 * Time: 9:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class Vector2f {
    public float x;
    public float y;

    public Vector2f() {
    }

    public Vector2f(float v, float v1) {
        x = v;
        y = v1;
    }

    public Vector2f(Vector2f vector2f) {
        x = vector2f.x;
        y = vector2f.y;
    }

    public void set(Vector2f vector2f) {
        x = vector2f.x;
        y = vector2f.y;
    }

    public void set(float v, float v1) {
        x = v;
        y = v1;
    }

    public Vector2f add(Vector2f vector2f) {
        Vector2f sum = new Vector2f();
        sum.x = x + vector2f.x;
        sum.y = y + vector2f.y;
        return sum;
    }

    public Vector2f subtract(Vector2f vector2f) {
        Vector2f difference = new Vector2f();
        difference.x = x - vector2f.x;
        difference.y = y - vector2f.y;
        return difference;
    }

    public Vector2f multiply(float f) {
        Vector2f product = new Vector2f();
        product.x = x * f;
        product.y = y * f;
        return product;
    }

    public float dot(Vector2f vector2f) {
        return vector2f.x * x + vector2f.y * y;
    }

    public Vector2f divide(float f) {
        Vector2f quotient = new Vector2f();
        quotient.x = x / f;
        quotient.y = y / f;
        return quotient;
    }

    public boolean equals(Object object) {
        if (object instanceof Vector2f) {
            Vector2f vec = (Vector2f) object;
            return (vec.x == x && vec.y == y);
        }
        return false;
    }

    public float length() {
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

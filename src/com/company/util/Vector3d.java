package com.company.util;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 7/9/13
 * Time: 10:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class Vector3d {
    public double x;
    public double y;
    public double z;

    public Vector3d() {
    }

    public Vector3d(double v, double v1, double v2) {
        x = v;
        y = v1;
        z = v2;
    }

    public Vector3d(Vector3d vector3d) {
        x = vector3d.x;
        y = vector3d.y;
        z = vector3d.z;
    }

    public void set(Vector3d vector3d) {
        x = vector3d.x;
        y = vector3d.y;
        z = vector3d.z;
    }

    public void set(double v, double v1, double v2) {
        x = v;
        y = v1;
        z = v2;
    }

    public Vector3d add(Vector3d vector3d) {
        Vector3d sum = new Vector3d();
        sum.x = x + vector3d.x;
        sum.y = y + vector3d.y;
        sum.z = z + vector3d.z;
        return sum;
    }

    public Vector3d subtract(Vector3d vector3d) {
        Vector3d difference = new Vector3d();
        difference.x = x - vector3d.x;
        difference.y = y - vector3d.y;
        difference.z = z - vector3d.z;
        return difference;
    }

    public Vector3d multiply(double d) {
        Vector3d product = new Vector3d();
        product.x = x * d;
        product.y = y * d;
        product.z = z * d;
        return product;
    }

    public double dot(Vector3d vector3d) {
        return vector3d.x * x + vector3d.y * y + vector3d.z * z;
    }

    public Vector3d divide(double d) {
        Vector3d quotient = new Vector3d();
        quotient.x = x / d;
        quotient.y = y / d;
        quotient.z = z / d;
        return quotient;
    }

    public boolean equals(Object object) {
        if (object instanceof Vector3d) {
            Vector3d vec = (Vector3d) object;
            return (vec.x == x && vec.y == y && vec.z == z);
        }
        return false;
    }

    public double length() {
        StringBuilder builder = new StringBuilder();
        builder.append(x);
        builder.append(y);
        builder.append(z);
        return builder.length();
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("x: ");
        builder.append(x);
        builder.append(" y: ");
        builder.append(y);
        builder.append(" z: ");
        builder.append(z);
        return builder.toString();
    }
}

package com.company.util;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 7/9/13
 * Time: 9:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class Vector3f {
    public float x;
    public float y;
    public float z;

    public Vector3f() {
    }

    public Vector3f(float v, float v1, float v2) {
        x = v;
        y = v1;
        z = v2;
    }

    public Vector3f(Vector3f vector3f) {
        x = vector3f.x;
        y = vector3f.y;
        z = vector3f.z;
    }

    public void set(Vector3f vector3f) {
        x = vector3f.x;
        y = vector3f.y;
        z = vector3f.z;
    }

    public void set(float v, float v1, float v2) {
        x = v;
        y = v1;
        z = v2;
    }

    public Vector3f add(Vector3f vector3f) {
        Vector3f sum = new Vector3f();
        sum.x = x + vector3f.x;
        sum.y = y + vector3f.y;
        sum.z = z + vector3f.z;
        return sum;
    }

    public Vector3f subtract(Vector3f vector3f) {
        Vector3f difference = new Vector3f();
        difference.x = x - vector3f.x;
        difference.y = y - vector3f.y;
        difference.z = z - vector3f.z;
        return difference;
    }

    public Vector3f multiply(float f) {
        Vector3f product = new Vector3f();
        product.x = x * f;
        product.y = y * f;
        product.z = z * f;
        return product;
    }

    public float dot(Vector3f vector3f) {
        return vector3f.x * x + vector3f.y * y + vector3f.z * z;
    }

    public Vector3f divide(float f) {
        Vector3f quotient = new Vector3f();
        quotient.x = x / f;
        quotient.y = y / f;
        quotient.z = z / f;
        return quotient;
    }

    public boolean equals(Object object) {
        if (object instanceof Vector3f) {
            Vector3f vec = (Vector3f) object;
            return (vec.x == x && vec.y == y && vec.z == z);
        }
        return false;
    }

    public float length() {
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

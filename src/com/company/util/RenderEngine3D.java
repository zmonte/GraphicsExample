package com.company.util;

import com.company.Window;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 7/9/13
 * Time: 9:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class RenderEngine3D {
    public static final double PI = 3.14159265358979323846;
    private static Window window;
    private double fov = 70;
    private int vdist = 1000;
    private double aspect = window.getWidth() / window.getHeight();
    private double zNear;
    private double zFar;
    private double[] projectionMatrix;

    public static Window getWindow() {
        return window;
    }

    public static void setWindow(Window window) {
        RenderEngine3D.window = window;
    }

    public double getFov() {
        return fov;
    }

    public void setFov(int fov) {
        this.fov = fov;
    }

    public int getVdist() {
        return vdist;
    }

    public void setVdist(int vdist) {
        this.vdist = vdist;
    }

    public Vector3d rotX(Vector3d pos, double theta) {
        double x;
        double y;
        double z;

        theta = Math.toRadians(theta);

        x = pos.x;
        y = (pos.y * Math.cos(theta)) - (pos.z * Math.sin(theta));
        z = (pos.y * Math.sin(theta)) + (pos.z * Math.cos(theta));
        Vector3d pos3d = new Vector3d((float) x, (float) y, (float) z);
        return pos3d;
    }

    public Vector3d rotY(Vector3d pos, double theta) {
        double x;
        double y;
        double z;

        theta = Math.toRadians(theta);

        x = (pos.z * Math.sin(theta)) + (pos.x * Math.cos(theta));
        y = pos.y;
        z = (pos.z * Math.cos(theta)) - (pos.x * Math.sin(theta));
        Vector3d pos3d = new Vector3d(x, y, z);
        return pos3d;
    }

    public Vector3d rotZ(Vector3d pos, double theta) {
        double x;
        double y;
        double z;

        theta = Math.toRadians(theta);

        x = (pos.x * Math.cos(theta)) - (pos.y * Math.sin(theta));
        y = (pos.x * Math.sin(theta)) + (pos.y * Math.cos(theta));
        z = pos.z;
        Vector3d pos3d = new Vector3d(x, y, z);
        return pos3d;
    }

    public Vector2d project(Vector3d pos3d, double x, double y) {
        double proX = (pos3d.x * 2 * fov) / (pos3d.z + vdist) + (x);
        double proY = (pos3d.y * -2 * fov) / (pos3d.z + vdist) + (y);
        Vector2d pos2d = new Vector2d(proX, proY);
        return pos2d;
    }

    public Vector2d camera(Vector3d objectPosition, double pitch, double yaw, double roll, Vector3d cameraPosition) {
        Vector3d calculatedPosition = new Vector3d(0, 0, 0);
        Vector2d projectedPosition = new Vector2d(0, 0);

        yaw = Math.toRadians(yaw);
        pitch = Math.toRadians(pitch);
        roll = Math.toRadians(roll);

        objectPosition.x += cameraPosition.x;
        objectPosition.y += cameraPosition.y;
        objectPosition.z += cameraPosition.z;

        calculatedPosition.x = objectPosition.x * Math.cos(pitch) - objectPosition.z * Math.sin(pitch);
        calculatedPosition.z = objectPosition.x * Math.sin(pitch) + objectPosition.z * Math.cos(pitch);
        calculatedPosition.y = objectPosition.y * Math.cos(yaw) - calculatedPosition.z * Math.sin(yaw);

        objectPosition.z = calculatedPosition.y * Math.cos(yaw) - calculatedPosition.z * Math.sin(yaw);
        objectPosition.x = calculatedPosition.x * Math.cos(roll) - calculatedPosition.y * Math.sin(roll);
        objectPosition.y = calculatedPosition.x * Math.sin(roll) + calculatedPosition.y * Math.cos(roll);

        if (objectPosition.z > cameraPosition.z) {
            /*projectedPosition.x = objectPosition.x / objectPosition.z * this.zoom + window.getWidth() / 2;
            projectedPosition.y = objectPosition.y / objectPosition.z * this.zoom + window.getHeight() / 2;*/
            projectedPosition.x = (objectPosition.x * 2 * fov) / objectPosition.z + window.getWidth() / 2;
            projectedPosition.y = (objectPosition.y * -2 * fov) / objectPosition.z + window.getHeight() / 2;
        }

        //System.out.println(objectPosition.z);

        return projectedPosition;
    }

    public void setProjectionMatrix(double[] m, double fov, double aspect, double zNear, double zFar) {
        double xymax = zNear * Math.tan(fov * PI / 360);
        double ymin = -xymax;
        double xmin = -xymax;

        double width = xymax - xmin;
        double height = xymax - ymin;

        double depth = zFar - zNear;
        double q = -(zFar + zNear) / depth;
        double qn = -2 * (zFar * zNear) / depth;

        double w = 2 * zNear / width;
        w = w / aspect;
        double h = 2 * zNear / height;

        m[0] = w;
        m[1] = 0;
        m[2] = 0;
        m[3] = 0;

        m[4] = 0;
        m[5] = h;
        m[6] = 0;
        m[7] = 0;

        m[8] = 0;
        m[9] = 0;
        m[10] = q;
        m[11] = -1;

        m[12] = 0;
        m[13] = 0;
        m[14] = qn;
        m[15] = 0;

        for (int i = 0; i < m.length; i++) {
            projectionMatrix[i] = m[i];
        }
    }
}

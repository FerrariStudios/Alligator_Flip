package com.FireFerrariStudios.AlligatorFlip;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

/**
 * Created by 1414125 on 2/8/2016.
 */
public class Draw {

    public static void drawCircle(float cx, float cy, float r, Paint p, Canvas c) {
        c.drawCircle((float) (cx * 0.01 * c.getWidth()), (float) (cy * 0.01 * c.getHeight()), (float) (r * 0.01 * c.getWidth()), p);

    }

    public static void drawRect(float left, float top, float right, float bottom, Paint p, Canvas c) {
        c.drawRect((float) (left * 0.01 * c.getWidth()), (float) (top * 0.01 * c.getHeight()),
                (float) (right * 0.01 * c.getWidth()), (float) (bottom * 0.01 * c.getHeight()), p);

    }

    public static void drawLine(float startX, float startY, float stopX, float stopY, Paint p, Canvas c) {
        c.drawLine((float) (startX * 0.01 * c.getWidth()), (float) (startY * 0.01 * c.getHeight()),
                (float) (stopX * 0.01 * c.getWidth()), (float) (stopY * 0.01 * c.getHeight()), p);

    }

    public static void drawText(String text, RectF cell, Paint p, Canvas c)
    {
        c.drawText(text, (float)(cell.centerX()),(float) (cell.centerY()), p);
    }

    public static void drawText(String text, float x, float y, Paint p, Canvas c) {
        c.drawText(text, (float) (x * 0.01 * c.getWidth()), (float) (y * 0.01 * c.getHeight()), p);

    }


    public static void drawTriangle(double ax, double ay, double bx, double by, double cx,
                                    double cy, Paint p, Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();

        Path path = new Path();
        path.moveTo(((int) (ax * 0.01 * width)), ((float) (ay * 0.01 * height)));
        path.lineTo(((int) (bx * 0.01 * width)), ((float) (by * 0.01 * height)));
        path.lineTo((int) (cx * 0.01 * width), (float) (cy * 0.01 * height));
        path.close();
        canvas.drawPath(path, p);

    }

    public static RectF createRectF(float left, float top, float right, float bottom, Canvas c) {
        float width = (float) (0.01 * c.getWidth());
        float height = (float) (0.01 * c.getHeight());

        return new RectF(left * width, top * height, right * width, bottom * height);
    }

    public static void drawCircle(RectF cell, Paint p, Canvas c) {
        float radius;

        if (cell.width() > cell.height()) {
            radius = cell.height() / 2;
        } else

            radius = cell.width() / 2;

        c.drawCircle((float) (cell.centerX()), (float) (cell.centerY()), (float) (radius), p);

    }

    public static void drawX(RectF cell, Paint p, Canvas c) {
        c.drawLine(cell.left, cell.bottom, cell.right, cell.top, p);
        c.drawLine(cell.left, cell.top, cell.right, cell.bottom, p);


    }

    public static float smallerOfX(float x, Canvas c) {
        if (c.getWidth() <= c.getHeight()) {
            return x;
        } else {
            return (float) (x / c.getWidth() * c.getHeight());
        }
    }

    public static float smallerOfY(float y, Canvas c) {
        if (c.getHeight() <= c.getWidth()) {
            return y;
        } else {
            return (float) (y / c.getHeight() * c.getWidth());
        }
    }


}

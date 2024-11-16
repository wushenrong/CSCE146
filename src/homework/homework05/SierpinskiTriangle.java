/*
 * Samuel Wu
 * 2024-11-09
 */

package homework.homework05;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

public class SierpinskiTriangle extends Canvas {
    public static final int NUMBER_OF_POINTS = 3;
    public static final int MAX_DEPTH = 4;

    public static final Color BLACK = new Color(0, 0, 0);
    public static final Color WHITE = new Color(255, 255, 255);

    /**
     * Draw the initial triangle right side up triangle from the top middle of
     * the canvas, the bottom left of the canvas, and the bottom right of the
     * canvas. Then call a recursive method to draw the upside down triangles.
     */
    @Override
    public void paint(Graphics g) {
        int[] mainTriangleXPoints = { this.getWidth() / 2, 0, this.getWidth() };
        int[] mainTriangleYPoints = { 0, this.getHeight(), this.getHeight() };

        g.setColor(BLACK);
        g.fillPolygon(mainTriangleXPoints, mainTriangleYPoints, NUMBER_OF_POINTS);
        g.setColor(WHITE);

        Point top = new Point(mainTriangleXPoints[0], mainTriangleYPoints[0]);
        Point left = new Point(mainTriangleXPoints[1], mainTriangleYPoints[1]);
        Point right = new Point(mainTriangleXPoints[2], mainTriangleYPoints[2]);

        drawTriangles(g, top, left, right, 1);
    }

    /**
     * Recursively draw the top, left and right, upside down triangles before
     * hitting the MAX_DEPTH to draw the sierpinski triangle.
     */
    public void drawTriangles(Graphics g, Point top, Point left, Point right, int depth) {
        if (depth > MAX_DEPTH) {
            return;
        }

        // Get the left, right, and bottom points of the divided triangle, this
        // equally splits the triangle into similar small triangles.
        Point subLeft = midpoint(top, left);
        Point subRight = midpoint(top, right);
        Point subBottom = midpoint(left, right);

        Polygon triangle = new Polygon();

        triangle.addPoint(subLeft.x, subLeft.y);
        triangle.addPoint(subRight.x, subRight.y);
        triangle.addPoint(subBottom.x, subBottom.y);

        g.fillPolygon(triangle);

        // Recursively draw the triangles. The region for the top triangle is
        // the top point of the main triangle, and the left and right point of
        // the upside down triangle. The region for the left triangle is the
        // left point of the main triangle and the left and bottom point of the
        // of the upside down triangle. The region for the right triangle is the
        // right point of the main triangle and the right and bottom point of
        // the of the upside down triangle.
        drawTriangles(g, top, subLeft, subRight, depth + 1);
        drawTriangles(g, subLeft, left, subBottom, depth + 1);
        drawTriangles(g, subRight, subBottom, right, depth + 1);
    }

    /**
     * Find the midpoint between two points.
     */
    private Point midpoint(Point pointA, Point pointB) {
        return new Point((pointA.x + pointB.x) / 2, (pointA.y + pointB.y) / 2);
    }
}

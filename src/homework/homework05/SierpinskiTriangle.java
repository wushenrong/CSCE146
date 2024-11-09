package homework.homework05;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class SierpinskiTriangle extends Canvas {
    public static final int NUMBER_OF_POINTS = 3;

    @Override
    public void paint(Graphics g) {
        int topXPoint = this.getWidth() / 2;
        int topYPoint = 0;
        int leftXPoint = 0;
        int leftYPoint = this.getHeight();
        int rightXPoint = this.getWidth();
        int rightYPoint = this.getHeight();

        int[] xPoints = { topXPoint, leftXPoint, rightXPoint };
        int[] yPoints = { topYPoint, leftYPoint, rightYPoint };

        Color black = new Color(0, 0, 0);
        Color white = new Color(255, 255, 255);

        g.setColor(black);
        g.fillPolygon(xPoints, yPoints, NUMBER_OF_POINTS);
        g.setColor(white);
    }

    public void drawTriangle() {

    }
}

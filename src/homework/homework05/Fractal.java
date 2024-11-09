/*
 * Samuel Wu
 * 2024-11-09
 */

package homework.homework05;

import javax.swing.JFrame;

public class Fractal {
    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("Fractal");
        SierpinskiTriangle triangle = new SierpinskiTriangle();

        mainFrame.setSize(900, 900);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.add(triangle);
    }
}

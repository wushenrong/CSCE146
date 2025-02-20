/*
 * SPDX-FileCopyrightText: 2024 Samuel Wu
 *
 * SPDX-License-Identifier: MIT
 */

package homework.homework05;

import javax.swing.JFrame;

public class Fractal {
  public static final int SCREEN_WIDTH = 400;
  public static final int SCREEN_HEIGHT = 400;

  /**
   * Main method to create a new frame and canvas to show and draw the sierpinski triangle on
   * respectively.
   */
  public static void main(String[] args) {
    JFrame mainFrame = new JFrame("Fractal");
    SierpinskiTriangle triangle = new SierpinskiTriangle();

    mainFrame.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
    mainFrame.setVisible(true);
    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mainFrame.add(triangle);
  }
}

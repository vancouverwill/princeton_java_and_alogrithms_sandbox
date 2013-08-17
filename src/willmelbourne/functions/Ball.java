package src.willmelbourne.functions;

import standard_libraries.StdDraw;

/*************************************************************************
 *  Compilation:  javac Ball.java
 *  Execution:    java Ball
 *  Dependencies: StdDraw.java
 *
 *  Implementation of a 2-d Ball moving in square with coordinates
 *  between -1 and 1. Bounces off the walls upon collision.
 *
 *
 *************************************************************************/

public class Ball {

    // instance variables
    private double rx, ry;   // position
    private double vx, vy;   // velocity
    private double radius;   // radius

    // constructor
    public Ball() {
        rx = 0.0;
        ry = 0.0;
        vx     = 0.015 - Math.random() * 0.03;
        vy     = 0.015 - Math.random() * 0.03;
        radius = 0.025 + Math.random() * 0.05;
    }

    // move the ball one step
    public void move() {
        if (Math.abs(rx + vx) + radius > 1.0) { vx = -vx; }
        if (Math.abs(ry + vy) + radius > 1.0) { vy = -vy; }
        rx = rx + vx;
        ry = ry + vy;
    }

    // draw the ball
    public void draw() {
        StdDraw.filledCircle(rx, ry, radius);
    }



    // test client
    public static void main(String[] args) {

        // create and initialize two balls
        Ball b1 = new Ball();
        Ball b2 = new Ball();
        System.out.println("Memory address of b1 = " + b1);
        System.out.println("Memory address of b2 = " + b2);

        // animate them
        StdDraw.setXscale(-1.0, +1.0);
        StdDraw.setYscale(-1.0, +1.0);
        while (true) {
            StdDraw.clear(StdDraw.GRAY);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.filledSquare(0.0, 0.0, 1.0);
            StdDraw.setPenColor(StdDraw.BLACK);
            b1.move();
            b2.move();
            b1.draw();
            b2.draw();
            StdDraw.show(50);
        }
    }
}
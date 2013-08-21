package src.my_files.bodySimulation;

import standard_libraries.StdDraw;

/*************************************************************************
 *  Compilation:  javac BouncingColoredBalls.java
 *  Execution:    java BouncingColoredBalls N
 *  Dependencies: ColoredBall.java StdDraw.java
 *
 *  Creates an array of N bouncing balls and animates them.
 *
 *  % java BouncingBalls 10
 *
 *************************************************************************/

public class BouncingColoredBalls { 

    public static void main(String[] args) {

        // number of bouncing balls
        int N = Integer.parseInt(args[0]);

        // set boundary to box with coordinates between -1 and +1
        StdDraw.setXscale(-1.0, +1.0);
        StdDraw.setYscale(-1.0, +1.0);

        // create an array of N random colored balls
        ColoredBall[] balls = new ColoredBall[N];
        for (int i = 0; i < N; i++)
            balls[i] = new ColoredBall();

        // do the animation loop
        while(true) {
            StdDraw.clear(StdDraw.GRAY);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.filledSquare(0.0, 0.0, 1.0);
            StdDraw.setPenColor(StdDraw.BLACK);
            for (int i = 0; i < N; i++) {
                balls[i].move();
                balls[i].draw();
            }
            StdDraw.show(10);
        }
    }
}
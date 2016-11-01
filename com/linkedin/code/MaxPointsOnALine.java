package com.linkedin.code;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnALine {

    static class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    /**
     * @param points
     *            an array of point
     * @return an integer
     */
    public static int maxPoints(Point[] points) {
        if (points == null) {
            return 0;
        }
        
        if (points.length < 3) {
            return points.length;
        }

        int max = 2;
        Map<Double, Integer> map = new HashMap<Double, Integer>();
        for (int i = 0; i < points.length; i++) {
            map.clear();
            map.put((double) Integer.MIN_VALUE, 1);
            // slope : count
            Point fixed = points[i];
            int dup = 0;
            for (int j = i + 1; j < points.length; j++) {
                
                if (points[j].x == fixed.x && points[j].y == fixed.y) {
                    dup++;
                    continue;
                }

                double k = getSlope(fixed, points[j]);
                if (map.containsKey(k)) {
                    map.put(k, map.get(k) + 1);
                } else {
                    map.put(k, 2);
                }
            }
            
            for (Double key : map.keySet()) {
                max = Math.max(max, map.get(key) + dup);
            }
        }
        
        return max;
    }
    
    public static double getSlope(Point p1, Point p2) {
        if ((p2.x - p1.x) == 0) {
            return Integer.MAX_VALUE;
        }
        return 0.0 + ( (double) (p2.y - p1.y) / (double) (p2.x - p1.x));
    }

    public static void main(String[] args) {
        Point[] points = new Point[4];
        
        points[0] = new Point(1, 2);
        points[1] = new Point(3, 6);
        points[2] = new Point(0, 0);
        points[3] = new Point(1, 3);
        System.out.println(maxPoints(points));

    }

}

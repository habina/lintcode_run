package com.google.phone;

import java.util.HashSet;
import java.util.Set;

public class PerfectRectangle {

    public static void main(String[] args) {
        int[][] a = { { 1, 1, 3, 3 }, { 3, 1, 4, 2 }, { 3, 2, 4, 4 }, { 1, 3, 2, 4 }, { 2, 3, 3, 4 } };
        System.out.println(isRectangleCover(a));
    }

    public static boolean isRectangleCover(int[][] rectangles) {
        Set<String> set = new HashSet<String>();
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        int area = 0;

        for (int[] lst : rectangles) {
            minX = Math.min(minX, lst[0]);
            minY = Math.min(minY, lst[1]);
            maxX = Math.max(maxX, lst[2]);
            maxY = Math.max(maxY, lst[3]);

            area += (lst[3] - lst[1]) * (lst[2] - lst[0]);

            // hash four points of the rectangles
            String leftBottom = lst[0] + " " + lst[1];
            String leftTop = lst[0] + " " + lst[3];
            String rightBottom = lst[2] + " " + lst[1];
            String rightTop = lst[2] + " " + lst[3];

            // filter green and red point
            if (set.contains(leftBottom)) {
                set.remove(leftBottom);
            } else {
                set.add(leftBottom);
            }
            if (set.contains(leftTop)) {
                set.remove(leftTop);
            } else {
                set.add(leftTop);
            }
            if (set.contains(rightBottom)) {
                set.remove(rightBottom);
            } else {
                set.add(rightBottom);
            }
            if (set.contains(rightTop)) {
                set.remove(rightTop);
            } else {
                set.add(rightTop);
            }
        }

        if (set.size() != 4) {
            return false;
        }

        // make the set contains the four blue point
        String leftBottom = minX + " " + minY;
        String leftTop = minX + " " + maxY;
        String rightBottom = maxX + " " + minY;
        String rightTop = maxX + " " + maxY;
        if (!set.contains(leftBottom) || !set.contains(leftTop) || !set.contains(rightBottom)
            || !set.contains(rightTop)) {
            return false;
        }

        return area == ((maxY - minY) * (maxX - minX));
    }

}

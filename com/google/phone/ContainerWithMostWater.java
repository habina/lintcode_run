package com.google.phone;

public class ContainerWithMostWater {
    
    public static int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int max = Integer.MIN_VALUE;
        
        while (start < end) {
            max = Math.max(max, Math.min(height[start], height[end]) * (end -start));
            if (height[start] < height[end]) {
                start++;
            } else if (height[start] > height[end]){
                end--;
            } else {
                start++;
                end--;
            }
        }
        
        return max;
    }
    
    public static void main(String[] args) {
        int[] a = { 0,1,0,2,1,0,1,3,2,1,2,1 };
//        int[] a = { 1,1 };
        System.out.println(maxArea(a));
    }

}

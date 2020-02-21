package io.github.pierceh89.leetcode;

/**
 * 배열에 대해서 최대 n번 순회하기 때문에 O(n)
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0, right = height.length -1;
        while (left < right) {
            int area = getArea(height, left, right);
            if (area > maxArea) {
                maxArea = area;
            }
            if (height[left] < height[right]) {
                do {
                    left++;
                } while (left < right && height[left-1] >= height[left]);
            } else {
                do {
                    right--;
                } while (left < right && height[right+1] >= height[right]);
            }
        }

        return maxArea;
    }

    public int getArea(int[] height, int i, int j) {
        int h = (height[i] < height[j]) ? height[i] : height[j];
        int w = j - i;

        return h * w;
    }
}

package sliding_window;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {1,1};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int maxArea = Integer.MIN_VALUE;
        int left = 0, right = height.length-1;
        while (left<right){
            maxArea = Math.max(maxArea,Math.min(height[left],height[right]) * (right-left));
            if(height[left] < height[right]){
                left++;
            }else {
                right--;
            }
        }
        return maxArea;
    }
}

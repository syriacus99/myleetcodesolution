public class Solution42TrappingRainWater {
    public static int trap(int[] height){
        if(height.length==0){
            return 0;
        }
        int res = 0;
        int[] rightMax = new int[height.length];
        int[] leftMax = new int[height.length];
        rightMax[0] = height[0];
        leftMax[height.length-1] = height[height.length-1];
        for(int i=1;i<height.length;i++){
            leftMax[i] = Math.max(leftMax[i-1],height[i]);
        }

        for(int i=height.length-2;i>0;i--){
            rightMax[i] = Math.max(rightMax[i+1],height[i]);
        }
        for(int i=1;i<height.length-1;i++){
            res+= Math.min(rightMax[i],leftMax[i]) - height[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {4,2,0,3,2,5};
        System.out.println(trap(a));
    }
}

class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length-1;
        int[] water = new int[height.length];
        for(int i=left;i<=right;i++){
            int leftmax = max(height, left, i);
            int rightmax = max(height, i, right);
            water[i] = Math.max(0,  Math.min(leftmax, rightmax) - height[i]);
        }

        int sum = 0;
        for(int i=0;i<water.length;i++){
            sum+=water[i];
        }

        return sum;
    }


    private int max(int[] height, int start, int end){
        int max = 0;
        for(int i = start; i<=end; i++){
            max = Math.max(height[i], max);
        }
        return max;
    }
}

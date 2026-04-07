class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length, n = nums2.length;
        int low = 0, high = m;
        if(m>n)
        return findMedianSortedArrays(nums2, nums1);

        /* Optimized solution
            1. Do we need the fully sorted array?
            2. No — we only need the middle element(s) of the sorted order.
            3. Conceptually split both arrays into left and right halves.
            4. Ensure: leftMax ≤ rightMin.
            5. If the condition fails, adjust the partition.
            6. Perform binary search on the smaller array.
            7. Once the correct partition is found, compute the median.
        */

        while(low <= high){
            int partA = (low+high)/2;
            int partB = (m+n+1)/2-partA;

            int leftAMax = (partA == 0)? Integer.MIN_VALUE: nums1[partA-1];
            int rightAMin = (partA == m)?Integer.MAX_VALUE: nums1[partA];
            int leftBMax =  (partB == 0)? Integer.MIN_VALUE: nums2[partB-1];
            int rightBMin = (partB == n)?Integer.MAX_VALUE: nums2[partB];

            if(leftAMax<=rightBMin && leftBMax<=rightAMin){
                if((m+n)%2==0){
                    return (Math.max(leftAMax, leftBMax)+Math.min(rightBMin, rightAMin))/2.0;
                }else{
                    return Math.max(leftAMax, leftBMax);
                }
            }else if(leftAMax>rightBMin){
                    high = partA-1;
                }else{
                    low = partA+1;
                }
        }
        return 0.0;
    }
}

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //Brute force 
        int m = nums1.length, n = nums2.length;
        List<Integer> values = new ArrayList<>(); 

        for(int i=0;i<m;i++){
           values.add(nums1[i]);
        }

        for(int i=0;i<n;i++){
            values.add(nums2[i]);
        }

        Collections.sort(values);
        int len = values.size();

        if(len%2 != 0){
          return (double)values.get(len/2);

        }else{
            int val = len/2;
           return (double)((values.get(val-1)+values.get(val))/(double)2);

        }
    }
}

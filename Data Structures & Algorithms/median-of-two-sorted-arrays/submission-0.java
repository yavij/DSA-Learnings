class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //Brute force 
        int m = nums1.length, n = nums2.length;
        Set<Integer> values = new TreeSet<>();

        for(int i=0;i<m;i++){
           values.add(nums1[i]);
        }

        for(int i=0;i<n;i++){
            values.add(nums2[i]);
        }

        int len = values.size();
        List<Integer> obj = new ArrayList<>(values);
        System.out.println(len);

        if(len%2 != 0){
          return (double)obj.get(len/2);

        }else{
            int val = len/2;
           return (double)((obj.get(val-1)+obj.get(val))/(double)2);

        }
    }
}

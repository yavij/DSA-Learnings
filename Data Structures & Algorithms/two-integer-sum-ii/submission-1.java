class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        int start = 0;
        int end = numbers.length -1;

        //Brute force
        /**for(int i=0; i<len; i++){
            for(int j=i+1; j<len; j++){
                if(target == numbers[i]+numbers[j]){
                    return new int[]{numbers[i],numbers[j]};
                }
            }
        }
        return new int[]{-1,-1};**/

        while(start < end){
           int sum = numbers[start]+numbers[end];
           if(target == sum){
            return new int[] {start+1, end+1};
           }

           if(sum<target){
                start++;
           }else{
                end--;
           }
           
        }
        return new int[]{-1,-1};
    }
}

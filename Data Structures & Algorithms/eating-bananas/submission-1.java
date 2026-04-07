class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int len = piles.length;
        int min = 1, max = 0;

        for(int i=0;i<len;i++){
            max = Math.max(max, piles[i]);
        }

        while(min<=max){
            int mid = min+(max-min)/2;
            int hour = 0;
            for(int i=0;i<len;i++){
                int pile = piles[i];
                hour+=(pile+mid-1)/mid;
            }
           if(hour<=h) {
            max = mid-1;
           }else{
            min = mid+1;
           }
            
        }
        return min;
    }
}

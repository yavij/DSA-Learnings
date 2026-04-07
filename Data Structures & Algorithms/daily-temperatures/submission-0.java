class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int len = temperatures.length;
        int[] results = new int[len];
        for(int i=0;i<len;i++){
            int count = 0;
            for(int j=i+1; j<len; j++){
                count++;
                if(temperatures[j]>temperatures[i]){
                    results[i] = count;
                    count = 0;
                    break;
                }
            }
        }

        return results;
    }
}

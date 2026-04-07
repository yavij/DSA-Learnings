class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        int size = position.length;

        int[][] res = new int[size][2];

        for(int i=0;i<size;i++){
            res[i][0] = position[i];
            res[i][1] = speed[i];
        }

        Arrays.sort(res, (a,b)-> b[0]-a[0]);
        int fleet = 0;
        double fleetTime = 0;
        for(int i=0;i<size;i++){
           double time = (double)(target - res[i][0])/res[i][1];
            if(time > fleetTime){
                fleet++;
                fleetTime = time;
            }
        }
        return fleet;
        
    }
}

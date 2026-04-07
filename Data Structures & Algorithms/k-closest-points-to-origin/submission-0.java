class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<Double> result = new PriorityQueue<>();
       Map<Double, List<int[]>> resultMap = new HashMap<>();
        
        for(int[] point: points){
           int x = point[0];
           int y = point[1];
           double res = Math.sqrt(x*x+y*y);
          result.add(res);
         resultMap.computeIfAbsent(res, v -> new ArrayList<>()).add(point);
        }

        int[][] ans = new int[k][2];
        int i = 0;

        System.out.println("Map"+resultMap);

        while(i < k){
            double val = result.poll();       // smallest distance
            List<int[]> list = resultMap.get(val);
            ans[i] = list.remove(0);      // corresponding point
            i++;
        }

        return ans;
    }
}

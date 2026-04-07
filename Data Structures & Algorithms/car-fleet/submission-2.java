class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        int size = position.length;
        int[][] cars = new int[size][2];

        for(int i=0;i<size;i++){
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a,b)-> b[0]-a[0]);

        Stack<Double> stack = new Stack<>();

        for(int i=0;i<size;i++){
            double time = (double)(target - cars[i][0])/cars[i][1];
            
            if(stack.isEmpty() || time>stack.peek()){
                stack.push(time);
            }
        }

        return stack.size();
    }
}

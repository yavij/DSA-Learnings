class Solution {
    public int lastStoneWeight(int[] stones) {
        List<Integer> values = Arrays.stream(stones)
                             .boxed()
                             .collect(Collectors.toList());
        int len = values.size()-1;
        while(len>0){
            Collections.sort(values);
            System.out.println("values Sorted"+values);
            int val = values.get(len)-values.get(len-1);
            values.remove(len); values.remove(len-1);
             System.out.println("values removed"+values+"val"+val);
            values.add(val);
            System.out.println("values added"+values);
            len = values.size()-1;
        }
        return values.get(0)!= null? values.get(0): 0;
        
    }
}

class KthLargest {

    private int k;
    List<Integer> values; 

    public KthLargest(int k, int[] nums) {
        this.k=k;
        this.values=Arrays.stream(nums)
                             .boxed()
                             .collect(Collectors.toList());
    }
    
    public int add(int val) {
        values.add(val);
        Collections.sort(values);
        int len = values.size()-k;
        int result = values.get(len);
        System.out.println("values"+values+"--len-->"+len+"--result-->"+result);
        return result;
    }
}

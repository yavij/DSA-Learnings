class MedianFinder {

    List<Integer> numbers;

    public MedianFinder() {
        this.numbers = new ArrayList<>();
    }
    
    public void addNum(int num) {
        numbers.add(num);
    }
    
    public double findMedian() {
        Collections.sort(numbers);
        int length = this.numbers.size();
        if(length%2 == 0){
            int n = (length-1)/2;
            int m = length/2;
            int first = numbers.get(n);
            int second = numbers.get(m);
            return (first+second)/2.0;
        }
       return numbers.get(length/2);
    }
}

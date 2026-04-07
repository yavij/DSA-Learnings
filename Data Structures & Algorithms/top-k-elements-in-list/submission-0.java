class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numMap = new HashMap<>();
        int[] topK = new int[k];int j=0;
        for(int num: nums){
            numMap.put(num, numMap.getOrDefault(num, 0)+1);
        }
        Map<Integer, Integer> sortedDesc = numMap.entrySet().stream()
    .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
    .collect(Collectors.toMap(
        Map.Entry::getKey,
        Map.Entry::getValue,
        (e1, e2) -> e1,
        LinkedHashMap::new));
        System.out.println("numMap"+sortedDesc);

        for(int num: sortedDesc.keySet()){
            if(j>=k) break;
            topK[j++] = num;
        }
        return topK;
    }
}

class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> taskMap = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>
        (Collections.reverseOrder());

        for(char task: tasks){
            taskMap.put(task, taskMap.getOrDefault(task, 0)+1);
        }
        pq.addAll(taskMap.values());
        int time = 0;

        while(!pq.isEmpty()){

            int cycle = n + 1;
            List<Integer> list = new ArrayList<>();

            while(cycle > 0 && !pq.isEmpty()){

                int freq = pq.poll();
                freq--;

                if(freq > 0){
                    list.add(freq);
                }

                time++;
                cycle--;
            }

            for(int val : list){
                pq.add(val);
            }

            if(pq.isEmpty()){
                break;
            }

            time += cycle; // idle time
        }
        return time;
    }
}

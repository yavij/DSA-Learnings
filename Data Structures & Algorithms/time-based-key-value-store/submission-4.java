class TimeMap {

    Map<String, List<Node>> map;

    class Node {
        int timestamp;
        String value;

        Node(int t, String v) {
            this.timestamp = t;
            this.value = v;
        }
    }

    public TimeMap() {
        map = new HashMap<>();
    }

    // O(1)
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>())
           .add(new Node(timestamp, value));
    }

    // O(log n)
    public String get(String key, int timestamp) {
        List<Node> list = map.get(key);
        if (list == null) return "";

        int left = 0, right = list.size() - 1;
        String result = "";

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (list.get(mid).timestamp <= timestamp) {
                result = list.get(mid).value;
                left = mid + 1;      // search right
            } else {
                right = mid - 1;     // search left
            }
        }

        return result;
    }
}

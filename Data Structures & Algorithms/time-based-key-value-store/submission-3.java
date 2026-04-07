class TimeMap {

    Map<String, TreeMap<Integer,String>> keyValueMap;

    public TimeMap() {
        this.keyValueMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> timestampValue = keyValueMap.getOrDefault(key, new TreeMap<>());
        timestampValue.put(timestamp, value);
        keyValueMap.put(key, timestampValue);
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer, String> valuesMap = keyValueMap.get(key);
        if(valuesMap == null) return "";
        Map.Entry<Integer, String> entry = valuesMap.floorEntry(timestamp);
        return entry == null? "": entry.getValue();
    }
}

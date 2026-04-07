class TimeMap {

    Map<String, String> keyValueMap;

    public TimeMap() {
        this.keyValueMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        String mapkey = key+"_"+timestamp;
        keyValueMap.put(mapkey, value);
    }
    
    public String get(String key, int timestamp) {
        String mapkey = key+"_"+timestamp;
        String value = keyValueMap.get(mapkey);
        if(value!=null && !value.isEmpty()){
            return value;
        }else{
            for(int i=timestamp-1;i>=1;i--){
                String kval = key+"_"+i;
                value = keyValueMap.get(kval);
                if(value!=null) return value;
            }
        }
        return "";
    }
}

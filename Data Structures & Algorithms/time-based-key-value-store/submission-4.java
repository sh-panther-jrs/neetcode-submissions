class TimeMap {
    Map<String, TreeMap<Integer, String>> ds;
    public TimeMap() {
        ds = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        ds.putIfAbsent(key, new TreeMap<Integer, String>());
        ds.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if (!ds.containsKey(key) || ds.get(key).floorEntry(timestamp)==null) {
            return "";
        }
        return ds.get(key).floorEntry(timestamp).getValue();
    }
}

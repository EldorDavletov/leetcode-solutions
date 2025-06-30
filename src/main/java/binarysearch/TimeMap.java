package binarysearch;


import java.util.*;

public class TimeMap {

//    private Map<Map<Integer,String>,String> timMap = new HashMap<>();
    private Map<String, List<Pair<Integer, String>>> timeMap = new HashMap<>();
    public TimeMap(){}

    public void set(String key, String value, int timestamp){
        timeMap.putIfAbsent(key, new ArrayList<>());
        timeMap.get(key).add(new Pair<>(timestamp, value));
    }

    public String get(String key, int timestamp){
        if (!timeMap.containsKey(key)) {
            return "";
        }

        List<Pair<Integer, String>> list = timeMap.get(key);
        int left = 0, right = list.size() - 1;
        String result = "";

        // Binary search to find the latest timestamp less than or equal to the given one
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid).getKey() <= timestamp) {
                result = list.get(mid).getValue();
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();
        timeMap.set("foo","bar",1);
        System.out.println(timeMap.get("foo",1));
        timeMap.set("foo","bar2",4);
        System.out.println(timeMap.get("foo",4));

        System.out.println(timeMap.timeMap);
    }
}

class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

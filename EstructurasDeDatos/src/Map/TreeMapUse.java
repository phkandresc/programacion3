package Map;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapUse {
    private Map<Integer, String> map= new TreeMap<>();

    public TreeMapUse() {
        map.put(7, "One");
        map.put(11, "Two");
        map.put(10, "Three");
        map.put(12, "Four");
        map.put(5, "Five");
    }

    public void printMapEntry() {
        for(Map.Entry<Integer, String> entry: map.entrySet()){
            System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
        }
    }
}

package Map;
import java.util.Map;
import java.util.LinkedHashMap;

public class LinkedHashMapUse {
    private Map<Integer, String> map= new LinkedHashMap<>();

    public LinkedHashMapUse() {
        map.put(1, "One");
        map.put(3, "Two");
        map.put(6, "Three");
        map.put(2, "Four");
        map.put(5, "Five");
    }

    public void printMapEntry() {
        for(Map.Entry<Integer, String> entry: map.entrySet()){
            System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
        }
    }
}

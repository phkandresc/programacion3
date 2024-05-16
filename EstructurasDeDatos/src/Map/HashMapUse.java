package Map;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

public class HashMapUse {
    private Map<Integer, String> map= new HashMap<>();
    private Iterator iterator= map.entrySet().iterator();

    public HashMapUse() {
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");
        map.put(5, "Five");
    }

    public void printMapEntry() {
        for(Map.Entry<Integer, String> entry: map.entrySet()){
            System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
        }
    }

    public void printMapIterator() {
        Iterator<Map.Entry<Integer, String>> iterator= map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer, String> entry= iterator.next();
            System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
        }
    }

}

import java.util.HashMap;
import java.util.Map;
public class SimpleCache {
    public static void main(String[] args) {
        Map<Integer, String> cache = new HashMap<>();
        cache.put(101, "John");
        cache.put(102, "David");
        cache.put(103, "Maria");
        System.out.println("Student 101: " + cache.get(101));
        if(cache.containsKey(102))
        {
            System.out.println("Student 102 found.");
        }
        cache.remove(103);
        System.out.println("\nCurrent Cache:");
        for(Map.Entry<Integer, String> entry : cache.entrySet())
        {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
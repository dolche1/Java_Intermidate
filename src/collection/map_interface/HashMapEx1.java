package collection.map_interface;

import java.util.HashMap;
import java.util.Map;

public class HashMapEx1 {
    public static void main(String[] args) {
        Map<Integer, String> map1 = new HashMap<>();
        map1.put(1000, "Zaur Tregulov");
        map1.put(4351, "Ivan Ivanov");
        map1.put(6758, "Mariya Sidorova");
        map1.put(23800, "Nikolay Petrov");
        map1.put(1000, "Oleg Ivanov");
        map1.put(null, "Sergey Petrov");

        System.out.println(map1.containsValue("Ivan Ivanov"));
        System.out.println(map1.containsKey(1000));
        System.out.println(map1.keySet());
        System.out.println(map1);
        System.out.println(map1.values());
        System.out.println(map1.entrySet());
    }
}

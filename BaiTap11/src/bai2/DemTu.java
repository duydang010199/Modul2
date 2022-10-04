package bai2;

import java.util.HashMap;
import java.util.Map;

public class DemTu {
    public static void main(String[] args) {
        String str = "Don’t cry because it’s over, smile because it happened.";
        String[] array = str.split(" ");
        Map<String, Integer> map = new HashMap<>();

        for (String s: array){
            if (map.containsKey(s)){
                Integer value = map.get(s);
                value++;
                map.replace(s,value);
            } else {
                map.put(s, 1);
            }
        }
        System.out.println(map);
    }
}

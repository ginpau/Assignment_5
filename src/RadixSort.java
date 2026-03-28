import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class RadixSort {
    public String[] Rdx(String[] arr) {

        int maxLen = 0;
        for (int i = 0; i < arr.length; i++){
            if(arr[i].length() > maxLen){
                maxLen = arr[i].length();
            }
        }

        for(int i = 0; i < arr.length; i++){
            while(arr[i].length() < maxLen){
                arr[i] = arr[i] + " ";
            }
        }

        for(int i = maxLen - 1; i >= 0; i--){
            HashMap<Character, List<String>> map = new HashMap<>();
            for(int j = 0; j < arr.length; j++){
                char c = arr[j].charAt(i);
                if(!map.containsKey(c)){
                    map.put(c, new ArrayList<>());
                }
                map.get(c).add(arr[j]);
            }

            List<Character> keys = new ArrayList<>(map.keySet());
            Collections.sort(keys);
            int index = 0;
            for(char key: keys){
                for(String str: map.get(key)) {
                    arr[index] = str;
                    index++;
                }
            }
        }

        return arr;
    }
}
import java.util.ArrayList;
import java.util.List;

public class Palindrome {

    public boolean isPalindrome(String s){
        int left = 0;
        int right = s.length()-1;
        while(left < right){
            char l = Character.toLowerCase(s.charAt(left));
            char r = Character.toLowerCase(s.charAt(right));
            if(l != r){
                return false;
            }else{
                left++;
                right--;
            }
        }
        return true;
    }

    public List<int[]> palindromeTriplets(String[] words){
        List<int[]> result = new ArrayList<>();

        for(int i = 0; i < words.length; i++){
            for(int j = 0; j < words.length; j++){
                for(int k = 0; k < words.length; k++){
                    String combined = words[i] + words[j] + words[k];
                    if(isPalindrome(combined)){
                        result.add(new int[]{i, j, k});
                    }
                }
            }
        }
        return result;
    }
}

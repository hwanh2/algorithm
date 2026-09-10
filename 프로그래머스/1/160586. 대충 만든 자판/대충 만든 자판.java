import java.util.*;

class Solution {
    static int findIndex(String[] keymap, char target){
        int min = 101;
        for(int i=0; i<keymap.length; i++){
            String str = keymap[i];
            for(int j=0; j<str.length(); j++){
                char c = str.charAt(j);
                
                if(c==target){
                    min = Math.min(min,j+1);
                    break;
                }
            }
        }
        return min == 101 ? -1 : min;
    }
    
    public int[] solution(String[] keymap, String[] targets) {
        int[] result = new int[targets.length];
        
        for(int i=0; i<targets.length; i++){
            String str = targets[i];
            int sum = 0;
            for(int j=0; j<str.length(); j++){
                int pressCount = findIndex(keymap, str.charAt(j));
                if(pressCount == -1) {
                    sum = -1;
                    break;
                }
                sum += pressCount;
            }
            result[i] = sum;
        }
        return result;
    }
}
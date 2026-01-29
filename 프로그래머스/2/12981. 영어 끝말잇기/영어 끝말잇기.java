import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        
        List<String> list = new ArrayList<>();
        
        String str = words[0];
        list.add(str);
        for(int i=1; i<words.length; i++){
            if(str.charAt(str.length()-1)!=words[i].charAt(0) || list.contains(words[i])){
                answer[0] = (i%n)+1;
                answer[1] = (i/n)+1;
                return answer;
            }
            str = words[i];
            list.add(words[i]);
        }

        return answer;
    }
}
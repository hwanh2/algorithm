import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<X.length(); i++){
            int n = X.charAt(i)-'0';
            map.put(n,map.getOrDefault(n,0)+1);
        }
        
        for(int i=0; i<Y.length(); i++){
            int n = Y.charAt(i)-'0';
            if(map.containsKey(n) && map.get(n)>0){
                list.add(n);
                map.put(n,map.get(n)-1);
            }
        }
        
        if(list.size()==0){
            return "-1";
        }
        Collections.sort(list, Collections.reverseOrder());
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<list.size(); i++){
            sb.append(list.get(i)); 
        }
        
        if(sb.charAt(0) == '0'){
            return "0";
        }
        
        return sb.toString();
    }
}
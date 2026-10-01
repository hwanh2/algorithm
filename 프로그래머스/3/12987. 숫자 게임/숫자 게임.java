import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int result = 0;
        
        TreeMap<Integer,Integer> map = new TreeMap<>();
        
        for(int b : B){
            map.put(b,map.getOrDefault(b,0)+1);
        }
        
        for(int a : A){
            Integer num = map.higherKey(a);
            
            if(num != null){
                result++;
                
                if(map.get(num)==1){
                    map.remove(num);
                }
                else{
                    map.put(num,map.get(num)-1);
                }
            }
        }
        return result;
    }
}
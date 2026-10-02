import java.util.*;

class Solution {
    public int solution(String s) {
        int min = 1000;
        
        if (s.length() == 1) return 1;
        
        for(int i=1; i<=s.length()/2; i++){ // 압축할 개수
            String cur = s.substring(0,i);
            String str = "";
            int count = 1;
            
            for(int j=i; j<s.length(); j+=i){
                
                int end = Math.min(j+i,s.length());
                
                String tmp = s.substring(j,end);
                
                if(cur.equals(tmp)){
                    count++;
                }
                else{
                    if(count == 1){
                        str+=cur;
                    }
                    else{
                        str+=count + cur;
                    }
                    cur = tmp;
                    count = 1;
                }
            }
            
            if(count == 1){
                str += cur;
            } else {
                str += count + cur;
            }
            
            min = Math.min(min,str.length());
            
        }
        return min;
    }
}
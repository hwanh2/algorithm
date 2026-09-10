import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int n = id_list.length;
        boolean[][] map = new boolean[n][n];
        
        for(int i=0; i<report.length; i++){
            StringTokenizer st = new StringTokenizer(report[i]," ");
            
            String p1 = st.nextToken();
            String p2 = st.nextToken();
            
            int n1 = 0;
            int n2 = 0;
            for(int j=0; j<id_list.length; j++){
                if(p1.equals(id_list[j])){
                    n1 = j;
                    break;
                }
            }
            for(int j=0; j<id_list.length; j++){
                if(p2.equals(id_list[j])){
                    n2 = j;
                    break;
                }
            }
            
            map[n1][n2] = true;
            
        }
        
        int[] check = new int[n];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j]){
                    check[j]++;
                }
            }
        }
        
        int[] result = new int[n];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] && check[j]>=k){
                    result[i]++;
                }
            }
        }
        
        return result;
    }
}
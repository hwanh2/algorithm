import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = {0, 0, 0, 0};
        
        int[] inDegree = new int[1000001];
        int[] outDegree = new int[1000001];
        
        int maxNode = 0;
        
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            
            outDegree[a]++;
            inDegree[b]++;
            
            maxNode = Math.max(maxNode, Math.max(a, b));
        }
        
        for (int i = 1; i <= maxNode; i++) {
            if (inDegree[i] == 0 && outDegree[i] == 0) continue;
            
            if (inDegree[i] == 0 && outDegree[i] >= 2) {
                answer[0] = i;
            }
            else if (outDegree[i] == 0) {
                answer[2]++;
            }
            else if (inDegree[i] >= 2 && outDegree[i] == 2) {
                answer[3]++;
            }
        }
        
        int totalGraphs = outDegree[answer[0]];
        answer[1] = totalGraphs - answer[2] - answer[3];
        
        return answer;
    }
}
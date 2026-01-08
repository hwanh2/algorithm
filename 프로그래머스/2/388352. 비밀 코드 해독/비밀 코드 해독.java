class Solution {
    static int n;
    static int[] tmp;
    static int result = 0;
    static int[] answer;
    static int[][] qq;
    static void dfs(int start, int depth){
        if(depth == 5){
            if(check()){
                result++;
            }
            return;
        }
        for(int i=start+1; i<=n; i++){
            tmp[depth] = i;
            dfs(i,depth+1);
        }
    }
    static boolean check(){
        for(int i=0; i<answer.length; i++){
            int count = 0;
            for(int j=0; j<5; j++){
                for(int k=0; k<5; k++){
                    if(tmp[j]==qq[i][k]){
                        count++;
                    }
                }
            }
            if(count!=answer[i]){
                    return false;
                }
        }
        return true;
    }
    public int solution(int n, int[][] q, int[] ans) {
        this.n = n;
        answer = ans;
        qq = q;
        tmp = new int[5];
        dfs(0,0);
        return result;
    }
}
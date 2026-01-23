class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        
        int h = n/w+1;
        int[][] box = new int[h][w];
        int index = 1;
        int numR = 0;
        int numC = 0;
        
        for(int i=0; i<h; i++){
            if(i%2==0){
                for(int j=0; j<w && index<=n; j++){
                    box[i][j] = index;
                    if(index==num){
                        numC = j;
                        numR = i;
                    }
                    index++;
                }
            }
            else{
                for(int j=w-1; j>=0 && index<=n; j--){
                    box[i][j] = index;
                    if(index==num){
                        numC = j;
                        numR = i;
                    }
                    index++;
                }
            }
        }
        
        for(int i=numR; i<h; i++){
            if(box[i][numC]!=0){
                answer++;
            }
        }
        
        return answer;
    }
}
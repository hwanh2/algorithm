class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] map = new char[m][n];
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                map[i][j] = board[i].charAt(j);
            }
        }
        
        while(true){
            boolean pass = false;
            boolean[][] check = new boolean[m][n];
            
            for(int i=0; i<m-1; i++){
                for(int j=0; j<n-1; j++){
                    char ch = map[i][j];
                    if (ch == '.') continue;
                    if(ch==map[i][j+1] && ch==map[i+1][j] && ch==map[i+1][j+1]){
                        check[i][j] = true;
                        check[i+1][j] = true;
                        check[i][j+1] = true;
                        check[i+1][j+1] = true;
                        pass = true;
                    }
                }
            }
            
            if(!pass){
                break;
            }
            
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    if(check[i][j]){
                        answer++;
                        map[i][j] = '.';
                    }
                }
            }
            
            for(int j=0; j<n; j++){ // 가로
                for(int i=m-1; i>=1; i--){ // 세로
                    int index = 0;
                    if(map[i][j]=='.'){
                        for(int k=i-1; k>=0; k--){
                            if(map[k][j]!='.'){
                                index = k;
                                break;
                            }
                        }
                        map[i][j] = map[index][j];
                        map[index][j] = '.';
                        
                    }
                }
            }
        }
        
        
        return answer;
    }
}
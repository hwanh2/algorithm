import java.util.*;
import java.io.*;

class Main {
    static char[][] map;
    static int n;
    static boolean flag = false;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static void backTracking(int depth,int start){
        if (flag) return;
        
        if(depth==3){
            if(check()){
                flag = true;
            }
            return;
        }
        for (int i = start; i < n * n; i++) {
            int r = i/n;
            int c = i%n;

            if (map[r][c]=='X') {
                map[r][c]='O';
                
                backTracking(depth+1, i+1);
                
                map[r][c]='X';
            }
        }
    }
    static boolean check(){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] == 'T'){
                    for(int k=0; k<4; k++){
                        int x = j;
                        int y = i;
                        while(true){
                            x+=dx[k];
                            y+=dy[k];
                            if(x<0 || y<0 || x>=n || y>=n){
                                break;
                            }
                            if(map[y][x]=='S'){
                                return false;
                            }
                            if(map[y][x]=='O'){
                                break;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new char[n][n];

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<n; j++){
                map[i][j] = st.nextToken().charAt(0);
            }
        }

        backTracking(0,0);

        if(flag){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }

        
    }
}
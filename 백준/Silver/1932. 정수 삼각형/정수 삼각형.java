import java.io.*;
import java.util.*;

public class Main {
    static int[][] array;
    static int[][] dy;
    static void solve(int n){
        for(int i=1; i<n; i++){
            for(int j=0; j<=i; j++){
                if(j==0){
                    dy[i][j] = dy[i-1][j]+array[i][j];
                }
                else if(j==i){
                    dy[i][j] = dy[i-1][j-1]+array[i][j];
                }
                else{
                    if(dy[i-1][j-1]>dy[i-1][j]){
                        dy[i][j] = dy[i-1][j-1]+array[i][j];
                    }
                    else{
                        dy[i][j] = dy[i-1][j]+array[i][j];
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        array = new int[n][n];
        dy = new int[n][n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<=i; j++){
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dy[0][0] = array[0][0];
        solve(n);
        int result = 0;
        for(int i=0; i<n; i++){
            result = Math.max(dy[n-1][i],result);
        }
        System.out.println(result);
    }
}

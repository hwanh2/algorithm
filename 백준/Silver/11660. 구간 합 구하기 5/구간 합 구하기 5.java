import java.io.*;
import java.util.*;

public class Main {
    static int[][] array;
    static int[][] dp;
    static int solve(int i1,int j1,int i2,int j2){
        int count = 0;
        for(int i=i1; i<=i2; i++){
            count+=dp[i][j2] - dp[i][j1-1];
        }
        return count;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        array = new int[n+1][n+1];
        dp = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=1; j<=n; j++){
                array[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = dp[i][j-1] + array[i][j];
            }
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine()," ");
            int i1 = Integer.parseInt(st.nextToken());
            int j1 = Integer.parseInt(st.nextToken());
            int i2 = Integer.parseInt(st.nextToken());
            int j2 = Integer.parseInt(st.nextToken());
            bw.write(solve(i1,j1,i2,j2)+"\n");
        }
        bw.flush();
    }
}

import java.io.*;
import java.util.*;

public class Main {
    static int[][] array;
    static int[][] maxDp;
    static int[][] minDp;
    static void solve(int n){
        for(int i=1; i<n; i++){
            maxDp[i][0] = Math.max(maxDp[i-1][0],maxDp[i-1][1]) + array[i][0];
            maxDp[i][1] = Math.max(Math.max(maxDp[i-1][0],maxDp[i-1][1]),maxDp[i-1][2]) + array[i][1];
            maxDp[i][2] = Math.max(maxDp[i-1][1],maxDp[i-1][2]) + array[i][2];

            minDp[i][0] = Math.min(minDp[i-1][0],minDp[i-1][1]) + array[i][0];
            minDp[i][1] = Math.min(Math.min(minDp[i-1][0],minDp[i-1][1]),minDp[i-1][2]) + array[i][1];
            minDp[i][2] = Math.min(minDp[i-1][1],minDp[i-1][2]) + array[i][2];
        }

        int max = Math.max(maxDp[n-1][2],Math.max(maxDp[n-1][0],maxDp[n-1][1]));
        int min = Math.min(minDp[n-1][2],Math.min(minDp[n-1][0],minDp[n-1][1]));

        System.out.println(max+" "+min);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        array = new int[n][3];
        maxDp = new int[n][3];
        minDp = new int[n][3];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine()," ");
            array[i][0] = Integer.parseInt(st.nextToken());
            array[i][1] = Integer.parseInt(st.nextToken());
            array[i][2] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<3; i++){
            maxDp[0][i] = array[0][i];
            minDp[0][i] = array[0][i];
        }

        solve(n);

    }
}


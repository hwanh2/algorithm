import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] array = new int[n][n];
        int[] result = new int[n*n];
        int index = 0;
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<n; j++){
                array[i][j] = Integer.parseInt(st.nextToken());
                result[index++] = array[i][j];
            }
        }

        Arrays.sort(result);
        System.out.println(result[n*n-n]);
    }
}

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        char[][] array = new char[n][m];

        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<m; j++){
                array[i][j] = str.charAt(j);
            }
        }

        int result = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<=m-k; j++){
                int flag = 0;
                for(int l=0; l<k; l++){
                    if(array[i][j+l]=='1'){
                        flag = 1;
                        break;
                    }
                }
                if(flag==0){
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] array = new int[n][m];
        int[][] array2 = new int[n][m];
        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<m; j++){
                int num = str.charAt(j)-'0';
                array[i][j] = num;
            }
        }
        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<m; j++){
                int num = str.charAt(j)-'0';
                array2[i][j] = num;
            }
        }
        int count = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(array[i][j]!=array2[i][j] && i+2<n && j+2<m){
                    count++;
                    for(int k=i; k<i+3; k++){
                        for(int l=j; l<j+3; l++){
                            if(array[k][l]==0){
                                array[k][l] = 1;
                            }
                            else{
                                array[k][l] = 0;
                            }
                        }
                    }
                }
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(array[i][j]!=array2[i][j]){
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(count);
    }

}


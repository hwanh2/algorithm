import java.io.*;
import java.util.*;

public class Main {
    static String str = "*";
    static char[][] mat;
    static void partition(int r,int c,int n,boolean blank){
        if(blank){
            for(int i=r; i<r+n; i++){
                for(int j=c; j<c+n; j++){
                    mat[i][j] = ' ';
                }
            }
            return;
        }
        if(n==1){
            mat[r][c] = '*';
            return;
        }
        int blockSize = n/3;
        int count = 0;
        for(int i=r; i<r+n; i+=blockSize){
            for(int j=c; j<c+n; j+=blockSize){
                count++;
                if(count==5){
                    partition(i,j,blockSize,true);
                }
                else{
                    partition(i,j,blockSize,false);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        mat = new char[n][n];

        partition(0,0,n,false);

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                sb.append(mat[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

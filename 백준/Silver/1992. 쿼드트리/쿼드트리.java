import java.io.*;
import java.util.*;

public class Main {
    static int[][] mat;
    static StringBuilder sb = new StringBuilder();
    static void partition(int x,int y,int size){
        if(check(x,y,size)){
            sb.append(mat[y][x]);
            return;
        }
        sb.append("(");
        size/=2;
        partition(x,y,size);
        partition(x+size,y,size);
        partition(x,y+size,size);
        partition(x+size,y+size,size);
        sb.append(")");
    }
    static boolean check(int x,int y,int size){
        int flag = mat[y][x];
        for(int i=y; i<y+size; i++){
            for(int j=x; j<x+size; j++){
                if(flag!=mat[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        mat = new int[n][n];

        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<n; j++){
                mat[i][j] = str.charAt(j)-'0';
            }
        }

        partition(0,0,n);
        System.out.println(sb);

    }
}

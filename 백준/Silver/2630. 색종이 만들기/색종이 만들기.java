import java.io.*;
import java.util.*;

public class Main {
    static int[][] mat;
    static int white;
    static int blue;
    static void solve(int row,int col,int size){
        if(check(row,col,size)){
            int tmp = mat[row][col];
            if(tmp==1){
                blue++;
            }
            else{
                white++;
            }
            return;
        }
        size/=2;
        solve(row,col,size);
        solve(row,col+size,size);
        solve(row+size,col,size);
        solve(row+size,col+size,size);
    }
    static boolean check(int row,int col,int size){
        int tmp = mat[row][col];
        for(int i=row; i<row+size; i++){
            for(int j=col; j<col+size; j++){
                if(mat[i][j]!=tmp){
                    return false; // 색이 같지 않은 경우
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        mat = new int[n][n];

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<n; j++){
                mat[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(0,0,n);
        sb.append(white).append("\n").append(blue);
        System.out.println(sb);

    }
}

import java.io.*;
import java.util.*;

public class Main {
    static int mat[][];
    static int[] count;
    static void partition(int x,int y,int size){
        if(check(x,y,size)){
            count[mat[y][x]+1]++;
            return;
        }
        int newSize =size/3;
        for(int i=0; i<size; i+=newSize){
            for(int j=0; j<size; j+=newSize){
                partition(x+j,y+i,newSize);
            }
        }
    }
    static boolean check(int x,int y,int size){
        int num = mat[y][x];
        for(int i=y; i<y+size; i++){
            for(int j=x; j<x+size; j++){
                if(num!=mat[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        count = new int[3];
        mat = new int[n][n];

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<n; j++){
                mat[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        partition(0,0,n);
        sb.append(count[0]).append("\n").append(count[1]).append("\n").append(count[2]);
        System.out.println(sb);
    }
}

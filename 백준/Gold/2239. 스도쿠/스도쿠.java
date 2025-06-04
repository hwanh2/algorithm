import java.io.*;
import java.util.*;

class Main {
    static int[][] map;
    static StringBuilder sb = new StringBuilder();
    static void backTracking(int row,int col){
        if(col==9){
            backTracking(row+1,0);
            return;
        }
        if(row==9){
            for(int i=0; i<9; i++){
                for(int j=0; j<9; j++){
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }
        if(map[row][col]==0){
            for(int i=1; i<=9; i++){
                if(isVaild(row,col,i)){
                    map[row][col] = i;
                    backTracking(row,col+1);
                    map[row][col] = 0;
                }
            }
        }
        else{
            backTracking(row,col+1);
        }
    }
    static boolean isVaild(int row,int col,int num){
        for(int i=0; i<9; i++){
            if(map[row][i]==num || map[i][col]==num){
                return false;
            }
        }
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for(int i=startRow; i<startRow+3; i++){
            for(int j=startCol; j<startCol+3; j++){
                if(map[i][j]==num){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new int[9][9];
        for(int i=0; i<9; i++){
            String str = br.readLine();
            for(int j=0; j<9; j++){
                map[i][j] = str.charAt(j)-'0';
            }
        }

        backTracking(0,0);
    }
}

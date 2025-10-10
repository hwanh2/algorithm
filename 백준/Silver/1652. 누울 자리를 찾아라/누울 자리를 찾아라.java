import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        char[][] array = new char[n][n];

        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<n; j++){
                array[i][j] = str.charAt(j);
            }
        }
        int row = 0;
        int col = 0;

        for(int i=0; i<n; i++){
            int rowCount = 0;
            for(int j=0; j<n; j++){
                if(array[i][j]=='.'){
                    rowCount++;
                }
                else{
                    rowCount = 0;
                }

                if(rowCount==2){
                    row++;
                }
            }
        }


        for(int i=0; i<n; i++){
            int colCount = 0;
            for(int j=0; j<n; j++){
                if(array[j][i]=='.'){
                    colCount++;
                }
                else{
                    colCount = 0;
                }
                if(colCount==2){
                    col++;
                }
            }
        }

        System.out.println(row+" "+col);
    }
}
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[][] array = new char[5][15];
        for(int i=0; i<5; i++){
            String str = br.readLine();
            for(int j=0; j<str.length(); j++){
                array[i][j] = str.charAt(j);
            }
        }

        for(int j=0; j<15; j++){
            for(int i=0; i<5; i++){
                if(array[i][j]!='\0'){
                    sb.append(array[i][j]);
                }
            }
        }
        System.out.println(sb);
    }
}
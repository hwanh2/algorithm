import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int len = str.length();
        int ten = len/10;
        int remain = len%10;
        int index = 0;
        for(int i=0; i<ten; i++){
            for(int j=0; j<10; j++){
                System.out.print(str.charAt(index++));
            }
            System.out.println();
        }

        for(int i=0; i<remain; i++){
            System.out.print(str.charAt(index++));
        }

    }
}

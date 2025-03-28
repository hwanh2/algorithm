import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Integer[] array = new Integer[n];
        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(array,Collections.reverseOrder());
        for(int i=0; i<n; i++){
            sb.append(array[i]).append("\n");
        }
        System.out.println(sb);
    }
}


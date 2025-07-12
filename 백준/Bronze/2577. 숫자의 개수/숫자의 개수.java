import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        String result = String.valueOf(a*b*c);
        int[] count = new int[10];

        for(int i=0; i<result.length(); i++){
            count[result.charAt(i)-'0']++;
        }

        for(int i=0; i<10; i++){
            sb.append(count[i]).append("\n");
        }
        System.out.println(sb);

    }
}

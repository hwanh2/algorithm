import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int tmp = n;
        int count = 0;
        while(true){
            int x = tmp/10;
            int y = tmp%10;
            int z = x+y;
            int result = y*10+z%10;
            if(result==n){
                break;
            }
            tmp = result;
            count++;
        }
        System.out.println(count+1);
    }
}

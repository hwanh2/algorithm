import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int b = 0;
        int r = 0;

        if (str.charAt(0) == 'B') {
            b++;
        } else {
            r++;
        }
        
        for (int i=1; i<n; i++) {
            if (str.charAt(i) != str.charAt(i - 1)) {
                if (str.charAt(i) == 'B') {
                    b++;
                } else {
                    r++;
                }
            }
        }
        
        int result = 1 + Math.min(b,r);
        System.out.println(result);
    }
}
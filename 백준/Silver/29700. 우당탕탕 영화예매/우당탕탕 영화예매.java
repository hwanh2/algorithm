import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int result = 0;

        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            int emptyCount = 0;

            for (int j = 0; j < m; j++) {
                if (row.charAt(j) == '0') {
                    emptyCount++;
                } else {
                    emptyCount = 0;
                }

                if (emptyCount >= k) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}
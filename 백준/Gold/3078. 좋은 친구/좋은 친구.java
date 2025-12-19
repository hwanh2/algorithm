import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] nameLengths = new int[n];
        for (int i = 0; i < n; i++) {
            nameLengths[i] = br.readLine().length();
        }

        Map<Integer, Integer> map = new HashMap<>();
        
        long count = 0;

        for (int i=0; i<n; i++) {
            int currentLen = nameLengths[i];

            if (i > k) {
                int removeLen = nameLengths[i-k-1];
                map.put(removeLen, map.get(removeLen)-1);
            }

            count += map.getOrDefault(currentLen, 0);

            map.put(currentLen, map.getOrDefault(currentLen, 0) + 1);
        }

        System.out.println(count);
    }
}
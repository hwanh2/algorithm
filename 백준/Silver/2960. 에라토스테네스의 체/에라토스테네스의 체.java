import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] prime = new int[n+1];
        int count = 0;
        for(int i=2; i<=n; i++) {
            for (int j = i; j <= n; j += i) {
                if (prime[j] == 0) {
                    prime[j] = 1;
                    count++;
                    if (count == k) {
                        bw.write(j + "\n");
                        bw.flush();
                        return;
                    }
                }
            }
        }
    }
}

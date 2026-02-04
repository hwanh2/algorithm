import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] durability;
    static int[] weight;
    static int maxBroken = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        durability = new int[n];
        weight = new int[n];

        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            durability[i] = Integer.parseInt(st.nextToken());
            weight[i] = Integer.parseInt(st.nextToken());
        }

        solve(0);
        System.out.println(maxBroken);
    }

    static void solve(int cur) {
        if (cur == n) {
            int count=0;
            for (int d : durability) {
                if (d<=0) {
                    count++;
                }
            }
            maxBroken = Math.max(maxBroken, count);
            return;
        }
        
        if (durability[cur]<=0) {
            solve(cur+1);
            return;
        }

        boolean hit = false;

        for (int target=0; target<n; target++) {
            if (cur == target || durability[target] <= 0) continue;

            hit = true;

            durability[cur] -= weight[target];
            durability[target] -= weight[cur];

            solve(cur + 1);

            durability[cur] += weight[target];
            durability[target] += weight[cur];
        }
        
        if (!hit) {
            solve(cur+1);
        }
    }
}
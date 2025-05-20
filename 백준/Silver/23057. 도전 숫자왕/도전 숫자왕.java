import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] array;
    static Set<Integer> set = new HashSet<>();

    static void backTracking(int start, int sum) {
        set.add(sum);  // 현재까지의 합 저장

        for (int i = start; i < n; i++) {
            backTracking(i + 1, sum + array[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        array = new int[n];

        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
            totalSum += array[i];
        }

        backTracking(0, 0);
        
        int result = totalSum - (set.size() - 1);  // 0은 제외
        System.out.println(result);
    }
}

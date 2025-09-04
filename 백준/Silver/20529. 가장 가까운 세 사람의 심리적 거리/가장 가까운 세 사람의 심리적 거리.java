import java.io.*;
import java.util.*;

public class Main {
    static int dist(String a, String b) {
        int d = 0;
        for (int i = 0; i < 4; i++) {
            if (a.charAt(i) != b.charAt(i)) d++;
        }
        return d;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            // MBTI n개를 안전하게 모두 읽기 (여러 줄일 수도 있으니)
            List<String> mbti = new ArrayList<>(n);
            while (mbti.size() < n) {
                String line = br.readLine();
                if (line == null || line.isEmpty()) continue;
                StringTokenizer st = new StringTokenizer(line, " ");
                while (st.hasMoreTokens() && mbti.size() < n) {
                    mbti.add(st.nextToken());
                }
            }

            // n > 32면 반드시 0
            if (n > 32) {
                sb.append(0).append('\n');
                continue;
            }

            int ans = 12; // 최대 4+4+4
            // 세 명을 뽑아서 세 쌍 거리 합의 최소값을 구함
            outer:
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int dij = dist(mbti.get(i), mbti.get(j));
                    for (int k = j + 1; k < n; k++) {
                        int sum = dij
                                + dist(mbti.get(i), mbti.get(k))
                                + dist(mbti.get(j), mbti.get(k));
                        if (sum < ans) ans = sum;
                        if (ans == 0) break outer; // 더 줄일 수 없음
                    }
                }
            }

            sb.append(ans).append('\n');
        }

        System.out.print(sb.toString());
    }
}

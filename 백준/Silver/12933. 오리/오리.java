import java.io.*;
import java.util.*;

public class Main {
    static String target = "quack";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        boolean[] visited = new boolean[input.length()];
        int count = 0;

        if (input.length() % 5 != 0) {
            System.out.println(-1);
            return;
        }

        while (true) {
            int idx=0;
            int flag = 0;

            for (int i = 0; i < input.length(); i++) {
                if (!visited[i] && input.charAt(i) == target.charAt(idx)) {
                    visited[i] = true;
                    idx++;
                    if (idx == 5) idx = 0; // quack 한 세트 완료
                    flag = 1;
                }
            }

            if (flag == 0) break;

            if (idx != 0) {
                System.out.println(-1);
                return;
            }
            count++;
        }

        for (boolean v : visited) {
            if (!v) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(count);
    }
}

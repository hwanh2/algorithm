import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(br.readLine());
        }

        int len = list.get(0).length();

        for (int i = 1; i <= len; i++) {
            Set<String> set = new HashSet<>();
            boolean ok = true;
            for (String s : list) {
                String suf = s.substring(len - i);
                if (!set.add(suf)) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                System.out.println(i);
                return;
            }
        }
    }
}

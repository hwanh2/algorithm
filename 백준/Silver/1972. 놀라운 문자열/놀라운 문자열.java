import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String str = br.readLine();
            if (str.equals("*")) {
                System.out.println(sb);
                break;
            }
            boolean setFlag = false;
            for (int i = 1; i < str.length(); i++) {
                Set<String> set = new HashSet<>();
                for (int j = 0; j < str.length() - i; j++) {
                    String tmp = "" + str.charAt(j) + str.charAt(j + i);
                    if (set.contains(tmp)) {
                        setFlag = true;
                        break;
                    } else {
                        set.add(tmp);
                    }
                }
            }
            if (setFlag) {
                sb.append(str + " is NOT surprising.\n");
            } else {
                sb.append(str + " is surprising.\n");
            }
        }
    }
}


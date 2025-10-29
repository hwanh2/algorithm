import java.io.*;
import java.util.*;

public class Main {
    private static HashMap<Integer, Integer> map = new HashMap<>();
    private static HashMap<Integer, Integer> order = new HashMap<>(); 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            if (!order.containsKey(n)) {
                order.put(n, i); 
            }
            map.put(n, map.getOrDefault(n, 0) + 1); 
        }

        List<Integer> keySet = new ArrayList<>(map.keySet());

        Collections.sort(keySet, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (Objects.equals(map.get(o1), map.get(o2))) {
                    return order.get(o1).compareTo(order.get(o2));
                }
                
                return map.get(o2).compareTo(map.get(o1));
            }
        });

        for (int key : keySet) {
            for (int i = 0; i < map.get(key); i++) {
                bw.write(key + " ");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
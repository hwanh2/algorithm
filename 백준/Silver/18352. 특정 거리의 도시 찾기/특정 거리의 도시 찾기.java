import java.io.*;
import java.util.*;

public class Main {
    static int[] distance;
    static Queue<Integer> queue;
    static List<List<Integer>> arrayList;

    static void shortestPath(int start){
        queue = new LinkedList<>();
        distance[start] = 0;
        queue.offer(start);

        while(!queue.isEmpty()){
            int tmp = queue.poll();
            for(int edge : arrayList.get(tmp)){
                if(distance[edge] == Integer.MAX_VALUE){
                    distance[edge] = distance[tmp] + 1;
                    queue.offer(edge);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        arrayList = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            arrayList.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arrayList.get(a).add(b);
        }

        shortestPath(start);

        for(int i = 1; i <= n; i++) {
            if(distance[i] == k) {
                sb.append(i).append("\n");
            }
        }

        if(sb.length() == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sb);
        }
    }
}

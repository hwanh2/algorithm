import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[] visited;
    static Queue<Integer> queue;
    static List<List<Integer>> list;
    static int[] result;
    static int max = 0;
    static void bfs(int start){
        int count = 0;
        queue = new LinkedList<>();
        visited = new int[n+1];
        visited[start] = 1;
        queue.add(start);

        while (!queue.isEmpty()){
            int num = queue.poll();

            for(int tmp : list.get(num)){
                if(visited[tmp]==0){
                    queue.add(tmp);
                    visited[tmp] = 1;
                    count++;
                }
            }
        }
        max = Math.max(max,count);
        result[start] = count;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        result = new int[n+1];

        list = new ArrayList<>();
        for(int i=0; i<=n; i++){
            list.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(b).add(a);
        }

        for(int i=1; i<=n; i++){
            bfs(i);
        }

        for(int i=1; i<=n; i++){
            if(result[i]==max){
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }
}

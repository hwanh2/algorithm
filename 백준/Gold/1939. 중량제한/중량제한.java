import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int start,goal;
    static List<List<Edge>> list;
    static boolean[] visited;
    static class Edge{
        public int node;
        public int weight;

        public Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
    static boolean bfs(int weight){
        visited = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int node = queue.poll();

            if(node==goal){
                return true;
            }
            for(Edge edge : list.get(node)){
                if(edge.weight>=weight && !visited[edge.node]){
                    visited[edge.node] = true;
                    queue.add(edge.node);
                }
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for(int i=0; i<=n; i++){
            list.add(new ArrayList<>());
        }

        int max = 0;
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(a).add(new Edge(b,c));
            list.get(b).add(new Edge(a,c));
            max = Math.max(max,c);
        }

        st = new StringTokenizer(br.readLine()," ");
        start = Integer.parseInt(st.nextToken());
        goal = Integer.parseInt(st.nextToken());

        int left = 0;
        int right = max;
        int result = 0;
        while(left<=right){
            int mid = (left+right)/2;

            if(bfs(mid)){
                result = mid;
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }

        System.out.println(result);
    }
}
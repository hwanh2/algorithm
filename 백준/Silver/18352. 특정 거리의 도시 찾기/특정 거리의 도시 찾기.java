import java.io.*;
import java.util.*;

public class Main {
    static int[] distance;
    static int[] visited;
    static Queue<Integer> queue;
    static ArrayList<ArrayList<Integer>> arrayList;
    static void shortestPath(int start){
        queue = new LinkedList<>();
        distance[start] = 0;
        queue.offer(start);
        while(!queue.isEmpty()){
            int tmp = queue.poll();
            if(visited[tmp]==0){
                visited[tmp]=1;
                for(int edge : arrayList.get(tmp)){
                    if(distance[tmp]+1<distance[edge]){
                        distance[edge] = distance[tmp]+1;
                        queue.offer(edge);
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        distance = new int[n+1];
        visited = new int[n+1];
        Arrays.fill(distance,Integer.MAX_VALUE);

        arrayList = new ArrayList<>();
        for(int i=0; i<=n; i++){
            arrayList.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arrayList.get(a).add(b);
        }

        shortestPath(start);
        int flag = 0;
        for(int i=1; i<distance.length; i++){
            if(distance[i]==k){
                sb.append(i).append("\n");
                flag = 1;
            }
        }
        if(flag==0){
            System.out.println(-1);
        }
        System.out.println(sb);
    }
}

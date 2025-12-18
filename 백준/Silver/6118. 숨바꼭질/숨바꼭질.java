import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int m;
    static int[][] map;
    static ArrayList<ArrayList<Integer>> arrayList;
    static Queue<Integer> queue = new LinkedList<>();
    static int[] distance;
    static int[] visited;
    static int max = 0;
    static void bfs(){
        queue.add(1);
        visited[1] = 1;
        while(!queue.isEmpty()){
            int start = queue.poll();

            for(int next : arrayList.get(start)){
                if(visited[next]==0){
                    visited[next] = 1;
                    queue.add(next);
                    distance[next] = distance[start]+1;
                    max = Math.max(max, distance[next]);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arrayList = new ArrayList<>();
        for(int i=0; i<=n; i++){
            arrayList.add(new ArrayList<>());
        }
        distance = new int[n+1];
        visited = new int[n+1];

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arrayList.get(a).add(b);
            arrayList.get(b).add(a);
        }

        bfs();

        int resultEdge = 0;
        int resultEdgeFlag = 0;
        int count = 0;
        
        for(int i=1; i<=n; i++){
            if(resultEdgeFlag==0 && distance[i]==max){
                resultEdgeFlag = 1;
                resultEdge = i;
            }

            if(distance[i]==max){
                count++;
            }
        }

        System.out.println(resultEdge+" "+max+" "+count);
        
    }
}
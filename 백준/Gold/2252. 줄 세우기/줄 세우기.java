import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static int[] inDegree;
    static ArrayList<ArrayList<Integer>> arrayList;
    static Queue<Integer> queue;
    static String topologySort(){
        StringBuilder sb = new StringBuilder();
        queue = new LinkedList<>();

        for(int i=1; i<=n; i++){
            if(inDegree[i]==0){
                queue.add(i);
            }
        }

        while (!queue.isEmpty()){
            int num = queue.poll();
            sb.append(num).append(" ");

            for(int next : arrayList.get(num)){
                inDegree[next]--;
                if(inDegree[next]==0){
                    queue.add(next);
                }
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        inDegree = new int[n+1];
        arrayList = new ArrayList<>();
        for(int i=0; i<=n; i++){
            arrayList.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arrayList.get(a).add(b);
            inDegree[b]++;
        }

        System.out.println(topologySort());
    }
}
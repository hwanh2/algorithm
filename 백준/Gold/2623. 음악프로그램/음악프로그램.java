import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static int[] inDegree;
    static ArrayList<ArrayList<Integer>> arrayList;
    static Queue<Integer> queue;
    static String solve(){
        int count = 0;
        StringBuilder sb = new StringBuilder();
        queue = new LinkedList<>();

        for(int i=1; i<=n; i++){
            if(inDegree[i]==0){
                queue.add(i);
            }
        }

        while (!queue.isEmpty()){
            int num = queue.poll();
            sb.append(num).append("\n");
            count++;

            for(int next : arrayList.get(num)){
                inDegree[next]--;
                if(inDegree[next]==0){
                    queue.add(next);
                }
            }
        }

        if(count==n){
            return sb.toString();
        }
        else{
            return "0";
        }
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
            int num = Integer.parseInt(st.nextToken());

            int start = Integer.parseInt(st.nextToken());

            for(int j=0; j<num-1; j++){
                int next = Integer.parseInt(st.nextToken());
                inDegree[next]++;
                arrayList.get(start).add(next);
                start = next;
            }
        }


        System.out.println(solve());
    }
}
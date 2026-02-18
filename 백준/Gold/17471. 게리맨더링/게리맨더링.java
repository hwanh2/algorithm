import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] person;
    static List<List<Integer>> arrayList;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    static void combination(int start,int depth,int max){
        if(depth==max){
            solve();
            return;
        }
        for(int i=start; i<=n; i++){
            if(!visited[i]){
                visited[i] = true;
                combination(i+1,depth+1,max);
                visited[i] = false;
            }
        }
    }
    static void solve(){
        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();

        for (int i=1; i<=n; i++) {
            if(visited[i]){
                listA.add(i);
            }
            else{
                listB.add(i);
            }
        }

        if (bfs(listA) && bfs(listB)) {
            int sumA = 0;
            int sumB = 0;
            for (int node : listA){
                sumA += person[node];
            }
            for (int node : listB){
                sumB += person[node];
            }

            min = Math.min(min, Math.abs(sumA-sumB));
        }
    }
    static boolean bfs(List<Integer> list){
        int start = list.get(0);
        boolean[] visited2 = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited2[start] = true;
        int count = 1;

        while(!queue.isEmpty()){
            int cur = queue.poll();

            for(int num : arrayList.get(cur)){
                if(list.contains(num) && !visited2[num]){
                    queue.add(num);
                    visited2[num] = true;
                    count++;
                }
            }
        }
        return count==list.size();
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        person = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++){
            person[i+1] = Integer.parseInt(st.nextToken());
        }

        arrayList = new ArrayList<>();
        for(int i=0; i<=n; i++){
            arrayList.add(new ArrayList<>());
        }

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine()," ");
            int count = Integer.parseInt(st.nextToken());
            for(int j=0; j<count; j++){
                int num = Integer.parseInt(st.nextToken());
                arrayList.get(i).add(num);
            }
        }

        for(int i=1; i<=n/2; i++){
            visited = new boolean[n+1];
            combination(1,0,i);
        }

        if(min == Integer.MAX_VALUE) {
            System.out.println(-1);
        }else {
            System.out.println(min);
        }
    }
}
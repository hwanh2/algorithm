import java.io.*;
import java.util.*;

public class Main {
    static int[] prime;
    static Queue<Integer> queue;
    static int[] visited;
    static int[] count;
    static void bfs(){
        while(!queue.isEmpty()){
            int num = queue.poll();
            for(int i=0; i<4; i++){
                for(int j=0; j<=9; j++){
                    if(i==0 && j==0){
                        continue;
                    }
                    int k = change(num,i,j);
                    if(prime[k]==0 && visited[k]==0){
                        queue.add(k);
                        visited[k] = 1;
                        count[k] = count[num]+1;
                    }
                }
            }
        }
    }
    static int change(int num,int i,int j){
        char[] arr = String.valueOf(num).toCharArray();
        arr[i] = (char)(j + '0');
        int newNum = Integer.parseInt(new String(arr));
        return newNum;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        prime = new int[10000];
        for(int i=2; i*i<10000; i++){
            if(prime[i]==0){
                for(int j=i*i; j<10000; j+=i){
                    prime[j] = 1;
                }
            }
        }

        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            visited = new int[10000];
            count = new int[10000];

            queue = new LinkedList<>();
            queue.add(a);
            visited[a] = 1;

            bfs();

            sb.append(count[b]).append("\n");
        }
        System.out.println(sb);
    }
}

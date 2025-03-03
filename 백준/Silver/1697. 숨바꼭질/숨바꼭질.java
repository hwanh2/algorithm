import java.io.*;
import java.util.*;

public class Main {
    static int[] array = new int[100001];
    static Queue<Integer> queue = new LinkedList<>();
    static void bfs(int k){
        while(!queue.isEmpty()){
            int tmp = queue.poll();
            if(tmp==k){
                System.out.println(array[k]-1);
                return;
            }
            if(tmp*2<100001 && array[tmp*2]==0){
                array[tmp*2] = array[tmp]+1;
                queue.offer(tmp*2);
            }
            if(tmp-1>=0 && array[tmp-1]==0){
                array[tmp-1] = array[tmp]+1;
                queue.offer(tmp-1);
            }
            if(tmp+1<100001 && array[tmp+1]==0 ){
                array[tmp+1] = array[tmp]+1;
                queue.offer(tmp+1);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        if(n==k){
            System.out.println(0);
            return;
        }
        array[n] = 1;
        queue.offer(n);
        bfs(k);
    }
}
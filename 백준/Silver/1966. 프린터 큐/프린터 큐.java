import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            Queue<int[]> queue = new LinkedList<>();

            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<n; j++){
                queue.offer(new int[] {j,Integer.parseInt(st.nextToken())});
            }
            int count = 0;

            while(!queue.isEmpty()){
                int[] tmp = queue.poll();
                int flag = 1;
                for(int[] q : queue){
                    if(tmp[1]<q[1]){
                        flag = 0;
                    }
                }
                if(flag==0){
                    queue.offer(tmp);
                }
                else{
                    count++;
                    if(tmp[0]==m){
                        sb.append(count).append("\n");
                        break;
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
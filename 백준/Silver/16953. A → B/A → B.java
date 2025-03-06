import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        Queue<Long> queue = new LinkedList<>();
        queue.offer(n);
        int count = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                long tmp = queue.poll();
                if(tmp==m){
                    System.out.println(count);
                    return;
                }
                if(tmp*2<=m){
                    queue.offer(tmp*2);
                }
                if(Long.parseLong(tmp+"1")<=m){
                    queue.offer(Long.parseLong(tmp+"1"));
                }
            }
            count++;
        }
        bw.write(-1+"\n");
        bw.flush();
    }
}

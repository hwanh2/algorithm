import java.io.*;
import java.util.*;

public class Main {
    static int[][] array;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> queue = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());
        for(int i=1; i<=n; i++){
            queue.offer(i);
        }
        while(queue.size()>1){
            queue.poll();
            Integer tmp = queue.poll();
            queue.offer(tmp);
        }
        bw.write(queue.poll()+"\n");
        bw.flush();
    }
}

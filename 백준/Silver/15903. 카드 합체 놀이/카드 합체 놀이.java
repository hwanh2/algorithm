import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        PriorityQueue<Long> pq = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++){
            pq.add(Long.parseLong(st.nextToken()));
        }

        for(int i=0; i<m; i++){
            long tmp = pq.poll()+pq.poll();
            pq.add(tmp);
            pq.add(tmp);

        }

        long result = 0;
        for(long tmp : pq){
            result+=tmp;
        }

        System.out.println(result);

    }
}

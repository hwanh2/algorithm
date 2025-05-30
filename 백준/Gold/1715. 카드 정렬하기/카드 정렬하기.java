import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            pq.add(Long.parseLong(br.readLine()));
        }

        long result = 0;
        while (pq.size()>1){
            long a = pq.poll();
            long b = pq.poll();
            result+=(a+b);
            pq.add(a+b);
        }

        System.out.println(result);

    }
}

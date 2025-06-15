import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int[] array = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);
        //k개의 그룹이 나오게 하려면 간격을 k-1개를 끊어야 함
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<n-1; i++){
            pq.add(array[i+1]-array[i]);
        }

        int result = 0;
        for(int i=0; i<n-k; i++){
            result+=pq.poll();
        }
        System.out.println(result);
    }
}
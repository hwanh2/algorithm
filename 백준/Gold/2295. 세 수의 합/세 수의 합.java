import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] u = new int[n];
        for(int i=0; i<n; i++){
            u[i] = Integer.parseInt(br.readLine());
        }

        List<Integer> list = new ArrayList<>();

        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                list.add(u[i]+u[j]);
            }
        }

        Collections.sort(list);

        int max = 0;
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                int z = u[i];
                int k = u[j];
                if(Collections.binarySearch(list,k-z)>=0){
                    max = Math.max(max,k);
                }
            }
        }
        System.out.println(max);
    }
}
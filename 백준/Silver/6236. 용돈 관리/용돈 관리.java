import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] array = new int[n];
        int max = 0, min = 0;
        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(br.readLine());
            max+=array[i];
            min = Math.max(min,array[i]);
        }
        int result = 0;
        while(min<=max){
            int count = 1;
            int mid = (min+max)/2;
            int nowCost = mid;
            for(int i=0; i<n; i++){
                if(nowCost<array[i]){
                    count++;
                    nowCost = mid;
                }
                nowCost-=array[i];

            }
            if(m>=count){
                result = mid;
                max = mid-1;
            }
            else{
                min = mid+1;
            }
        }
        System.out.println(result);
    }
}

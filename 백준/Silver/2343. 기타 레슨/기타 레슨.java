import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] array = new int[n];
        st = new StringTokenizer(br.readLine()," ");
        int left = 0, right = 0;
        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(st.nextToken());
            left = Math.max(left,array[i]);
            right+=array[i];
        }

        while(left<right){
            int mid = (left+right)/2;

            int count = 1;
            int sum = array[0];

            for(int i=1; i<n; i++){
                if(sum+array[i]>mid){
                    count++;
                    sum = array[i];
                }
                else{
                    sum+=array[i];
                }
            }

            if(count>m){
                left = mid+1;
            }
            else{
                right = mid;
            }
        }
        System.out.println(left);

    }
}

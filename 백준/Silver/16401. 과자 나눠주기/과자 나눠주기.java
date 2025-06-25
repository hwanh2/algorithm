import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] array = new int[n];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);

        int left = 1;
        int right = array[n-1];

        while(left<=right){
            int count = 0;
            int mid = (left+right)/2;

            for(int i=0; i<n; i++){
                if(array[i]>=mid){
                    count+=array[i]/mid;
                }
            }

            if(count>=m){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        System.out.println(right);
    }
}

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        int left = 1;
        int right = 0;
        
        int[] array = new int[m];
        for(int i=0; i<m; i++){
            array[i] = Integer.parseInt(br.readLine());
            right = Math.max(right,array[i]);
        }
        
        while(left<=right){
            int count = 0;
            int mid = (left+right)/2;

            for(int i=0; i<m; i++){
                if(array[i]%mid==0){
                    count+=array[i]/mid;
                }
                else{
                    count+=array[i]/mid+1;
                }
            }

            if(count>n){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        System.out.println(left);
        
        
    }
}

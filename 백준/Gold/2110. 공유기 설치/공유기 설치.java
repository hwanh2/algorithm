import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] array = new int[n];
        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(array);
        int left = 0;
        int right = array[n-1];
        int result = 0;

        while(left<=right){
            int mid = (left+right)/2;
            int count = 1;
            int lastPos = array[0];

            for(int i=1; i<n; i++){
                if(array[i]-lastPos>=mid){
                    count++;
                    lastPos = array[i];
                }
            }

            if(count>=c){
                result = mid;
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        System.out.println(left-1);
    }
}

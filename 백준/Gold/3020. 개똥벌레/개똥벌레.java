import java.io.*;
import java.util.*;

public class Main {
    static int[] bottom;
    static int[] top;
    static int bSearch(int height){
        int left = 0;
        int right = bottom.length;

        while (left<right){
            int mid = (left+right)/2;

            if(bottom[mid]>=height){
                right = mid;
            }
            else{
                left = mid+1;
            }
        }
        return bottom.length-right;
    }
    static int tSearch(int height){
        int left = 0;
        int right = top.length;

        while (left<right){
            int mid = (left+right)/2;

            if(top[mid]>=height){
                right = mid;
            }
            else{
                left = mid+1;
            }
        }
        return top.length-right;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        bottom = new int[n/2];
        top = new int[n/2];

        for(int i=0; i<n/2; i++){
            bottom[i] = Integer.parseInt(br.readLine());
            top[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bottom);
        Arrays.sort(top);

        int min = n;
        int total = 0;

        for(int i=1; i<=h; i++){
            int count = bSearch(i);
            count += tSearch(h-i+1);

            if(count<min) {
                min = count;
                total = 1;
            }
            else if(min==count){
                total++;
            }
        }
        System.out.println(min+" "+total);
    }

}
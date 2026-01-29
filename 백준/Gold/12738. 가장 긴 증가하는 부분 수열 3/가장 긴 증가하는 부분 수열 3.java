import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(array[0]);

        for(int i=1; i<n; i++){
            if(arrayList.get(arrayList.size()-1)<array[i]){
                arrayList.add(array[i]);
            }
            else{
                int left = 0;
                int right = arrayList.size()-1;

                while(left<right){
                    int mid = (left+right)/2;

                    if(arrayList.get(mid)<array[i]){
                        left = mid+1;
                    }
                    else{
                        right = mid;
                    }
                }

                arrayList.set(left,array[i]);
            }
        }
        System.out.println(arrayList.size());
    }
}
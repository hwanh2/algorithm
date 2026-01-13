import java.io.*;
import java.util.*;

public class Main {
    static List<Integer> list1;
    static List<Integer> list2;
    static int lowerBound(List<Integer> list, int target){
        int left = 0;
        int right = list.size();

        while(left<right){
            int mid = (left+right)/2;

            if(list.get(mid)>=target){
                right = mid;
            }
            else{
                left = mid+1;
            }
        }
        return right;
    }
    static int uppperBound(List<Integer> list, int target){
        int left = 0;
        int right = list.size();

        while(left<right){
            int mid = (left+right)/2;

            if(list.get(mid)>target){
                right = mid;
            }
            else{
                left = mid+1;
            }
        }
        return right;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        int[] array1 = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++){
            array1[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] array2 = new int[m];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<m; i++){
            array2[i] = Integer.parseInt(st.nextToken());
        }

        list1 = new ArrayList<>();
        list2 = new ArrayList<>();

        for(int i=0; i<n; i++){
            int sum = 0;
            for(int j=i; j<n; j++){
                sum+=array1[j];
                list1.add(sum);
            }
        }

        for(int i=0; i<m; i++){
            int sum = 0;
            for(int j=i; j<m; j++){
                sum+=array2[j];
                list2.add(sum);
            }
        }

        Collections.sort(list2);

        long count = 0;
        for(int num : list1){
            int target = t - num;

            count+=uppperBound(list2,target) - lowerBound(list2,target);
        }

        System.out.println(count);
    }
}
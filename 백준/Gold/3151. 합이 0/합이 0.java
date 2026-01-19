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

        Arrays.sort(array);

        long count = 0;

        for(int i=0; i<n; i++){
            int num = array[i];
            int left = i+1;
            int right = n-1;

            while(left<right){
                int sum = num+array[left]+array[right];
                if(sum>0){
                    right--;
                }
                else if(sum<0){
                    left++;
                }
                else{
                    if(array[left]==array[right]){
                        long gap = right-left+1;
                        count+=(gap*(gap-1))/2;
                        break;
                    }

                    long leftCount = 1;
                    while(left+1<right && array[left]==array[left+1]){
                        leftCount++;
                        left++;
                    }

                    long rightCount = 1;
                    while(right-1>left && array[right] == array[right-1]){
                        rightCount++;
                        right--;
                    }

                    count+=leftCount*rightCount;

                    left++;
                    right--;

                }
            }
        }

        System.out.println(count);

    }
}
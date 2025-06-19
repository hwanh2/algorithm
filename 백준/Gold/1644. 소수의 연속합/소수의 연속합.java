import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n+1];

        for(int i=2; i*i<=n; i++){
            if(array[i]==0){
                for(int j=i*i; j<=n; j+=i){
                    array[j] = 1;
                }
            }
        }
        List<Integer> primeList = new ArrayList<>();
        int index = 0;
        for(int i=0; i<=n; i++){
            if(i>=2 && array[i]==0){
                primeList.add(i);
            }
        }

        int start=0, end=0, sum=0, count=0;
        while(true){
            if(sum>n){
                sum-=primeList.get(start++);
            }
            else if(end==primeList.size()){
                break;
            }
            else{
                sum+=primeList.get(end++);
            }
            if(sum==n){
                count++;
            }
        }
        System.out.println(count);

    }
}

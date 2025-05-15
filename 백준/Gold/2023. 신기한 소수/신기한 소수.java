import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static StringBuilder sb = new StringBuilder();
    static boolean isPrime(int num) {
        if(num <2) return false;
        for(int i=2 ; i*i<=num; i++) {
            if(num%i ==0) {
                return false;
            }
        }
        return true;
    }

    static void backTracking(int tmp, int num){
        if(num==n){
            if(isPrime(tmp)){
                sb.append(tmp).append("\n");
            }
            return;
        }
        for(int i=1; i<=9; i++){
            int result = 10*tmp+i;
            if(isPrime(result)){
                backTracking(result,num+1);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        backTracking(0,0);
        System.out.println(sb);

    }
}

import java.io.*;
import java.util.*;

class Main {
    static int n;
    static boolean[] width;
    static boolean[] diagonal1;
    static boolean[] diagonal2;
    static int result = 0;
    static void backTracking(int depth){
        if(depth==n){
            result++;
            return;
        }
        for(int i=0; i<n; i++){
            if(width[i]||diagonal1[depth+i]||diagonal2[i-depth+n]){
                continue;
            }
            width[i] = diagonal1[i+depth] = diagonal2[i-depth+n] = true;
            backTracking(depth+1);
            width[i] = diagonal1[i+depth] = diagonal2[i-depth+n] = false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        width = new boolean[n];
        diagonal1 = new boolean[n*2];
        diagonal2 = new boolean[n*2];

        backTracking(0);

        System.out.println(result);
    }
}

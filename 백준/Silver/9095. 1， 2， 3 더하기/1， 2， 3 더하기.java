import java.util.*;

public class Main {
    static int[] dy;
    static void solve(int n){
        dy[1] = 1;
        dy[2] = 2;
        dy[3] = 4;
        for(int i=4; i<11; i++){
            dy[i] = dy[i-1]+dy[i-2]+dy[i-3];
        }
        System.out.println(dy[n]);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0; i<t; i++){
            int n = sc.nextInt();
            dy = new int[12];
            solve(n);
        }
    }
}

import java.util.*;

public class Main {
    static int[] dy;
    static int[] array;
    static void solve(int n){
        for(int i=3; i<=n; i++){
            dy[i] = Math.max(dy[i-3]+array[i-1],dy[i-2])+array[i];
        }
        System.out.println(dy[dy.length-1]);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        array = new int[n+1];
        dy = new int[n+1];
        for(int i=1; i<=n; i++){
            array[i] = sc.nextInt();
        }
        dy[1] = array[1];
        if(n>=2){
            dy[2] = array[1]+array[2];
        }
        solve(n);

    }
}

import java.util.*;

public class Main {
    static int[] dy;
    static int[] array;
    static void solve(){
        dy[0] = 1;
        int result = 0;
        for(int i=1; i<array.length; i++){
            int max = 0;
            for(int j=i-1; j>=0; j--){
                if(array[i]>array[j] && dy[j]>max){
                    max = dy[j];
                }
            }
            dy[i] = max+1;
            result = Math.max(dy[i],result);
        }
        System.out.println(result);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        array = new int[n];
        dy = new int[n];
        for(int i=0; i<n; i++){
            array[i] = sc.nextInt();
        }
        if(n==1){
            System.out.println(1);
            return;
        }
        solve();
    }
}

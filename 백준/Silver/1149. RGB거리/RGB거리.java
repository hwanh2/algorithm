import java.util.*;

public class Main {
    static int[][] array;
    static int[][] dy;
    static void solve(int n){
        for(int i=1; i<n; i++){
            dy[i][0] = Math.min(dy[i-1][1],dy[i-1][2])+array[i][0];
            dy[i][1] = Math.min(dy[i-1][0],dy[i-1][2])+array[i][1];
            dy[i][2] = Math.min(dy[i-1][0],dy[i-1][1])+array[i][2];
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        array = new int[n][3];
        dy = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                array[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < 3; i++) {
            dy[0][i] = array[0][i];
        }
        solve(n);
        int result = dy[n-1][0];
        for(int i=1; i<3; i++){
            result = Math.min(result,dy[n-1][i]);
        }
        System.out.println(result);
    }
}

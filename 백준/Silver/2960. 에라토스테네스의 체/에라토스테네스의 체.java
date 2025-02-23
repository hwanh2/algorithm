import java.util.*;

public class Main {
    public static boolean isPrime(int num){
        if (num < 2) return false;
        for(int i=2; i<=num/2; i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] visited = new int[n+1];
        int[] array = new int[n+1];
        int index = 0;
        for(int i=2; i<=n; i++){
            if(isPrime(i) && visited[i]==0){
                for(int j=1; i*j<=n; j++){
                    if(visited[i*j]==0){
                        array[index++] = i*j;
                        visited[i*j] = 1;
                    }
                }
            }
        }
        System.out.println(array[k-1]);
    }
}

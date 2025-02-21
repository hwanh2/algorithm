import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);

       int n = sc.nextInt();
       int count = 0;

       for(int i=1; i<n; i++){
           int sum = 0;
           for(int j=i; j<n; j++){
               sum+=j;
               if(sum == n){
                   count++;
                   break;
               }
               else if(sum>n){
                   break;
               }
           }
       }
       System.out.println(count+1);
    }
}

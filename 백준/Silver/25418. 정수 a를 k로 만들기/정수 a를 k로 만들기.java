import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int a = sc.nextInt();
       int k = sc.nextInt();
       int result = 0;

       while(a!=k){
           if(a>k/2){
               k--;
               result++;
           }
           else if(k%2==0){
               k/=2;
               result++;
           }
           else{
               k--;
               result++;
           }

       }
       System.out.println(result);

    }
}

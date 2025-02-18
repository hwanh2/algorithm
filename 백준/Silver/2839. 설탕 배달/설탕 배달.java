import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num = n/5;
        int result = -1;

        while(num>=0){
            int tmp = n-num*5;

            if(tmp%3==0){
                result = num+tmp/3;
                break;
            }
            else{
                num--;
            }

        }
        System.out.println(result);

    }

}
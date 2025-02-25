import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int e = sc.nextInt();
        int s = sc.nextInt();
        int m = sc.nextInt();
        int result = 0;
        if(e==15 && s==28 && m==19){
            System.out.println(7980);
            return;
        }
        while(true){
            if((result-e)%15==0 && (result-s)%28==0 && (result-m)%19==0){
                break;
            }
            result++;
        }
        System.out.println(result);
    }
}

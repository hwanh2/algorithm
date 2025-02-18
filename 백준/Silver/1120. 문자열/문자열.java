import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        int startIndex = 0;
        int result = 50;

        int size = b.length() - a.length()+1;

        for(int i=0; i<size; i++){
            int count = 0;
            for(int j=0; j<a.length(); j++){
                if(a.charAt(j)!=b.charAt(startIndex+j)){
                    count++;
                }
            }
            if(count<result) {
                result = count;
            }
            startIndex++;
        }
        System.out.println(result);
    }

}

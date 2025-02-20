import java.util.Scanner;

public class Main {
    public static int compare(String a, String b) {
        String str1 = a+b;
        String str2 = b+a;
        return str2.compareTo(str1);
    }

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       String[] array = new String[n];
       String result = "";

       sc.nextLine();
       String str = sc.nextLine();

       String[] num = str.split(" ");

       for(int i=0; i<num.length-1; i++){
           for(int j=i+1; j<num.length; j++){
               if(compare(num[i],num[j])>0){
                   String tmp = num[i];
                   num[i] = num[j];
                   num[j] = tmp;
               }
           }
       }

       for(int i=0; i<num.length; i++){
           result+=num[i];
       }
       if(result.charAt(0)=='0'){
           System.out.println(0);
       }
       else{
           System.out.println(result);
       }

    }
}

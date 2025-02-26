import java.util.*;

public class Main {
    static String str;
    static String word;
    static void solve(){
        int count = 0;
        int index = 0;
        for(int i=index; i<=str.length()-word.length(); i++){
            int flag = 0;
            for(int j=0; j<word.length(); j++){
                if(word.charAt(j) != str.charAt(i+j)) {
                    flag = 1;
                    break;
                }
            }
            if(flag==0){
                count++;
                index+=word.length();
                i = index-1;
            }
            else{
                index++;
            }
        }
        System.out.println(count);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        str = sc.nextLine();
        word = sc.nextLine();
        solve();
    }
}

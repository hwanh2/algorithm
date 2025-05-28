import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int[] countAlpha = new int[26];

        for(int i=0; i<str.length(); i++){
            countAlpha[str.charAt(i)-'A']++;
        }

        char oddChar=0;
        int oddCount = 0;
        for(int i=0; i<26; i++){
            if(countAlpha[i]%2==1){
                oddCount++;
                oddChar = (char)('A'+i);
            }
        }
        if(oddCount>1){
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        String result = "";
        for(int i=0; i<26; i++){
            for(int j=0; j<countAlpha[i]/2; j++){
                result+=(char)('A'+i);
            }
        }
        String tmp = new StringBuilder(result).reverse().toString();
        if(oddCount==1){
            result+=oddChar;
        }
        result+=tmp;
        System.out.println(result);

    }
}

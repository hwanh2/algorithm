import java.io.*;
import java.util.*;

public class Main {
    static String str = null;
    static Stack<Character> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();
    static void solve(){
        ArrayList<Character> array = new ArrayList<>();
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)=='<'){
                for(int j=array.size()-1; j>=0; j--){
                    sb.append(array.get(j));
                }
                array.clear();
                stack.push(' ');
            }
            if(!stack.isEmpty()){
                if(str.charAt(i)!='>'){
                    sb.append(str.charAt(i));
                }
                else{
                    stack.pop();
                    sb.append('>');
                }
            }
            else{
                if(str.charAt(i)==' '){
                    for(int j=array.size()-1; j>=0; j--){
                        sb.append(array.get(j));
                    }
                    sb.append(" ");
                    array.clear();
                }
                else{
                    array.add(str.charAt(i));
                }
            }
        }
        for(int j=array.size()-1; j>=0; j--){
            sb.append(array.get(j));
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        str = br.readLine();
        solve();
        System.out.println(sb);
    }
}
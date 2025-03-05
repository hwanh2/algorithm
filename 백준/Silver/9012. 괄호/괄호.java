import java.io.*;
import java.util.*;

public class Main {
    static Stack<Character> stack = new Stack<>();
    static void solve(String str){
        stack.clear();
        int flag = 0;
        for(int i=0; i<str.length(); i++){
            Character ch = str.charAt(i);
            if(ch=='('){
                stack.push(ch);
            }
            else if(ch==')'){
                if(stack.isEmpty()){
                    flag = 1;
                    break;
                }
                stack.pop();
            }
        }
        if(!stack.empty()){
            flag = 1;
        }
        if(flag == 0){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            String str = br.readLine();
            solve(str);
        }
    }
}

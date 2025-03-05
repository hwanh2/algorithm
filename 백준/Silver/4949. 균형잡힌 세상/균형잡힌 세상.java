import java.io.*;
import java.util.*;

public class Main {
    static Stack<Character> stack = new Stack<>();
    static void solve(String str){
        stack.clear();
        int flag = 0;
        for(int i=0; i<str.length(); i++){
            Character ch = str.charAt(i);
            if(ch=='[' || ch=='('){
                stack.push(ch);
            }
            else if(ch==']'){
                if(stack.empty() || stack.pop()!='['){
                    flag = 1;
                    break;
                }
            }
            else if(ch==')'){
                if(stack.empty() || stack.pop()!='('){
                    flag = 1;
                    break;
                }
            }
        }
        if(!stack.empty()){
            flag = 1;
        }
        if(flag == 1){
            System.out.println("no");
        }
        else{
            System.out.println("yes");
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true){
            String str = br.readLine();
            if(str.equals(".")){
                break;
            }
            solve(str);
        }
    }
}

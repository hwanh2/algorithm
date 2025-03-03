import java.io.*;
import java.util.*;

public class Main {
    static Stack<Character> stack = new Stack<>();
    static int prec(char op){
        switch (op){
            case '(': case ')': return 0;
            case '+': case '-': return 1;
            case '*': case '/': return 2;
        }
        return -1;
    }

    static void solve(String str){
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            switch (ch){
                case '+': case '-': case '*': case '/':
                    while(!stack.isEmpty() && prec(ch)<=prec(stack.peek())){
                        System.out.print(stack.pop());
                    }
                    stack.push(ch);
                    break;
                case '(':
                    stack.push(ch);
                    break;
                case ')':
                    while(stack.peek() != '('){
                        System.out.print(stack.pop());
                    }
                    stack.pop();
                    break;
                default:
                    System.out.print(ch);
                    break;
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        solve(str);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] stack;
    static int index = -1;
    static boolean isEmpty(){
        return index==-1;
    }
    static void push(int n){
        stack[++index] = n;
    }
    static int pop(){
        if(isEmpty()){
            return -1;
        }
        else{
            return stack[index--];
        }
    }
    static int empty(){
        if(isEmpty()){
            return 1;
        }
        else{
            return 0;
        }
    }
    static int size(){
        return index+1;
    }
    static int top(){
        if(isEmpty()){
            return -1;
        }
        return stack[index];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        stack = new int[n];
        StringTokenizer st;

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine()," ");
            switch (st.nextToken()){
                case "push":
                    int num = Integer.parseInt(st.nextToken());
                    push(num); break;
                case "pop":
                    sb.append(pop());
                    sb.append('\n');
                    break;
                case "size":
                    sb.append(size());
                    sb.append('\n');
                    break;
                case "empty":
                    sb.append(empty());
                    sb.append('\n');
                    break;
                case "top":
                    sb.append(top());
                    sb.append('\n'); break;
                default: break;
            }
        }
        System.out.println(sb);
    }
}

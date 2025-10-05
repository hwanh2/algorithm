import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int index = 1;
        while(true){
            Stack<Character> stack = new Stack<>();
            String str = br.readLine();
            int count = 0;
            if(str.contains("-")){
                break;
            }

            for(int i=0; i<str.length(); i++){
                if(str.charAt(i)=='{'){
                    stack.add('{');
                }
                else{
                    if(stack.isEmpty()){
                        stack.push('{');
                        count++;
                    }
                    else{
                        stack.pop();
                    }
                }
            }
            count+=stack.size()/2;
            sb.append(index).append(". ").append(count).append("\n");
            index++;
        }
        System.out.println(sb);
    }
}

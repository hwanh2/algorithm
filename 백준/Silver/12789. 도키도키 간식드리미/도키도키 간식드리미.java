import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<n; i++){
            queue.offer(Integer.parseInt(st.nextToken()));
        }

        int number = 1;
        while(!queue.isEmpty()){
            if(!stack.isEmpty() && stack.peek()==number){
                stack.pop();
                number++;
            }
            else if(queue.peek()==number){
                queue.poll();
                number++;
            }
            else{
                stack.push(queue.poll());
            }
        }

        while (!stack.isEmpty()){
            if(stack.peek()!=number){
                System.out.println("Sad");
                return;
            }
            else{
                stack.pop();
                number++;
            }
        }
        System.out.println("Nice");
    }
}

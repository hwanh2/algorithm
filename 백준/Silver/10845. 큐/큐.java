import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        int b = 0;
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            String str = st.nextToken();
            switch (str){
                case "push":
                    int tmp = Integer.parseInt(st.nextToken());
                    queue.offer(tmp);
                    b = tmp;
                    break;
                case "pop":
                    if(queue.isEmpty()){
                        System.out.println(-1);
                    }
                    else{
                        System.out.println(queue.poll());
                    }
                    break;
                case "size":
                    System.out.println(queue.size());
                    break;
                case "empty":
                    boolean value = queue.isEmpty();
                    if(value){
                        System.out.println(1);
                    }
                    else{
                        System.out.println(0);
                    }
                    break;
                case "front":
                    if(queue.isEmpty()){
                        System.out.println(-1);
                    }
                    else{
                        System.out.println(queue.peek());
                    }
                    break;
                case "back":
                    if(queue.isEmpty()){
                        System.out.println(-1);
                    }
                    else{
                        System.out.println(b);
                    }
                    break;
                default:
                    break;
            }
        }
    }
}

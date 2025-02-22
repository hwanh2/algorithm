import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    static int[][] mat;
    static Stack<Integer> stack = new Stack<>();
    static Queue<Integer> queue = new LinkedList<>();
    static void dfs(int start,int n){
        int[] visited = new int[n+1];
        visited[start] = 1;
        System.out.print(start+" ");
        for(int i=n; i>=1; i--){
            if(mat[start][i]==1){
                stack.push(i);
            }
        }
        while(!stack.isEmpty()){
            int node = stack.pop();
            if(visited[node] == 0){
                System.out.print(node+" ");
                visited[node] = 1;
            }
            for(int i=n; i>=1; i--){
                if(mat[node][i]==1 && visited[i]==0){
                    stack.push(i);
                }
            }
        }
    }
    static void bfs(int start,int n){
        int[] visited = new int[n+1];
        visited[start] = 1;
        System.out.print(start+" ");
        for(int i=1; i<=n; i++){
            if(mat[start][i]==1){
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()){
            int node = queue.poll();
            if(visited[node]==0){
                System.out.print(node+" ");
                visited[node] = 1;
            }
            for(int i=1; i<=n; i++){
                if(mat[node][i]==1 && visited[i] == 0){
                    queue.offer(i);
                }
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int start = sc.nextInt();
        mat = new int[n+1][n+1];
        for(int i=0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            mat[a][b] = 1;
            mat[b][a] = 1;
        }
        dfs(start,n);
        System.out.println();
        bfs(start,n);
    }
}
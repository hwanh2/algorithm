import java.util.*;
import java.io.*;

class Main {
    static int k;
    static char[] op;
    static String max = "";
    static String min = "9999999999";
    static int[] tmp;
    static boolean[] visited = new boolean[10];
    static void dfs(int depth){
        if(depth==k+1){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<=k; i++){
                sb.append(tmp[i]);
            }

            String result = sb.toString();

            if(result.compareTo(max)>0){
                max = result;
            }
            if(result.compareTo(min)<0){
                min = result;
            }

            return;
        }

        for(int i=0; i<=9; i++){
            if(!visited[i]){
                if(depth==0 || check(tmp[depth-1],i,op[depth-1])){
                    visited[i] = true;
                    tmp[depth] = i;
                    dfs(depth+1);
                    visited[i] = false;
                }
            }
        }
    }

    static boolean check(int a, int b, char op){
        if(op=='<'){
            return a<b;
        }
        else{
            return a>b;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        k = Integer.parseInt(br.readLine());

        op = new char[k];
        tmp = new int[k+1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<k; i++){
            op[i] = st.nextToken().charAt(0);
        }

        dfs(0);

        System.out.println(max+"\n"+min);

        
    }
}
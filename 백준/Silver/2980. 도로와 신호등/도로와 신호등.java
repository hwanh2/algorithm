import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] wait;
    static int solve(int n,int d){
        int time = 0;
        int dis = 0;
        int i = 0;
        while(dis<d){
            if(i == n){
                time += d-dis;
                break;
            }
            time+=wait[i][0] - dis;
            dis = wait[i][0];
            if(time%(wait[i][1]+wait[i][2])<wait[i][1]){
                time+= wait[i][1] - (time%(wait[i][1]+wait[i][2]));
            }
            i++;
        }
        return time;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        wait = new int[n][3];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<3; j++){
                wait[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(solve(n,d));
    }
}

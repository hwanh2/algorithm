import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static int[][] map;
    static ArrayList<int[]> chickenList;
    static ArrayList<int[]> houseList;
    static int result = Integer.MAX_VALUE;
    static boolean[] open;

    static void dfs(int start, int depth){
        if(depth==m){
            calculateDistance();
            return;
        }
        for(int i=start; i<chickenList.size(); i++){
            open[i] = true;
            dfs(i+1,depth+1);
            open[i] = false;
        }
    }

    static void calculateDistance(){
        int total = 0;

        for(int[] house : houseList){
            int r1 = house[0];
            int c1 = house[1];
            int min = Integer.MAX_VALUE;

            for(int i=0; i<chickenList.size(); i++){
                if(open[i]){
                    int r2 = chickenList.get(i)[0];
                    int c2 = chickenList.get(i)[1];

                    int distance = Math.abs(r1-r2) + Math.abs(c1-c2);
                    min = Math.min(min,distance);
                }
            }
            total+=min;
        }

        result = Math.min(result,total);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        houseList = new ArrayList<>();
        chickenList = new ArrayList<>();

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==1){
                    houseList.add(new int[]{i,j});
                }
                else if(map[i][j]==2){
                    chickenList.add(new int[]{i,j});
                }
            }
        }

        open = new boolean[chickenList.size()];

        dfs(0,0);

        System.out.println(result);
    }
}
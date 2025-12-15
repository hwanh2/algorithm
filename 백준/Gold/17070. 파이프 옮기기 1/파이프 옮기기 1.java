import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static int ans;

    public static void DFS(int x, int y, int direction) {
        if (x==N && y==N) {
            ans++;
            return;
        }
        if (direction==0 || direction==2) {
            if (y + 1 <= N && map[x][y + 1] == 0) {
                DFS(x, y + 1, 0);
            }
        }
        if (direction == 1 || direction == 2) {
            if (x + 1 <= N && map[x + 1][y] == 0) {
                DFS(x + 1, y, 1);
            }
        }
        if (x+1 <= N && y+1 <= N) {
            if (map[x][y+1] == 0 && map[x+1][y] == 0 && map[x+1][y+1] == 0) {
                DFS(x + 1, y + 1, 2);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1; j<=N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ans = 0;
        DFS(1, 2, 0);

        System.out.println(sb.append(ans));
    }
}
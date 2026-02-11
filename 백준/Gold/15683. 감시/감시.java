import java.io.*;
import java.util.*;

public class Main {
    static class CCTV {
        int r, c, type;
        public CCTV(int r, int c, int type) {
            this.r = r;
            this.c = c;
            this.type = type;
        }
    }

    static int N, M;
    static int min = Integer.MAX_VALUE;
    static List<CCTV> cctvs = new ArrayList<>();

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static int[][][] cctvDirs = {
            {},
            {{0}, {1}, {2}, {3}},
            {{0, 2}, {1, 3}},
            {{0, 1}, {1, 2}, {2, 3}, {3, 0}},
            {{0, 1, 3}, {0, 1, 2}, {1, 2, 3}, {0, 2, 3}},
            {{0, 1, 2, 3}}
    };
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j]>=1 && map[i][j]<=5) {
                    cctvs.add(new CCTV(i, j, map[i][j]));
                }
            }
        }

        dfs(0, map);

        System.out.println(min);
    }

    static void dfs(int depth, int[][] currentMap) {
        if (depth == cctvs.size()) {
            int count = 0;
            for (int i=0; i<N; i++) {
                for (int j=0; j<M; j++) {
                    if (currentMap[i][j]==0) count++;
                }
            }
            min = Math.min(min, count);
            return;
        }

        CCTV cctv = cctvs.get(depth);
        int type = cctv.type;

        for (int[] dirs : cctvDirs[type]) {
            int[][] nextMap = copyMap(currentMap);
            for (int dir : dirs) {
                fill(cctv.r, cctv.c, dir, nextMap);
            }

            dfs(depth + 1, nextMap);
        }
    }

    static void fill(int r, int c, int dir, int[][] map) {
        int nr = r;
        int nc = c;

        while (true) {
            nr += dr[dir];
            nc += dc[dir];

            if (nr<0 || nc<0 || nr>=N || nc>=M || map[nr][nc]==6) {
                break;
            }
            if (map[nr][nc]==0) {
                map[nr][nc]=-1;
            }
        }
    }

    static int[][] copyMap(int[][] map) {
        int[][] copy = new int[N][M];
        for (int i=0; i<N; i++) {
            for(int j=0; j<M; j++){
                copy[i][j] = map[i][j];
            }
        }
        return copy;
    }
}
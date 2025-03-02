import java.io.*;
import java.util.*;

public class Main {
    static int[][] mat;
    static boolean[][][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int result = -1;
    static Queue<Node> queue = new LinkedList<>();

    static void bfs(int n, int m, int t) {
        queue.offer(new Node(0, 0, 0, false));
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Node tmp = queue.poll();
            int cnt = tmp.cnt;
            boolean sword = tmp.sword;
            int tmpX = tmp.x;
            int tmpY = tmp.y;

            if (tmpX == m - 1 && tmpY == n - 1) { // 목적지 도착
                result = cnt;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int x = tmpX + dx[i];
                int y = tmpY + dy[i];

                if (x >= 0 && x < m && y >= 0 && y < n) {
                    if (sword) {
                        if (!visited[y][x][1]) {
                            queue.offer(new Node(x, y, cnt + 1, true));
                            visited[y][x][1] = true;
                        }
                    } else {
                        if (!visited[y][x][0]) {
                            if (mat[y][x] == 0) {
                                queue.offer(new Node(x, y, cnt + 1, false));
                                visited[y][x][0] = true;
                            } else if (mat[y][x] == 2) {
                                queue.offer(new Node(x, y, cnt + 1, true));
                                visited[y][x][0] = true;
                                visited[y][x][1] = true;
                            }
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        mat = new int[n][m];
        visited = new boolean[n][m][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                mat[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(n, m, t);

        if (result != -1 && result <= t) {
            System.out.println(result);
        } else {
            System.out.println("Fail");
        }
    }
}

class Node {
    int x;
    int y;
    int cnt;
    boolean sword;

    public Node(int x, int y, int cnt, boolean sword) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
        this.sword = sword;
    }
}

import java.io.*;
import java.util.*;

public class Main {
    static int[][] array;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        array = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<m; j++){
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int surfaceArea = 0;
        int[] dx = {-1, 1, 0, 0}; // 상하좌우
        int[] dy = {0, 0, -1, 1};

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(array[i][j] > 0) {
                    surfaceArea += 2; // 윗면 + 바닥면
                }

                for(int d=0; d<4; d++){
                    int ni = i + dx[d];
                    int nj = j + dy[d];

                    int neighbor = 0;
                    if(ni >= 0 && ni < n && nj >= 0 && nj < m){
                        neighbor = array[ni][nj];
                    }

                    int side = array[i][j] - neighbor;
                    if(side > 0){
                        surfaceArea += side;
                    }
                }
            }
        }

        System.out.println(surfaceArea);
    }
}

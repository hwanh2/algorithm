import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static int[][] map;
    static int[][] groupMap;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int groupBfs(int r,int c,int groupId){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {r,c});
        groupMap[r][c] = groupId;
        int count = 1;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int cx = cur[1];
            int cy = cur[0];
            for(int i=0; i<4; i++){
                int nx = cx+dx[i];
                int ny = cy+dy[i];
                if(nx>=0 && ny>=0 && nx<m && ny<n && groupMap[ny][nx]==0 && map[ny][nx]==0){
                    groupMap[ny][nx] = groupId;
                    queue.add(new int[] {ny,nx});
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        groupMap = new int[n][m];

        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<m; j++){
                map[i][j] = str.charAt(j)-'0';
            }
        }

        int groupId = 1;
        Map<Integer,Integer> groupCount = new HashMap<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j]==0 && groupMap[i][j]==0){
                    groupCount.put(groupId,groupBfs(i,j,groupId));
                    groupId++;
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j]==0){
                    sb.append(0);
                }
                else{
                    int count = 1;
                    Set<Integer> set = new HashSet<>();
                    for(int l=0; l<4; l++){
                        int nx = j+dx[l];
                        int ny = i+dy[l];
                        if(nx>=0 && ny>=0 && nx<m && ny<n && map[ny][nx]==0){
                            set.add(groupMap[ny][nx]);
                        }
                    }
                    for(int id : set){
                        count+=groupCount.get(id);
                    }
                    sb.append(count%10);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
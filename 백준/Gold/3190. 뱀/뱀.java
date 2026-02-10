import java.io.*;
import java.util.*;

public class Main {
    static class Snake{
        public int x;
        public int y;

        public Snake(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int k = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];

        for(int i=0; i<k; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            map[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 1;
        }

        Map<Integer,String> dirtInfo = new HashMap<>();

        int l = Integer.parseInt(br.readLine());
        for(int i=0; i<l; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            dirtInfo.put(Integer.parseInt(st.nextToken()),st.nextToken());
        }

        List<Snake> list = new ArrayList<>();

        list.add(new Snake(0,0));
        int count = 0;
        int startIndex = 0;
        int dirt = 0;

        while(true){
            count++;
            Snake s = list.get(list.size()-1);
            int cx = s.x;
            int cy = s.y;
            if(dirt==0){
                cx++;
            }
            else if(dirt==1){
                cy++;
            }
            else if(dirt==3){
                cy--;
            }
            else{
                cx--;
            }
            if(cx<0 || cy<0 || cx>=n || cy>=n){
                break;
            }

            boolean flag = false;
            for(int i=startIndex; i<list.size(); i++){
                Snake tmp = list.get(i);
                if(tmp!=null){
                    if(cx==tmp.x && cy==tmp.y){
                        flag = true;
                        break;
                    }
                }
            }
            if(flag){
                break;
            }
            list.add(new Snake(cx,cy));
            if(dirtInfo.containsKey(count)){
                if(dirt==0 && dirtInfo.get(count).equals("L")){
                    dirt = 3;
                }
                else if(dirtInfo.get(count).equals("L")){
                    dirt--;
                }
                else{
                    dirt++;
                    dirt%=4;
                }
            }
            if(map[cy][cx]==1){
                map[cy][cx] = 0;
            }
            else{
                list.set(startIndex,null);
                startIndex++;
            }

        }

        System.out.println(count);
    }
}
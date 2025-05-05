import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] array = new int[n][n];
        Point sk = null;
        Point pro = null;
        ArrayList<Point> arrayList = new ArrayList<>();
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<n; j++){
                array[i][j] = Integer.parseInt(st.nextToken());
                if(array[i][j]==1){
                    arrayList.add(new Point(j,i));
                }
                else if(array[i][j]==2){
                    sk = new Point(j,i);
                }
                else if(array[i][j]==5){
                    pro = new Point(j,i);
                }
            }
        }
        int dis = (int)Math.sqrt(Math.pow(sk.x- pro.x,2)+Math.pow(sk.y- pro.y,2));
        int count = 0;
        int maxX;
        int minX;
        if(sk.x> pro.x){
            maxX = sk.x;
            minX = pro.x;
        }
        else{
            maxX = pro.x;
            minX = sk.x;
        }
        int maxY;
        int minY;
        if(sk.y> pro.y){
            maxY = sk.y;
            minY = pro.y;
        }
        else{
            maxY = pro.y;
            minY = sk.y;
        }
        for(Point p : arrayList){
            if(minX<=p.x && maxX>=p.x && minY<=p.y && maxY>=p.y){
                count++;
            }
        }
        if(dis>=5 && count>=3){
            System.out.println(1);
        }
        else{
            System.out.println(0);
        }
    }
}
class Point{
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
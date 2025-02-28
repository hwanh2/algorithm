import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Point> array = new ArrayList<>();
    static void solve(){
        int count = 1;
        int time = array.get(0).y;
        for(int i=1; i<array.size(); i++){
            if(time<=array.get(i).x){
                count++;
                time = array.get(i).y;
            }
        }
        System.out.println(count);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            array.add(new Point(x,y));
        }
        Collections.sort(array);
        solve();
    }
}

class Point implements Comparable<Point>{
    public int x;
    public int y;
    Point(int x,int y){
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(Point o) {
        if(this.y == o.y){
            return this.x - o.x;
        }
        else{
            return this.y - o.y;
        }
    }
}

import java.util.*;

class Point implements Comparable<Point>{
    public int x,y;
    Point(int x,int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        if(this.x == o.x){
            return this.y - o.y;
        }
        else{
            return this.x - o.x;
        }
    }
}

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Point> array = new ArrayList<>();
        for(int i=0; i<n; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            array.add(new Point(x,y));
        }
        Collections.sort(array);
        for(Point o : array){
            System.out.println(o.x+" "+o.y);
        }
    }
}

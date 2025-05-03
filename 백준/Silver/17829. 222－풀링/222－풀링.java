import java.io.*;
import java.util.*;

public class Main {
    static int[][] array;
    static int partition(int r,int c,int size){
        if(size==2){
            int index = 0;
            int[] tmp = new int[4];
            for(int i=r; i<r+size; i++){
                for(int j=c; j<c+size; j++){
                    tmp[index++] = array[i][j];
                }
            }
            Arrays.sort(tmp);
            return tmp[2];
        }
        size/=2;
        int[] tmp = new int[4];

        tmp[0]=partition(r,c,size);
        tmp[1]=partition(r,c+size,size);
        tmp[2]=partition(r+size,c,size);
        tmp[3]=partition(r+size,c+size,size);

        Arrays.sort(tmp);
        return tmp[2];

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        array = new int[n][n];

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<n; j++){
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(partition(0,0,n));
    }
}
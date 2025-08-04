import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<3; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);

        for(int i=0; i<3; i++){
            System.out.print(array[i]+" ");
        }
    }
}
import java.util.Scanner;

public class Main {

    public static int minSingle(int[][] array){
        int min = array[0][1];
        for(int i=1; i<array.length; i++){
            if(array[i][1]<min){
                min = array[i][1];
            }
        }
        return min;
    }

    public static int minPackage(int[][] array){
        int min = array[0][0];
        for(int i=1; i<array.length; i++){
            if(array[i][0]<min){
                min = array[i][0];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int price = 0;
        int[][] array = new int[t][2];

        for(int i=0; i<t; i++){
            for(int j=0; j<array[i].length; j++){
                array[i][j] = sc.nextInt();
            }
        }

        int minSingle = minSingle(array);
        int minPackage = minPackage(array);

        price += (n/6)*minPackage;
        int num = n%6;

        if(minPackage<num*minSingle){
            price+=minPackage;
        }
        else{
            price+=num*minSingle;
        }

        if(price>n*minSingle){
            price = n*minSingle;
        }

        System.out.println(price);
    }
}

import java.util.Scanner;

public class Main {
    private static int[] sorted = new int[100000];
    public static void merge(int[] array,int left,int mid, int right){
        int i=left, j=mid+1, k=left;
        while(i<=mid&&j<=right){
            if(array[i]<array[j]){
                sorted[k++] = array[i++];
            }
            else{
                sorted[k++] = array[j++];
            }
        }
        if(i>mid){
            for(int l=j; l<=right; l++){
                sorted[k++] = array[l];
            }
        }
        else{
            for(int l=i; l<=mid; l++){
                sorted[k++] = array[l];
            }
        }
        for(int l=left; l<=right; l++){
            array[l] = sorted[l];
        }
    }

    public static void merge_sort(int[] array,int left,int right){
        int mid;
        if(left<right){
            mid = (left+right)/2;
            merge_sort(array,left,mid);
            merge_sort(array,mid+1,right);
            merge(array,left,mid,right);
        }
    }

    public static int binary_search(int[] array,int key,int low,int high){
        int middle;

        while(low<=high){
            middle = (low+high)/2;
            if(key == array[middle]){
                return middle;
            }
            else if(key>array[middle]){
                low = middle+1;
            }
            else{
                high = middle-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       int[] nArray = new int[n];

       for(int i=0; i<nArray.length; i++){
           nArray[i] = sc.nextInt();
       }

       int m = sc.nextInt();
       int[] mArray = new int[m];

       for(int i=0; i<mArray.length; i++){
           mArray[i] = sc.nextInt();
       }

       merge_sort(nArray,0,nArray.length-1);

       for(int i=0; i<mArray.length; i++){
           if(binary_search(nArray,mArray[i],0,nArray.length-1)==-1){
               System.out.println(0);
           }
           else{
               System.out.println(1);
           }
       }


    }
}

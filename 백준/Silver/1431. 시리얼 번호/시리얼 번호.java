import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        ArrayList<String> array = new ArrayList<>();
        for(int i=0; i<n; i++){
            array.add(br.readLine());
        }

        Collections.sort(array, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() != o2.length()){
                    return o1.length() - o2.length();
                }
                else{
                    int num1 = 0;
                    for(int i=0; i<o1.length(); i++){
                        if(o1.charAt(i)>='1' && o1.charAt(i)<='9'){
                            num1+=o1.charAt(i)-'0';
                        }
                    }
                    int num2 = 0;
                    for(int i=0; i<o2.length(); i++){
                        if(o2.charAt(i)>='1' && o2.charAt(i)<='9'){
                            num2+=o2.charAt(i)-'0';
                        }
                    }
                    if(num1!=num2){
                        return num1-num2;
                    }
                    else{
                        return o1.compareTo(o2);
                    }
                }
            }
        });
        for(int i=0; i<n; i++){
            bw.write(array.get(i)+"\n");
        }
        bw.flush();

    }
}
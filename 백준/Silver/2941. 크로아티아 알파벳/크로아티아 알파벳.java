import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] croatia = {"c=","c-","dz=","d-","lj","nj","s=","z="};
		String alpa = sc.next();
		int count = 0;
		
		for(int i=0; i<croatia.length; i++) {
			String temp = croatia[i];
			while(alpa.contains(temp)) {
				alpa = alpa.replaceFirst(temp, " ");
				count++;
			}
		}
		alpa = alpa.replace(" ", "");
		System.out.println(count+alpa.length());

	}

}
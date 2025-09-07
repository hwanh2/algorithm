import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		// 막대기 개수 N 입력
		int N = Integer.parseInt(bf.readLine());
		Stack <Integer> stack = new Stack <Integer>();
		
		int max = 0; // 가장 높은 블럭 높이
		
		// 각 막대기 높이 h 입력
		for (int i=0; i<N; i++) {
			stack.push(Integer.parseInt(bf.readLine()));
			if(max<stack.peek()) max=stack.peek();
		}
		
		int s = 0; // 보이는 블럭 높이
		int result = 0; // 결과값

		for (int i=0; i<N; i++) {
			int p = stack.pop();
			if(s<p) { // 보이는 블럭 높이보다 블럭이 크면 결과값++, 보이는 블럭 높이 변경
				s=p;
				result++;
			}
			if (p == max) break; // 최대 블럭 높이 만나면 break
		}
		
		// 결과 출력
		System.out.println(result);
	}

}
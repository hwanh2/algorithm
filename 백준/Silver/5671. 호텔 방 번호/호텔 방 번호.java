import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int result = 0;

            for (int i = a; i <= b; i++) {
                if (isUnique(i)) {
                    result++;
                }
            }

            System.out.println(result);
        }
    }

    // 숫자가 고유한 자릿수를 가지는지 확인하는 함수
    private static boolean isUnique(int num) {
        int usedDigits = 0; // 비트마스크로 사용된 자릿수 저장
        while (num > 0) {
            int digit = num % 10;
            if ((usedDigits & (1 << digit)) != 0) {
                return false; // 이미 사용된 숫자
            }
            usedDigits |= (1 << digit); // 자릿수 사용 기록
            num /= 10;
        }
        return true; // 중복 없음
    }
}
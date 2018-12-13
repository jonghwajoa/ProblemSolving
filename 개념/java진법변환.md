## 자바 진법 변환..

js로 풀면

```js
function solution(n, b) {
  console.log(n.toString(b).toUpperCase());
}

solution(60466175, 36);
```

이처럼 엄청 간단하게 풀수 있다...
하지만 자바는 이를 지원하지 않는다..(아직 자바에 익숙치 않아서 모르는것 일수도있지만..)

아래처럼 푸는것에 적응하자

```java
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int b = sc.nextInt();

		StringBuilder sb = new StringBuilder();
		while (n > 0) {
			int r = n % b;
			if(r >= 10) {
				sb.append((char)(r + 'A' - 10));

			}else {
				sb.append((char)((char)r+'0'));
			}
			n /= b;
		}
		System.out.println(sb.reverse());

	}

}
```

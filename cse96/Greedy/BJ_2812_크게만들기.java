package study.August.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_2812_ũ�Ը���� {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		int N = Integer.valueOf(str[0]);//N�ڸ���
		int K = Integer.valueOf(str[1]);//���� ��
		
		String num = br.readLine();
		//�Է� ��
		int cnt = 0;
		
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i = 0; i < N; i++) {
			//���� ��
			int now = num.charAt(i) - '0';
			//�� ���� �� �ְ� stack�� top���� ���� ���ڰ� �� ũ�ٸ� ����
			while(cnt < K && !stack.isEmpty() && stack.peek() < now) {
				stack.pop();
				cnt++;
			}
			stack.add(now);
		}
		int size = stack.size();
		if(size > N - K) {
			for(int i = 0; i < size - (N - K); i++) {
				stack.pop();
			}
		}
//		System.out.println(stack.toString());
		size = stack.size();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < size; i++) {
			sb.append(stack.pop());
		}
		System.out.println(sb.reverse().toString());
		
	}

}

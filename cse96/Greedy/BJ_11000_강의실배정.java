package study.August.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BJ_11000_���ǽǹ��� {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());
		int[][] arr = new int[N][2];
		for(int i = 0; i < N; i++) {
			String str[] = br.readLine().split(" ");
			arr[i][0] = Integer.valueOf(str[0]);
			arr[i][1] = Integer.valueOf(str[1]);
		}
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) return o1[1] - o2[1];
				return o1[0] - o2[0];
			}
		});
		
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		//���� �� ù ���� ����ð� �켱���� ť�� �־���
		pq.offer(arr[0][1]);
		
		for(int i = 1; i < N; i++) {
			//���� Ž���ϴ� ������ ����ð�
			int end = arr[i][1];
			//��������ʰ� ���� ����ð����� ���۽ð��� ũ�ų� ������
			if(!pq.isEmpty() && pq.peek() <=  arr[i][0]) {
				pq.poll();//�ش� ����ð��� ����, �� ���ǰ� �̷��� ���ǽǿ��� ���� ���ǰ� �̷���
			}
			//���� ������ ����ð��� �־���
			pq.offer(end);
		}
		System.out.println(pq.size());

	}
}


package study.August.Hash;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class BJ_15686_ġŲ��� {

	static int M, store_cnt, minDist = Integer.MAX_VALUE;
	static ArrayList<Point> house;
	static ArrayList<Point> store;
	static Stack<Point> selectStore;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		//N 2~50 M 1~13
		int N = Integer.valueOf(str[0]); //map�� ũ��
		M = Integer.valueOf(str[1]); // M ġŲ�� �ִ� ��
		house = new ArrayList<Point>();
		store = new ArrayList<Point>();
		selectStore = new Stack<Point>();
		for(int i = 0; i < N; i++) {
			str = br.readLine().split(" ");
			for(int j = 0; j < N; j++) {
				int cur = Integer.valueOf(str[j]);
				if(cur == 1) {
					//��
					Point now = new Point(i+1,j+1);
					house.add(now);
				}
				else if(cur == 2) {
					//ġŲ ��
					Point now = new Point(i+1,j+1);
					store.add(now);
				}
			}		
		}//for-i
		store_cnt = store.size();
		select(0,0);
		
		System.out.println(minDist);
	}

	private static void select(int start, int count) {
		if(count == M) {
			calcDist();
			return;
		}
		
		for(int i = start; i < store_cnt; i++) {
			//stack�� Ȱ���ؼ� ������ �ϸ� visitó���� �ʿ����.
			selectStore.push(store.get(i));
			select(i+1,count+1);
			selectStore.pop();
		}
	}

	private static void calcDist() {
		int sum = 0;
		for(Point home : house) {
			int min = Integer.MAX_VALUE;
			for(Point store : selectStore) {
				int dist = Math.abs(home.x - store.x) + Math.abs(home.y - store.y);
				min = Math.min(min, dist);
			}
			sum += min;
			
			if(sum > minDist) return;//��Ʈ��ŷ
			
		}
		//��Ʈ��ŷ�� �Ȱɸ��� sum�� �ּҰ�
		minDist = sum;
	}

}

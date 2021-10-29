package study.August.Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BJ_10816_����ī��2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());//������� ����ī�� N
		String cards[] = br.readLine().split(" ");
		int M = Integer.valueOf(br.readLine());//� ������ �ִ� ����ī������ ���ؾ��� M���� ����
		String nums[] = br.readLine().split(" ");
		HashMap<Integer,Integer> hashMap = new HashMap<Integer,Integer>();
		for(String card : cards) {
			int card_num = Integer.valueOf(card);
			hashMap.put(card_num,hashMap.getOrDefault(card_num, 0) + 1);
		}
		StringBuilder sb = new StringBuilder();
		for(String num : nums) {
			int i = Integer.valueOf(num);
			sb.append(hashMap.getOrDefault(i,0)).append(" ");
		}
		System.out.println(sb.toString());
		
	}

}

package com.april2nd.swe;
import java.util.Scanner;

public class SWE_7465_창용마을무리의개수 {
	static int N, M;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int answer = 0;
			N = sc.nextInt();
			M = sc.nextInt();
			arr = new int[N + 1];
			
			for (int i = 1; i <= N; i++) arr[i] = i;
			
			for (int i = 0; i < M; i++) union(sc.nextInt(), sc.nextInt());

			for (int i = 1; i <= N; i++) {
				if (i != arr[i]) continue;
				
				answer++;
			}

			System.out.println("#" + t + " " + answer);
		}
		sc.close();
	}

	static void union(int x, int y) {
		int px = find(x);
		int py = find(y);
		arr[py] = px;
	}

	static int find(int x) {
		if (x == arr[x])
			return x;
		return arr[x] = find(arr[x]);
	}
}
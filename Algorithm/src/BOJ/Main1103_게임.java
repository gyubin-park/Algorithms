package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class Main1103_∞‘¿” {
	public static int N;
	public static int M;
	public static int map[][];
	public static int dist[][];
	public static boolean visit[][];
	public static int di[] = { -1, 1, 0, 0 };
	public static int dj[] = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		char temp[][] = new char[N][M];
		visit = new boolean[N][M];
		dist = new int[N][M];
		
		for (int i = 0; i < N; ++i) {
			temp[i] = sc.next().toCharArray();
			for(int j=0;j<M;++j) {
				map[i][j]=((temp[i][j]=='H'?999:temp[i][j]-'0'));
				dist[i][j]=-1;
			}
		}
		
		System.out.println(dfs(0, 0));
	}

	public static boolean check(int i, int j) {
		if (i < 0 || i >= N || j < 0 || j >= M)
			return true;
		return false;
	}

	public static int dfs(int i, int j) {
		if (check(i, j) || map[i][j]==999)
			return 0;
		if(visit[i][j]) {
			System.out.println(-1);
			System.exit(0);
		}
		if(dist[i][j]!=-1) return dist[i][j];
		
		visit[i][j]=true;
		int cur = map[i][j];
		for(int d=0;d<4;++d) {
			dist[i][j]=Math.max(dist[i][j], dfs(i+di[d]*cur,j+dj[d]*cur)+1);
		}
		visit[i][j]=false;
		
		return dist[i][j];
	}
}

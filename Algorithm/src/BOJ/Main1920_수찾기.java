package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class Main1920_¼öÃ£±â {
	public static int arr[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		arr = new int[N];
		for (int i = 0; i < N; ++i)
			arr[i] = sc.nextInt();
		
		Arrays.sort(arr);
		
		int M = sc.nextInt();
		int number[] = new int[M];
		for (int i = 0; i < M; ++i) {
			number[i] = sc.nextInt();
			if (binarySearch(0,N-1,number[i])) {
				System.out.println(1);
			} else
				System.out.println(0);
		}
	}
	public static boolean binarySearch(int left,int right,int find) {
		
		while(left<=right) {
			int mid=(left+right)/2;
			
			if(find==arr[mid]) {
				return true;
			}else if(find<arr[mid]) {
				right=mid-1;
			}else {
				left=mid+1;
			}
		}
		
		return false;
	}
}

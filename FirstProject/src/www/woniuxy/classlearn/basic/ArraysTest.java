package www.woniuxy.classlearn.basic;

import java.util.Arrays;

public class ArraysTest {
	public static void main(String[]args) {
		int[] arr1 = new int[4];
		System.out.println(Arrays.toString(arr1));//以字符串的形式输出
		Arrays.fill(arr1, 2);//把arr1的每个元素都填充2
		System.out.println(Arrays.toString(arr1));
		for(int i = 0;i<arr1.length;i++) {
			arr1[i]=2;
		}
		System.out.println(Arrays.toString(arr1));
		Arrays.fill(arr1, 0, 4, 3);//把arr1的第0个到第三个元素填充为3
		System.out.println(Arrays.toString(arr1));
		for(int i = 0 ;i<4;i++) {
			arr1[i]=3;
		}
		System.out.println(Arrays.toString(arr1));
		Arrays.fill(arr1, 2,4 , 4);//把arr1的第2个到第3个元素都填充为4
		System.out.println(Arrays.toString(arr1));
		for(int i = 2 ;i<4;i++) {
			arr1[i]=3;
		}
		System.out.println(Arrays.toString(arr1));
		int[] arr2 = {1,5,8,1,6,1,6,7,8};
		Arrays.sort(arr2);//把arr2按从小到大的顺序排序
		System.out.println(Arrays.toString(arr2));
		for(int i = arr2.length -1 ;i>=0;i--) {
			System.out.println(arr2[i]);
		}
		int[] arr3 = {4,5,6,1,5,15456,52};//把arr3复制给arr4
		//int[] arr4 = new int[arr3.length];
		int [] arr4 = Arrays.copyOf(arr3, arr3.length);
		System.out.println(Arrays.toString(arr4));
		int []arr5 = new int [arr3.length];
		for(int i = 0;i<arr3.length;i++) {
			arr5[i]=arr3[i];
		}
		System.out.println(Arrays.toString(arr5));
		//数组的动态扩展
		//对arr3进行动态扩展，重新开辟一块空间，再进行赋值，
		//再把arr6这个数组的引用赋值给arr3
		int[] arr6 = new int[arr3.length + 1];
		for(int i = 0;i<arr3.length;i++) {
			arr6[i]=arr3[i];
		}
		
		System.out.println(Arrays.toString(arr6));
		arr3 = arr6;//把arr6这个数组的引用赋值给arr3,即把地址给了arr3
		System.out.println(Arrays.toString(arr3));
	}
}

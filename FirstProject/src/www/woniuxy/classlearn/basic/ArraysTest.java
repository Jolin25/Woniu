package www.woniuxy.classlearn.basic;

import java.util.Arrays;

public class ArraysTest {
	public static void main(String[]args) {
		int[] arr1 = new int[4];
		System.out.println(Arrays.toString(arr1));//���ַ�������ʽ���
		Arrays.fill(arr1, 2);//��arr1��ÿ��Ԫ�ض����2
		System.out.println(Arrays.toString(arr1));
		for(int i = 0;i<arr1.length;i++) {
			arr1[i]=2;
		}
		System.out.println(Arrays.toString(arr1));
		Arrays.fill(arr1, 0, 4, 3);//��arr1�ĵ�0����������Ԫ�����Ϊ3
		System.out.println(Arrays.toString(arr1));
		for(int i = 0 ;i<4;i++) {
			arr1[i]=3;
		}
		System.out.println(Arrays.toString(arr1));
		Arrays.fill(arr1, 2,4 , 4);//��arr1�ĵ�2������3��Ԫ�ض����Ϊ4
		System.out.println(Arrays.toString(arr1));
		for(int i = 2 ;i<4;i++) {
			arr1[i]=3;
		}
		System.out.println(Arrays.toString(arr1));
		int[] arr2 = {1,5,8,1,6,1,6,7,8};
		Arrays.sort(arr2);//��arr2����С�����˳������
		System.out.println(Arrays.toString(arr2));
		for(int i = arr2.length -1 ;i>=0;i--) {
			System.out.println(arr2[i]);
		}
		int[] arr3 = {4,5,6,1,5,15456,52};//��arr3���Ƹ�arr4
		//int[] arr4 = new int[arr3.length];
		int [] arr4 = Arrays.copyOf(arr3, arr3.length);
		System.out.println(Arrays.toString(arr4));
		int []arr5 = new int [arr3.length];
		for(int i = 0;i<arr3.length;i++) {
			arr5[i]=arr3[i];
		}
		System.out.println(Arrays.toString(arr5));
		//����Ķ�̬��չ
		//��arr3���ж�̬��չ�����¿���һ��ռ䣬�ٽ��и�ֵ��
		//�ٰ�arr6�����������ø�ֵ��arr3
		int[] arr6 = new int[arr3.length + 1];
		for(int i = 0;i<arr3.length;i++) {
			arr6[i]=arr3[i];
		}
		
		System.out.println(Arrays.toString(arr6));
		arr3 = arr6;//��arr6�����������ø�ֵ��arr3,���ѵ�ַ����arr3
		System.out.println(Arrays.toString(arr3));
	}
}

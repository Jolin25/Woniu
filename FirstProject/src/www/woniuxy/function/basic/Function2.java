package www.woniuxy.function.basic;

public class Function2 {
//	public static void main(String[]args) {
		
	
	public void add(int... args) {
		int sum = 0;
		for(int i = 0;i<args.length;i++) {
			sum += args[i];
		}
		System.out.print(sum);
	}
}
//}

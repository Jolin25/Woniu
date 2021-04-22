package collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Basic {
	public void tryTry() {
		Set<String> set = new HashSet<String>();
		set.add("b");
		set.add("d");
		set.add("A");
		set.add("rrtt");
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
	}
	public static void main(String[] args) {
		Basic b = new Basic();
		b.tryTry();
	}
	
}

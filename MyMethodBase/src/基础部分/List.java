package 基础部分;

/**
 * 线程部分基本操作
 * 
 * @author 小虫子的小日常
 *
 */
public class List {
	/*
	 * 定义一个方法add，用于添加Person对象到数组中，不能保存重复的对象
	 */
	public void add(Object[] o, Person newP) {
		if (newP == null)
			return;// 如果要添加的数据为空，则退出
		if (!(newP instanceof Person))
			return;// 如果不是要添加的数组的类型的对象，则退出
		boolean hasSame = false;// 默认不重复
		for (int i = 0; i < o.length; i++) {
			// if里的判断条件也可以这么写：newP.equals(p[i]) 这样就可以避免p[i]为空指针的情况
			// 这里的newP是调用add方法的对象
			if (o[i] != null && o[i].equals(newP)) {
				System.out.println("与已有对象重复");
				hasSame = true;
				break;
			}
		}
		// 如果不重复，则添加
		if (!hasSame) {
			boolean isFull = false;// 默认不满
			for (int i = 0; i < o.length; i++) {
				// 如果数组不满，则直接添加
				if (o[i] == null) {
					o[i] = newP;
					break;
				}

				if (i == o.length - 1) {
					isFull = true;
				}
			}
			// 如果数组满了，则动态扩容
			Person[] p1 = new Person[o.length + 1];
			p1[o.length] = newP;
			for (int j = 0; j < o.length; j++) {
				p1[j] = (Person) o[j];
			}
			o = p1;
		}
	}

	/*
	 * 定义一个方法contains(Person p).判断数组中是否包含了该对象(属性相等也算包含)
	 */
	public boolean contains(Person[] p, Person pp) {
		if (pp == null)
			return false;// 如果要添加的数据为空，则退出
		if (!(pp instanceof Person))
			return false;// 如果不是要对比的数组的类型的对象，则退出
		// boolean isContains = false;// 默认不包含
		for (int i = 0; i < p.length; i++) {
			if (pp.equals(p[i])) {
				// System.out.println("包含了" + pp.toString() + "对象");
				// isContains = true;
				return true;

			}
		}
		return false;
//		if (!isContains) {
//			System.out.println("不包含" + pp.toString() + "对象");
//		}
	}

	/*
	 * 定义一个方法indexOf(Person p).返回数组中该对象(或者属性相等)的下标。
	 */
	public int indexOf(Person[] p, Person pp) {
		if (pp == null)
			return -1;
		if (!(pp instanceof Person))
			return -1;
		for (int i = 0; i < p.length; i++) {
			if (p[i].equals(pp)) {

				return i;
			}
		}
		return -1;
	}

	/*
	 * 定义一个方法get (int index).返回下标为index的对象
	 */
	public Person get(Person[] p, int index) {

		if (index < 0 || index > p.length - 1) {
			System.out.println("输入错误");
			return null;
		} else {
			return p[index];
		}

	}

	/*
	 * 定义一个方法clear().用于清理掉数组中所有数据
	 */
	public void clear(Person[] p) {
		for (int i = 0; i < p.length; i++) {
			p[i] = null;
		}
	}
}

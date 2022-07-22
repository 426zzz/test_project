package org.lyz.test_project.test;

class Father{
//	public Father() {
//		System.out.println("父类无参构造");
//	}
	public Father(String a) {
		System.out.println("父类有参构造");
	}
}
public class ConstructorTest extends Father{
	public ConstructorTest() {
		super("aaa");
		System.out.println("子类无参构造");
	}
	public ConstructorTest(String a) {
		super("aaa");
		System.out.println("子类有参构造");
	}
	
	public static void main(String args[]){
		// 调用无参构造
		ConstructorTest test1 = new ConstructorTest();
		// 调用有参构造
		ConstructorTest test2 = new ConstructorTest("aaa");
		
	}
	
}

package org.lyz.test_project.test;

/*class A implements Cloneable{
	private String a1;
	private int a2;
	
	public String getA1() {
		return a1;
	}
	public void setA1(String a1) {
		this.a1 = a1;
	}
	public int getA2() {
		return a2;
	}
	public void setA2(int a2) {
		this.a2 = a2;
	}
	@Override
	public String toString() {
		return "A [a1=" + a1 + ", a2=" + a2 + "]";
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return (A)super.clone();
	}
}*/
class Student implements Cloneable{
	private String name;
	private int age;
	private Teacher teacher;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

//	@Override
//	public String toString() {
//		return "Student [name=" + name + ", age=" + age + ", teacher=" + teacher + "]";
//	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		Student stu = (Student)super.clone();
		stu.teacher = (Teacher)teacher.clone();
		return stu;
	}
}

class Teacher implements Cloneable { //implements Cloneable
	private String name;
	private int age;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

//	@Override
//	public String toString() {
//		return "Teacher [name=" + name + ", age=" + age + "]";
//	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
public class CloneTest {
	public static void main(String[] args) throws CloneNotSupportedException {		 
		Student stu = new Student();
		Teacher tea = new Teacher();
		stu.setAge(18);
		stu.setName("zs");
		tea.setAge(45);
		tea.setName("ml");
		stu.setTeacher(tea);

		// shallow clone : 克隆对象中的引用类型指向原对象引用类型的地址，地址相同
		System.out.println("--- shallow clone ---");
		Student stu2 = (Student) stu.clone();
		System.out.println("原对象地址：" + stu);
		System.out.println("原对象中引用类型属性地址" + stu.getTeacher());
		System.out.println("克隆对象地址：" + stu2);
		System.out.println("原对象中引用类型属性地址：" + tea);
		System.out.println("克隆对象中引用类型属性地址：" + stu2.getTeacher());


		// deep clone : 克隆对象中的引用类型也需要实现克隆接口，并在需要克隆的对象重写的clone()中调用其引用类型的clone()，生成的克隆对象的引用类型会指向新地址
		System.out.println("--- deep clone ---");
		Student stu3 = (Student) stu.clone();
		System.out.println("原对象地址：" + stu);
		System.out.println("原对象中引用类型属性地址" + stu.getTeacher());
		System.out.println("克隆对象地址：" + stu2);
		System.out.println("原对象中引用类型属性地址：" + tea);
		System.out.println("克隆对象中引用类型属性地址：" + stu2.getTeacher());
	}
}

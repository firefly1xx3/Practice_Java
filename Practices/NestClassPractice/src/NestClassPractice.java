public class NestClassPractice {
    public static void main(String[] args) {
        // 学校の設立
        School school = new School("Java学園");
        // 生徒が続々と入学
        school.enterSchool("春日");
        school.enterSchool("若林");
        school.enterSchool("遠藤");
        school.enterSchool("田中");
        school.enterSchool("渡辺");
        // 定員オーバー
        school.enterSchool("山下");
        System.out.println();
        // 在校生の紹介
        school.introduce();
    }
}
// ここに学校クラスを作成してください
class School {
	// private attribute
	private int CAPACITY = 5;
	private String name;
	private Student[] students;
	// private nest class 
	private class Student {
		// private attribute
		private String name;
		private int id;
		// constructor
		public Student (String name, int id) {
			this.name = name;
			this.id   = id;
		}
		// method 
		@Override
		public String toString () {
			/*
			 * There are two types of 'this'. If you distinguish between 
			 * such 'this', put on Class Name at first of variable. 
			 * ex) 'School.'this.name; 
			 */
			return String.format("%sに在学している出席番号%dの%sです。", School.this.name, id, name);
		}
	}
	// constructor
	public School (String name) {
		this.name = name;
		students = new Student [CAPACITY];
	}
	// method
	public void enterSchool (String studentName) {
		int id = 0;
		// check how many students in school.
		while ( id < CAPACITY && students[id] != null) {
			 id++;
		}
		if(id == CAPACITY) {
			System.out.printf("定員オーバーで%sさんは%sに入学できません。%n", studentName, name);
		} else {
			// when define instance, dont forget put on 'new'. 
			var s = new Student(studentName, id+1);
			students[id] = s;
			System.out.printf("%sさんが%sに入学しました。%n", students[id].name, this.name);
		}
	}
	public void introduce() {
		int id = 0;
		while (id < CAPACITY && students[id] != null) {
			System.out.println(students[id].toString());
			id++;
		}
	}
	

}
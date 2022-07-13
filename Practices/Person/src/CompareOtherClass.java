public class CompareOtherClass {
    public static void main(String[] args) {
        // Personクラスのオブジェクトを作成
        Person[] persons = { new Person(), new Person(), new Person() };
        // Personオブジェクトに氏名と年齢をセット
        persons[0].setData("大島", 30);
        persons[1].setData("村上", 30);
        persons[2].setData("黒沢", 32);
        // 自己紹介
        for(int i = 0; i < persons.length; i++) {
            persons[i].introduce();
        }
        System.out.println();
        // 年齢差をチェック
        persons[0].compare(persons[1]);
        persons[1].compare(persons[2]);
        persons[2].compare(persons[1]);
    }
}
// ここにPersonクラスを作成してください。

class Person {
	//attribute
	private String name;
	private int age;
	
	//method
	void setData(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	void introduce() {
		System.out.printf("わたしの名前は%s、年齢は%d歳です。\n", this.name, this.age);
	}
	
	String getName() {
		return name;
	}
	
	int getAge() {
		return age;
	}
	
	void compare(Person person) {
		var age = person.getAge();
		var name = person.getName();
		if (this.age > age) {
			var difference = this.age - age;
			System.out.printf("わたくし%sは、%sさんより%d歳年上です\n", this.name, name, difference);
		} else if ( this.age == age) {
			System.out.printf("わたくし%sは、%sさんと同じ年齢です\n", this.name, name);
		} else {
			var difference = age - this.age;
			System.out.printf("わたくし%sは、%sさんより%d歳年下です\n", this.name, name, difference);
		}
	}
}

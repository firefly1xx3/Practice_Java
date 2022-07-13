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


// さらに、生徒ネストクラスを作成してください

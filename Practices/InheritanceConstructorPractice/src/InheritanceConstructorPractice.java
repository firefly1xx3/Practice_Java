public class InheritanceConstructorPractice {
    public static void main(String[] args) {
        // Magazineクラスのオブジェクトを生成
        Magazine magazine = new Magazine("東京Runner", 650, "上野彩");
        // 雑誌の内容紹介メソッドの呼び出し
        magazine.show();
    }
}
// Bookクラス
class Book {
    // タイトル
    private String title;
    // 価格
    private int price;
    // コンストラクタ
    public Book(String title, int price) {
        this.title = title;
        this.price = price;
    }
    // タイトル取得メソッド
    public String getTitle() {
        return title;
    }
    // 価格取得メソッド
    public int getPrice() {
        return price;
    }
}
// ここにMagazineクラスを作成してください
/*
 * If did not write super constructor on Magazine constructor,
 * program automatically did default constructor of super.
 * But there is no constructor, that's why it cause error. 
 */

class Magazine extends Book {
	private String coverPersonName;
	public Magazine(String title, int price, String coverPersonName) {
		super(title, price);
		this.coverPersonName = coverPersonName;
	}
	void show() {
		System.out.printf(
				"%s絶賛発売中！！\n"
				+ "定価%d円\n"
				+ "今回の表紙：%sさん", 
				getTitle(),
				getPrice(),
				coverPersonName);
	}
}
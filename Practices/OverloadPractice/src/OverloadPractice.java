public class OverloadPractice {
    public static void main(String[] args) {
        // シェフオブジェクトの生成
        Chef chef = new Chef();
        // 食材オブジェクトの生成
        Egg egg = new Egg();
        Rice rice = new Rice();
        Milk milk = new Milk();
        Cheese cheese = new Cheese();
        // シェフがフルコースを調理します
        System.out.println("1品目は" + chef.cook(egg, cheese) + "です");
        System.out.println("2品目は" + chef.cook(rice, egg) + "です");
        System.out.println("3品目は" + chef.cook(rice, cheese) + "です");
        System.out.println("4品目は" + chef.cook(milk, egg) + "です");
    }
}
// 各種食材クラス
class Egg{}
class Rice{}
class Milk{}
class Cheese{}
// ここにChefクラスを作成してください

class Chef {
	String cook( Object material1, Object material2) {
		String name; 
		if (material1.getClass() == Egg.class || material2.getClass() == Egg.class) {
			if (material1.getClass() == Cheese.class || 
					material2.getClass() == Cheese.class) {
				name = "スクランブルエッグ";
			} else if (material1.getClass() == Rice.class || 
					material2.getClass() == Rice.class) {
				name = "オムライス";
			} else {
				name = "プディング";
			}
		} else {
			name = "リゾット";
		}
		return name;
	}
}
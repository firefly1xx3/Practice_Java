public class EnumBasicPractice {
    public static void main(String[] args) {
        // 四季列挙子を格納した配列変数の宣言
        Season[] seasons = {
                        Season.SPRING,
                        Season.SUMMER,
                        Season.FALL,
                        Season.WINTER
             };
        // 四季をループで回す
        for (var season : seasons) {
        	var seasonName = season.toString();
        	if (seasonName == "夏") { 
        		System.out.println(seasonName + "は暑い");
        	} else if (seasonName == "冬") {
        		System.out.println(seasonName + "は寒い");
        	} else if (seasonName == "春" || seasonName == "秋"){
        		System.out.println(seasonName);
        	} else {
        		System.out.println("Something error happens.");
        	}
        }

        /*
         * we can write like this with enum. 
        for (var season : seasons) {
        	switch (season) {
	        	case SUMMER:
	        		break;
	        	case WINTER:
	        		break;
	        	case SPRING:
	        	case FALL:
	        		break;
	        	default:
	        		throw new RuntimeException("Illegal Season!");
        	}
        }
        */
    }
}
// ここに季節列挙型を作成してください

enum Season {
	SPRING("春"),
	SUMMER("夏"),
	FALL("秋"),
	WINTER("冬");
	private String name; 
	// 'final' in java == 'const' in other language like c++ & c.
	private Season (final String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return this.name;
	}
	
}
public class InheritancePractice {
    public static void main(String[] args) {
        // 投手オブジェクトの生成
        Pitcher p = new Pitcher("山田", 99, 0.09, 2.13);
        // 投手の紹介
        p.introduce();
    }
}
// 野球選手クラス
class BaseballPlayer {
    // 選手名
    protected String name;
    // 背番号
    protected int uniformNumber;
    // 打率
    protected double battingAverage;
}
// ここにPitcherクラスを作成してください

class Pitcher extends BaseballPlayer{
	private double era;
	public Pitcher(String name, int uniformNumber, 
			double battingAverage, double era) {
		this.name = name;
		this.uniformNumber = uniformNumber;
		this.battingAverage = battingAverage;
		this.era = era;
	}
	void introduce() {
		System.out.printf("選手名：%s\n"
				+ "背番号：%d\n"
				+ "打率　：%.2f\n"
				+ "防御率：%.2f", 
				name, 
				uniformNumber,
				battingAverage,
				era);
	}
}
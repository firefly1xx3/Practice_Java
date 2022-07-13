import java.util.Random;

public class ThreadPractice {
    public static void main(String[] args) {
        // 平均的な性能のnormal号
        RacingCar normal = new RacingCar("Normal号", 10, 10);
        // スピードはあるがエンストが多いgambler号
        RacingCar gambler = new RacingCar("Gambler号", 20, 3);
        // 安全面を重視したcareful号
        RacingCar careful = new RacingCar("Careful号", 5, 1000);
        // 各車一斉にスタート！！
        normal.start();
        gambler.start();
        careful.start();
        // 前車がゴールするのを待つ
        try {
            normal.join();
            gambler.join();
            careful.join();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("レースが終了しました");
    }
}
// ここにRacingCarクラスを作成してください
class RacingCar extends Thread {
	//attribute
	int GOAL = 100;
	private String name;
	private int maxDistance;
	private int engineStop;
	//Constructor
	public RacingCar(String name, int maxDistance, int engineStop) {
		this.name = name;
		this.maxDistance = maxDistance;
		this.engineStop = engineStop;
	}
	//method 
	@Override
	public void run() {
		int totalMileage = 0;
		int mileage;
		int valueOfEngineStop;
		Random r = new Random();
		while (totalMileage <= GOAL) {
			try {
				if (r.nextInt(this.engineStop) == 0) {
					System.out.printf("%s号がエンストしました！%n", name);
					super.sleep(3000);
				} else {
					mileage = r.nextInt(this.maxDistance) + 1;
					totalMileage += mileage;
					System.out.printf("%s号が%dkm走行しました！(%d)%n", 
							name, mileage, totalMileage);
				}
				super.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.printf("%s号がゴールしました！！！！！%n", name);
	}
}
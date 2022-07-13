public class ThreadSafePractice {
    public static void main(String[] args) {
        // 募金箱オブジェクトの取得
        CollectionBox cb = CollectionBox.getInstance();
        // 偽物の募金箱を作れないようにする（コンパイルエラー）
        // CollectionBox imitation = new CollectionBox();
        // 5人の大富豪オブジェクトを生成
        MultiMillionaire mm1 = new MultiMillionaire(cb);
        MultiMillionaire mm2 = new MultiMillionaire(cb);
        MultiMillionaire mm3 = new MultiMillionaire(cb);
        MultiMillionaire mm4 = new MultiMillionaire(cb);
        MultiMillionaire mm5 = new MultiMillionaire(cb);
        // 募金の開始
        mm1.start();
        mm2.start();
        mm3.start();
        mm4.start();
        mm5.start();
        // 全員の募金が終わるまで待つ
        try {
            mm1.join();
            mm2.join();
            mm3.join();
            mm4.join();
            mm5.join();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        // 募金総額の発表
        System.out.println("募金総額は" + cb.getTotalAmount() + "円です。");
    }
}
// ここに大富豪クラスを作成してください
class MultiMillionaire extends Thread {
	//To check how much he contributes to cb.
	int eachTotalAmount = 0;
	CollectionBox cb = CollectionBox.getInstance();
	//Constructor
	public MultiMillionaire(CollectionBox cb) {
		this.cb = cb;
	}
	//
	@Override
	public void run() {
		for(int i = 0; i < 1000000; i++) {
			cb.contribute(1);
			eachTotalAmount+=1;
			if ( i < 10 ) {
				System.out.printf("%s totally contribute %d%n", this.toString(), eachTotalAmount);
			}
		}
	}
}
// ここに募金箱クラスを作成してください
class CollectionBox {
	private int totalAmount = 0;
	// Prevent creating class instance from outside of CollectionBox class.
	private static CollectionBox cb;
	// Ban to access class from outside.
	private CollectionBox() {}
	// create instance at inside of class.
    public static CollectionBox getInstance() {
        // Create instance if there is no instance.
        if(cb == null) {
            cb = new CollectionBox();
        }
        return cb;
    }
    //
    public synchronized void contribute(int contribution) {
    	totalAmount += contribution;
    }
    // 
    public int getTotalAmount() {
    	return totalAmount;
    }
    
    
}
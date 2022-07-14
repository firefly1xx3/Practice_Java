import java.util.*;
public class TotalHiLevelPractice {
    public static void main(String[] args) {
        // ホテルがオープン
        Hotel hotel = new Hotel("ホテルドルフィン");
        // ホテルに3人の従業員が出勤
        hotel.enter(new Staff("坂本", "清掃"));
        hotel.enter(new Staff("長野", "調理"));
        hotel.enter(new Staff("井ノ原", "接客"));
        System.out.println();
        // 3人のお客様がチェックイン（1人が所持金不足で泊まれず）
        hotel.enter(new Customer("岡田", 500000), Hotel.RoomRank.SUITE);
        hotel.enter(new Customer("三宅", 40000), Hotel.RoomRank.NORMAL);
        hotel.enter(new Customer("森田", 4000), Hotel.RoomRank.ECONOMY);
        System.out.println();
        // ホテルを運営
        hotel.manage();
        System.out.println();
        // お客様情報の確認
        hotel.showCustomerInfo();
        System.out.println();
        // ホテル情報の確認
        hotel.showHotelInfo();
    }
}
// ここにホテルクラスを作成してください
class Hotel {
	// private attribute
	private String name;
	private long profits;
	private ArrayList<Staff> staffs;
	private ArrayList<Customer> customers;
	
	// nest enum
	enum RoomRank { 
		// absolutely write enum values first.
		SUITE("スイートルーム", 100000),
		NORMAL("通常ルーム", 20000),
		ECONOMY("格安ルーム", 5000);
		// private attribute
		private String roomRankName;
		private int price;
		// define each enum value
		// constructor
		private RoomRank(String roomRankName, int price) {
			this.roomRankName = roomRankName;
			this.price = price;
		}
		// method 
		// get price
		public int getPrice() {
			return price;
		}
		// get room rank
		@Override
		public String toString() {
			return roomRankName;
		}
	} // end of RoomRank enum.
	// constructor 
	public Hotel (String name) {
		this.name = name;
		System.out.printf("%sがオープンしました%n", this.name);
		staffs = new ArrayList<>();
		customers = new ArrayList<>();
	}
	// attendance at work
	void enter (Staff s) {
		staffs.add(s);
		System.out.printf("%sが%sに出勤しました%n", s.getName(), name);
	}
	// arrival by customer
	void enter (Customer c, RoomRank rank) {
		try {
			profits += c.pay(rank.getPrice());
			customers.add(c);
			System.out.printf("%s様が%sの%sにお泊まりになります%n",
					c.getName(), name, rank.toString());
		} catch (ShortFallException e) {
			System.out.println(e.getMessage());
		}
	}
	// order employees to work
	void manage () {
		for (var staff : staffs) {
			staff.work();
		}
	}
	// Show customer's information
	void showCustomerInfo() {
		System.out.println("お客様情報");
		for (var customer : customers) {
			System.out.println(customer.toString());
		}
	}
	// Show information of both customers and hotel.
	void showHotelInfo() {
		System.out.printf("%sの現在の状況%n", name);
		System.out.println("現在働いている従業員数 : " + staffs.size());
		System.out.println("現在お泊まりのお客様数 : " + customers.size());
		System.out.println("現在の利益 : " + profits);
	}
}
// 人抽象クラス
abstract class Person {
    // 氏名
    protected String name;
    // 名前取得メソッド
    public String getName() {
        return name;
    }
}
// 労働可能インタフェース
interface Workable {
    // 働く抽象メソッド
    void work();
}

// ここに従業員クラスを作成してください
class Staff extends Person implements Workable {
	// private attribute
	private String jobType;
	// constructor 
	public Staff( String name, String jobType ) {
		this.jobType = jobType;
		this.name = name;
	}
	/*
	 * If super class is abstract, child class has to define override 
	 * abstract method of super class.
	 */
	public void work() {
		System.out.printf("%sが%sを行いました%n", name, jobType);
	}
	
}

// ここに顧客クラスを作成してください
class Customer extends Person {
	// private attribute
	private int money;
	// constructor 
	public Customer ( String name, int money ) {
		this.money = money;
		//Person.this.name = name; 
		this.name = name;
	}
	// method 
	// payment 
	public int pay (int payment) throws ShortFallException {
		// if customer has not enough money to pay to hotel.
		if (money - payment < 0) {
			throw new ShortFallException(this.name + "は所持金不足です");
		} else {
			money -= payment;
			return payment;
		}
	}
	// output customer's information.
	@Override
	public String toString() {
		return name + "様　所持金：" + money + "円";
	}
	
}
// 所持金不足例外クラス
class ShortFallException extends Exception {
    public ShortFallException(String message) {
        super(message);
    }
}
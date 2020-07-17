import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Index {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int choseMenuOption = -1;
		Integer arr[] = {1, 2, 3};
		ArrayList<Integer> eMenuOption = new ArrayList<>(Arrays.asList(arr));
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			do {
				System.out.println("---------------------------------------------");
				System.out.println("Xin chao den voi ung dung ban banh my: ");
				System.out.println("1. Mua banh my");
				System.out.println("2. In danh sach da ban");
				System.out.println("3. Thoat");
				System.out.println("---------------------------------------------");
				System.out.print("\n\nMoi chon: ");
				
				choseMenuOption = Integer.parseInt(br.readLine());
			} while (!eMenuOption.contains(choseMenuOption));
			
			//Add material
			switch (choseMenuOption) {
			case 1:
				buyBread();
				break;
			case 2:
				System.out.println("Ban chon in danh sach");
				break;
			case 3:
				System.exit(0);
				break;
			}
			
		} catch (IOException e) {
			System.out.println("Error - man hinh chinh: "+e);
		}
	}
	
	
	public static void buyBread() {
		int choseMenuOption = -1;
		Integer arr[] = {1, 2, 3, 4, 5};
		ArrayList<Integer> eMenuOption = new ArrayList<>(Arrays.asList(arr));
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			do {
				System.out.println("---------------------------------------------");
				System.out.println("Ban muon mua banh my loai nao: ");
				System.out.println("1. Banh my khong");
				System.out.println("2. Banh my trung");
				System.out.println("3. Banh my thit");
				System.out.println("4. Banh my ca");
				System.out.println("5. Banh my tu chon");
				System.out.println("---------------------------------------------");
				System.out.print("\n\nMoi chon: ");
				
				choseMenuOption = Integer.parseInt(br.readLine());
			} while (!eMenuOption.contains(choseMenuOption));
			
			//Add material
			switch (choseMenuOption) {
			case 1:
				BanhMy bread = new BanhMy();
				bread.buy();
				System.out.println("Ban da mua thanh cong!");
				System.out.println(bread.toString());
				break;
			case 2:
				BanhMy breadTrung = new BanhMyTrung();
				breadTrung.buy();
				System.out.println("Ban da mua thanh cong!");
				System.out.println(breadTrung.toString());
				break;
			case 3:
				BanhMy breadThit = new BanhMyThit();
				breadThit.buy();
				System.out.println("Ban da mua thanh cong!");
				System.out.println(breadThit.toString());
				break;
			case 4:
				BanhMy breadCa = new BanhMyCa();
				breadCa.buy();
				System.out.println("Ban da mua thanh cong!");
				System.out.println(breadCa.toString());
				break;
			case 5:
				BanhMy breadTuChon = new BanhTuChon();
				breadTuChon.buy();
				System.out.println("Ban da mua thanh cong!");
				System.out.println(breadTuChon.toString());
				break;
		     }
		} catch (IOException e) {
			System.out.println("Error - chon loai banh my: "+e);
		}
	}

}

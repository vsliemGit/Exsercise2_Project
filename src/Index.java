import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Index {
	private static String filename = "myObjects.txt";
	
    public static void main(String[] args) {

    	while (true) {	
			loadIndex();
		}
    	
    	
    }
    
    public static void loadIndex() {
    	int choseMenuOption = -1;
		Integer arr[] = {1, 2, 3};
		ArrayList<Integer> eMenuOption = new ArrayList<>(Arrays.asList(arr));
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			do {
				System.out.println("+-------------------------------------------+");
				System.out.println("|           UNG DUNG BAN BANH MY            |");
				System.out.println("+-------------------------------------------+");
				System.out.println("|     1. Mua banh my                        |");
				System.out.println("+-------------------------------------------+");
				System.out.println("|     2. In danh sach da ban                |");
				System.out.println("+-------------------------------------------+");
				System.out.println("|     3. Thoat                              |");
				System.out.println("+-------------------------------------------+");
				System.out.print("\n\nMoi chon: ");
				
				choseMenuOption = Integer.parseInt(br.readLine());
			} while (!eMenuOption.contains(choseMenuOption));
			
			//Add material
			switch (choseMenuOption) {
			case 1:
				int no = IOFile.readFromBinaryFile(filename).size();
				buyBread(no);
				break;
			case 2:
				System.out.println("+------------------------------------------------------------------------------------------------------+");
				System.out.println("|                               DANH SACH DA BAN                                                       |");
				
				ArrayList<BanhMy> listBreads = IOFile.readFromBinaryFile(filename);
		    	Collections.sort(listBreads);
				for (BanhMy bread : listBreads) {
					System.out.println(bread.toString());
				}
				System.out.println("--------------------------------------------------------------------------------------------------------");
				break;
			case 3:
				System.exit(0);
				break;
			}
			
		} catch (IOException e) {
			System.out.println("Error - man hinh chinh: "+e);
		}	  
    }
    
    public static void buyBread(int no) {
    	int choseMenuOption = -1;
		Integer arr[] = {1, 2, 3, 4, 5, 6};
		ArrayList<Integer> eMenuOption = new ArrayList<>(Arrays.asList(arr));
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			do {
				System.out.println("+-------------------------------------------+");
				System.out.println("|  Ban muon mua banh my loai nao:           |");
				System.out.println("+-------------------------------------------+");
				System.out.println("|      1. Banh my khong                     |");
				System.out.println("+-------------------------------------------+");
				System.out.println("|      2. Banh my trung                     |");
				System.out.println("+-------------------------------------------+");
				System.out.println("|      3. Banh my thit                      |");
				System.out.println("+-------------------------------------------+");
				System.out.println("|      4. Banh my ca                        |");
				System.out.println("+-------------------------------------------+");
				System.out.println("|      5. Banh my tu chon                   |");
				System.out.println("+-------------------------------------------+");
				System.out.print("\n\nMoi chon: ");
				
				choseMenuOption = Integer.parseInt(br.readLine());
			} while (!eMenuOption.contains(choseMenuOption));
			
			
			BanhMy bread;
			Material tempMaterial;
			ArrayList<Material> tempListMaterial = new ArrayList<Material>();
			
			//Add material
			switch (choseMenuOption) {
			case 1:
				bread = new BanhMy();
				bread.setNameProduct("Banh_my_khong");
				bread.setNo(no);
				tempMaterial = new Material("Banh_my_khong", 8);
				tempListMaterial.add(tempMaterial);
				bread.setListMaterial(tempListMaterial);
				
				bread.buy();
				
				bread.getListStringMaterials();
				System.out.println(bread.toString());
				
				IOFile.writeToBinary(filename, bread, true);
				System.out.println("Ban da mua thanh cong!");
				break;
			case 2:
				bread = new BanhMy();
				bread.setNameProduct("Banh_my_trung");
				bread.setNo(no);
				
				tempMaterial = new Material("Banh_my_khong", 8);
				tempListMaterial.add(tempMaterial);
				tempMaterial = new Material("Trung_chien", 5);
				tempListMaterial.add(tempMaterial);
				tempMaterial = new Material("Rau", 1);
				tempListMaterial.add(tempMaterial);
				tempMaterial = new Material("Gia_vi", 1);
				tempListMaterial.add(tempMaterial);
				bread.setListMaterial(tempListMaterial);
				
				bread.buy();
				
				bread.getListStringMaterials();
				System.out.println(bread.toString());
				
				IOFile.writeToBinary(filename, bread, true);
				System.out.println("Ban da mua thanh cong!");
				break;
			case 3:
				bread = new BanhMy();
				bread.setNameProduct("Banh_my_thit");
				bread.setNo(no);
				
				tempMaterial = new Material("Banh_my_khong", 8);
				tempListMaterial.add(tempMaterial);
				tempListMaterial.add(bread.choseCha());
				tempMaterial = new Material("Thit", 8);
				tempListMaterial.add(tempMaterial);
				tempMaterial = new Material("Rau", 1);
				tempListMaterial.add(tempMaterial);
				tempMaterial = new Material("Gia_vi", 1);
				tempListMaterial.add(tempMaterial);
				bread.setListMaterial(tempListMaterial);
				
				bread.buy();
				
				bread.getListStringMaterials();
				System.out.println(bread.toString());
				
				IOFile.writeToBinary(filename, bread, true);
				System.out.println("Ban da mua thanh cong!");
				break;
			case 4:
				bread = new BanhMy();
				bread.setNameProduct("Banh_my_ca");
				bread.setNo(no);
				
				tempMaterial = new Material("Banh_my_khong", 8);
				tempListMaterial.add(tempMaterial);
				tempMaterial = new Material("Ca_hoi", 5);
				tempListMaterial.add(tempMaterial);
				tempMaterial = new Material("Rau", 1);
				tempListMaterial.add(tempMaterial);
				tempMaterial = new Material("Gia_vi", 1);
				tempListMaterial.add(tempMaterial);
				bread.setListMaterial(tempListMaterial);
				
				bread.buy();
				
				bread.getListStringMaterials();
				System.out.println(bread.toString());
				
				IOFile.writeToBinary(filename, bread, true);
				System.out.println("Ban da mua thanh cong!");
				break;
			case 5:
				bread = new BanhMy();
				bread.setNameProduct("Banh_my_tu_chon");
				bread.setNo(no);
				
				bread.buy();
				System.out.println(bread.toString());
				
				IOFile.writeToBinary(filename, bread, true);
				System.out.println("Ban da mua thanh cong!");
				break;
			case 6:
				return;
		     }
		} catch (IOException e) {
			System.out.println("Error - chon loai banh my: "+e);
		}
		
    }
}

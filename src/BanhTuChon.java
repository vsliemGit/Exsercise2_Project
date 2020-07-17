import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BanhTuChon extends BanhMy{
	public BanhTuChon() {
		this.setNameProduct("Banh_my_tu_chon");
		this.setPrice(0);
	}
	
	public void buy() {
		int choseMenuOption = -1;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			do {
				this.addMaterial();
				System.out.println("---------------------------------------------");
				System.out.println("Ban co muon mua them khong?");
				System.out.println("1. Co");
				System.out.println("2. Khong");

				System.out.println("---------------------------------------------");
				System.out.print("\n\nMoi chon: ");

				choseMenuOption = Integer.parseInt(br.readLine());
				
			} while (choseMenuOption != 2);
		} catch (IOException e) {
			System.out.println("Error - chon loai banh my: "+e);
		}
	}
	
	public void addMaterial() {
		int choseMenuOption = -1;
		Integer arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		ArrayList<Integer> eMenuOption = new ArrayList<>(Arrays.asList(arr));
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			do {			
				System.out.println("Ban muon chon mon nao? ");
				System.out.println("1. Trung chien");
				System.out.println("2. Cha bong");
				System.out.println("3. Cha lua");
				System.out.println("4. Cha bo");
				System.out.println("5. Nem");
				System.out.println("6. Thit");
				System.out.println("7. Ca hoi");
				System.out.println("8. Rau");
				System.out.println("9. Gia vi");
				System.out.println("10. Banh my khong");
				choseMenuOption = Integer.parseInt(br.readLine());
			} while (!eMenuOption.contains(new Integer(choseMenuOption)));
			
			//Add material
			ArrayList<Material> temp;
			Material materialNew;
			switch (choseMenuOption) {
			case 1:
				materialNew = new Material("Trung_chien", 5 );
				
				if(this.getListMaterial() != null) {
					if(this.checkMaterial(materialNew)) break;
					temp = new ArrayList<Material>(this.getListMaterial());
				}else {
					temp = new ArrayList<Material>();
				}
				temp.add(materialNew);
				this.setListMaterial(temp);
				break;
				
			case 2:
				materialNew = new Material("Cha_bong", 5 );
				if(this.getListMaterial() != null) {
					if(this.checkMaterial(materialNew)) break;
					temp = new ArrayList<Material>(this.getListMaterial());
				}else {
					temp = new ArrayList<Material>();
				}
				temp.add(materialNew);
				this.setListMaterial(temp);
				break;
				
			case 3:
				materialNew = new Material("Cha_lua", 5 );
				if(this.getListMaterial() != null) {
					if(this.checkMaterial(materialNew)) break;
					temp = new ArrayList<Material>(this.getListMaterial());
				}else {
					
					temp = new ArrayList<Material>();
				}
				temp.add(materialNew);
				this.setListMaterial(temp);
				break;
				
			case 4:
				materialNew = new Material("Cha_bo", 5 );
				if(this.getListMaterial() != null) {
					if(this.checkMaterial(materialNew)) break;
					temp = new ArrayList<Material>(this.getListMaterial());
				}else {
					
					temp = new ArrayList<Material>();
				}
				temp.add(materialNew);
				this.setListMaterial(temp);
				break;
				
			case 5:
				materialNew = new Material("Nem", 4 );
				if(this.getListMaterial() != null) {
					if(this.checkMaterial(materialNew)) break;
					temp = new ArrayList<Material>(this.getListMaterial());
				}else {
					
					temp = new ArrayList<Material>();
				}
				temp.add(materialNew);
				this.setListMaterial(temp);
				break;
				
			case 6:
				materialNew = new Material("Thit", 8 );
				if(this.getListMaterial() != null) {
					if(this.checkMaterial(materialNew)) break;
					temp = new ArrayList<Material>(this.getListMaterial());
				}else {
					
					temp = new ArrayList<Material>();
				}
				temp.add(materialNew);
				this.setListMaterial(temp);
				break;

			case 7:
				materialNew = new Material("Ca_hoi", 5 );
				if(this.getListMaterial() != null) {
					if(this.checkMaterial(materialNew)) break;
					temp = new ArrayList<Material>(this.getListMaterial());
				}else {
					
					temp = new ArrayList<Material>();
				}
				temp.add(materialNew);
				this.setListMaterial(temp);
				break;

			case 8:
				materialNew = new Material("Rau", 1 );
				if(this.getListMaterial() != null) {
					if(this.checkMaterial(materialNew)) break;
					temp = new ArrayList<Material>(this.getListMaterial());;
				}else {
					
					temp = new ArrayList<Material>();
				}
				temp.add(materialNew);
				this.setListMaterial(temp);
				break;

			case 9:
				materialNew = new Material("Gia_vi", 1 );
				if(this.getListMaterial() != null) {
					if(this.checkMaterial(materialNew)) break;
					temp = new ArrayList<Material>(this.getListMaterial());
				}else {
				
					temp = new ArrayList<Material>();
				}
				temp.add(materialNew);
				this.setListMaterial(temp);
				break;
				
			default:
				materialNew = new Material("Banh_my_khong", 8 );
				if(this.getListMaterial() != null) {
					if(this.checkMaterial(materialNew)) break;
					temp = new ArrayList<Material>(this.getListMaterial());
				}else {
					temp = new ArrayList<Material>();
				}
				temp.add(materialNew);
				this.setListMaterial(temp);
				break;
			}
			
		} catch (IOException e) {
			System.out.println("Error: mua them mon - "+e);
		}
			

	}

}

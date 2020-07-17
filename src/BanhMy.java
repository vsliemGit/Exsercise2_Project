import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

public class BanhMy extends Product implements Serializable{

	public BanhMy() {
		this.setListMaterial(new ArrayList<Material>());
		this.setNameProduct("Banh_my_khong");
		Material tempMaterial = new Material("Banh_my_khong", 8);
		ArrayList<Material> tempListMaterial = new ArrayList<Material>();
		tempListMaterial.add(tempMaterial);
		this.setListMaterial(tempListMaterial);
		LocalDateTime now = LocalDateTime.now();  
		this.setDateTime(now);	
	}
	
	public String getListStringMaterials() {
		ArrayList<Material> tempListMaterial = this.getListMaterial();
		if(tempListMaterial != null) {
			String stringTempMaterial = tempListMaterial.get(0).getName();
			for (int i=1; i < tempListMaterial.size(); i++) {
				stringTempMaterial += ", "+tempListMaterial.get(i).getName();
			}
			return stringTempMaterial;
		}
		return this.getMaterials();
	}
	
	public boolean checkMaterial(Material material) {
		if(this.getListMaterial()!=null) {
			for(Material materialCheck : this.getListMaterial()) {
				if(materialCheck.getName().equals(material.getName())) 
					return true;
			}
			return false;
		}
		return false;
	}
	
	public int getPriceMaterial() {
		ArrayList<Material> tempListMaterial = this.getListMaterial();
		int tempPrice = this.getPrice();
		if(tempListMaterial!=null) {
			for (Material tempMaterial : tempListMaterial) {
				tempPrice += tempMaterial.getPrice();
			}
			return tempPrice;
		}
		return tempPrice;
	}
	
	public void buy() {
		int choseMenuOption1 = -1;
		Integer arr[] = {1, 2};
		ArrayList<Integer> eMenuOption = new ArrayList<>(Arrays.asList(arr));
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			do {
				System.out.println("---------------------------------------------");
				System.out.println("Ban co muon them thanh phan khac khong: ");
				System.out.println("1. Co");
				System.out.println("2. Khong");
				System.out.println("---------------------------------------------");
				System.out.print("\n\nMoi chon: ");
				
				choseMenuOption1 = Integer.parseInt(br.readLine());
			} while (!eMenuOption.contains(choseMenuOption1));
			
			//Add material
			if(choseMenuOption1==1) {
				int choseOption2 = 0;
				while(choseOption2 == 0){
					this.addMaterial();
					System.out.println("---------------------------------------------");
					System.out.println("Ban co muon them nua khong: ");
					System.out.println("1. Co");
					System.out.println("2. Khong");
					System.out.println("---------------------------------------------");
					System.out.print("\n\nMoi chon: ");
					int tempChose = Integer.parseInt(br.readLine());
					if(tempChose != 1 ) {
						choseOption2 = 1; 
					}
				}	
			}
		} catch (IOException e) {
			System.out.println("Error: "+e);
		}
	}
	
	@Override
	
	public void addMaterial() {
		int choseMenuOption = -1;
		Integer arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		ArrayList<Integer> eMenuOption = new ArrayList<>(Arrays.asList(arr));
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			do {			
				System.out.println("Ban them mon nao? ");
				System.out.println("1. Trung chien");
				System.out.println("2. Cha bong");
				System.out.println("3. Cha lua");
				System.out.println("4. Cha bo");
				System.out.println("5. Nem");
				System.out.println("6. Thit");
				System.out.println("7. Ca hoi");
				System.out.println("8. Rau");
				System.out.println("9. Gia vi");
				choseMenuOption = Integer.parseInt(br.readLine());
			} while (!eMenuOption.contains(new Integer(choseMenuOption)));
			
			//Add material
			ArrayList<Material> temp;
			Material materialNew;
			int priceTemp = 0;
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
				this.setMaterials(this.getMaterials().concat(", Trung_chien"));
				priceTemp = this.getPrice();
				this.setPrice(priceTemp+=5);
			
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
				this.setMaterials(this.getMaterials().concat(", Cha_bong"));
				priceTemp = this.getPrice();
				this.setPrice(priceTemp+=5);
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
				this.setMaterials(this.getMaterials().concat(", Cha_lua"));
				priceTemp = this.getPrice();
				this.setPrice(priceTemp+=5);
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
				this.setMaterials(this.getMaterials().concat(", Cha_bo"));
				priceTemp = this.getPrice();
				this.setPrice(priceTemp+=5);
				
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
				this.setMaterials(this.getMaterials().concat(", Nem"));
				priceTemp = this.getPrice();
				this.setPrice(priceTemp+=4);
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
				this.setMaterials(this.getMaterials().concat(", Thit"));
				priceTemp = this.getPrice();
				this.setPrice(priceTemp+=8);
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
				this.setMaterials(this.getMaterials().concat(", Ca_hoi"));
				priceTemp = this.getPrice();
				this.setPrice(priceTemp+=5);
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
				this.setMaterials(this.getMaterials().concat(", Rau"));
				priceTemp = this.getPrice();
				this.setPrice(priceTemp+=1);
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
				this.setMaterials(this.getMaterials().concat(", Gia_vi"));
				priceTemp = this.getPrice();
				this.setPrice(priceTemp+=1);
				break;
				
			default:
				break;
			}
			
		} catch (IOException e) {
			System.out.println("Error: mua them mon - "+e);
		}
			

	}

	@Override
	
	public void delMaterial() {
	
	}

	@Override
	public String toString() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		return "Name product: "+ this.getNameProduct() + "  Materials: ["+ this.getListStringMaterials()+"]" + " Price: " + this.getPriceMaterial()+ "k  Time: " + dtf.format(this.getDateTime());
	}

	
	
	
}

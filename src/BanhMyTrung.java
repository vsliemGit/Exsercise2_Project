import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

public class BanhMyTrung extends BanhMy{
	public BanhMyTrung() {
		super();
		//Set name 
		this.setNameProduct("Banh_my_trung");
		//Set material
		Material tempMaterial = new Material("Trung_chien", 5);
		ArrayList<Material> tempListMaterial = new ArrayList<Material>();
		tempListMaterial.add(tempMaterial);
		this.setListMaterial(tempListMaterial);
		//Set List<String> Material
		this.setMaterials("Banh_my, Trung_chien");
		//Set price
		int priceBanhMyTrung = this.getPrice();
		this.setPrice(priceBanhMyTrung+=5);
		//Set time
		LocalDateTime now = LocalDateTime.now();  
		this.setDateTime(now);
	}
	
	@Override
	void delMaterial() {
		//Get listMaterial to temp
		ArrayList<Material> tempListMaterial = this.getListMaterial();
		
		//Print chose del listMaterial
		if(tempListMaterial!=null) {
			//Get size material and in_it arrChoseOption
			int sizeListMaterial = tempListMaterial.size();
			Integer arr[] = new Integer[sizeListMaterial];		
			
			//List list Material
			for (Material tempMaterial : tempListMaterial) {	
				ArrayList<Integer> eMenuOption = new ArrayList<>(Arrays.asList(arr));
				int choseMenuOption = -1;
				try {
					BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
					int tempNO = 0;
					do {
						System.out.println("---------------------------------------------");
						System.out.println("Ban khong an mon nao: ");
						for (int i = 0; i < arr.length; i++) {
							tempNO = i+1;
							System.out.println(tempNO+". "+tempMaterial.getName());
						}
						tempNO++;
						System.out.println(tempNO + ". Thoat");
						System.out.println("---------------------------------------------");
						System.out.print("\n\nMoi chon: ");
						
						choseMenuOption = Integer.parseInt(br.readLine());
						
					} while (!eMenuOption.contains(choseMenuOption));
					
					//Exit if chose option Exit
					if (choseMenuOption == tempNO) {
						this.buy();
					}
					
					System.out.println("ban muon xoa "+choseMenuOption);
					
					//Add material
					this.setListMaterial(tempListMaterial);
				} catch (IOException e) {
					System.out.println("Error - chon loai banh my: "+e);
				}
				
			}
		}else {
			System.out.println("Thanh phan rong!");
		}
	}
	
	void addMaterial() {
		int choseMenuOption = -1;
		Integer arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		ArrayList<Integer> eMenuOption = new ArrayList<>(Arrays.asList(arr));
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			do {			
				System.out.println("Ban them mon nao? ");
				System.out.println("1. Cha bong");
				System.out.println("2. Cha lua");
				System.out.println("3. Cha bo");
				System.out.println("4. Nem");
				System.out.println("5. Thit");
				System.out.println("6. Ca hoi");
				System.out.println("7. Rau");
				System.out.println("8. Gia vi");
				choseMenuOption = Integer.parseInt(br.readLine());
			} while (!eMenuOption.contains(new Integer(choseMenuOption)));
			
			//Add material
			ArrayList<Material> temp;
			Material materialNew;
			int priceTemp = 0;
			switch (choseMenuOption) {	
			case 1:
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
				
			case 2:
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
				
			case 3:
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
				
			case 4:
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
				
			case 5:
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

			case 6:
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

			case 7:
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

			case 8:
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
	public void buy() {
		int choseMenuOption1 = -1;
		Integer arr[] = {1, 2, 3};
		ArrayList<Integer> eMenuOption = new ArrayList<>(Arrays.asList(arr));
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			do {
				System.out.println("---------------------------------------------");
				System.out.println("Ban da mua 'Banh_My_Trung'. Ban co muon: ");
				System.out.println("1. Mua them mon khac khong?");
				System.out.println("2. Bo ra mon nao khong?");
				System.out.println("3. Xac nhan mua");
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
					if(tempChose == 2 ) {
						choseOption2 = 1; 
						this.buy();
					}
				}	
			}
			else if(choseMenuOption1==2) {
				this.delMaterial();
			}
			else {
				return;
			}
		} catch (IOException e) {
			System.out.println("Error: "+e);
		}
	}
}

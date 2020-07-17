import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

public class BanhMyCa extends BanhMy{
	public BanhMyCa() {
		super();
		//Set name 
		this.setNameProduct("Banh_my_ca");
		//Set material
		Material tempMaterial = new Material("Cha_hoi", 5);
		ArrayList<Material> tempListMaterial = new ArrayList<Material>();
		tempListMaterial.add(tempMaterial);
		tempMaterial = new Material("Banh_my_khong", 8);
		tempListMaterial.add(tempMaterial);
		tempMaterial = new Material("Rau", 1);
		tempListMaterial.add(tempMaterial);
		tempMaterial = new Material("Gia_vi", 1);
		tempListMaterial.add(tempMaterial);
		this.setListMaterial(tempListMaterial);
		
		//Set time
		LocalDateTime now = LocalDateTime.now();  
		this.setDateTime(now);
	}
	
	@Override
	public void delMaterial() {
		//Get listMaterial to temp
		ArrayList<Material> tempListMaterial = this.getListMaterial();
		
		//Print chose del listMaterial
		if(tempListMaterial.size() != 0) {
			
			//Get size material and in_it arrChoseOption
			int sizeListMaterial = tempListMaterial.size();
			Integer arr[] = new Integer[sizeListMaterial+1];		
			
			//List list Material
			int choseMenuOption = -1;
			ArrayList<Integer> eMenuOption;
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				int tempNO = 0;
				do {
					System.out.println("---------------------------------------------");
					System.out.println("Ban khong an mon nao: ");
					for (int i = 0; i < tempListMaterial.size(); i++) {
						tempNO = i+1;
						arr[i] = tempNO;
						System.out.println(tempNO+". "+tempListMaterial.get(i).getName());
					}
					tempNO++;
					arr[tempNO-1] = tempNO;
					System.out.println(tempNO + ". Thoat");
					System.out.println("---------------------------------------------");
					System.out.print("\n\nMoi chon: ");
					
					eMenuOption = new ArrayList<>(Arrays.asList(arr));
					choseMenuOption = Integer.parseInt(br.readLine());
					
				} while (!eMenuOption.contains(choseMenuOption));
				
				//Exit if chose option Exit
				if (choseMenuOption == (sizeListMaterial+1) ) {
					this.buy();
				}else {
					tempListMaterial.remove(choseMenuOption-1);
					this.setListMaterial(tempListMaterial);
					this.buy();
				}
				
				

			} catch (IOException e) {
				System.out.println("Error - chon loai banh my: "+e);
			}
		}else {
			System.out.println("Thanh phan rong!");
		}
	}
	
	public void addMaterial() {
		int choseMenuOption = -1;
		Integer arr[] = {1, 2, 3, 4, 5, 6};
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
				System.out.println("6. Trung chien");
				choseMenuOption = Integer.parseInt(br.readLine());
			} while (!eMenuOption.contains(new Integer(choseMenuOption)));
			
			//Add material
			ArrayList<Material> temp;
			Material materialNew;
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
				break;

			case 6:
				materialNew = new Material("Trung chien", 5 );
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
	
	@Override
	public void buy() {
		int choseMenuOption1 = -1;
		Integer arr[] = {1, 2, 3};
		ArrayList<Integer> eMenuOption = new ArrayList<>(Arrays.asList(arr));
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			do {
				System.out.println("---------------------------------------------");
				System.out.println("Ban da mua 'Banh_My_Ca'. Ban co muon: ");
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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

public class BanhMy implements Serializable, Comparable<BanhMy>{
	
	public static int stt = 0;
	private int no;
	private String nameProduct;
	private LocalDateTime dateTime;
	private ArrayList<Material> listMaterial;
	private String materials;
	private int count;
	private int price;
	private int totalPrice;
	
	public BanhMy() {
	        this.setListMaterial(new ArrayList<Material>());
		//Set time
		LocalDateTime now = LocalDateTime.now();  
		this.setDateTime(now);	
	}
	
	
	
	//Load list material and get String materials
	public String getListStringMaterials() {
		ArrayList<Material> tempListMaterial = this.getListMaterial();
		if(this.getListMaterial() != null || tempListMaterial.size() > 0) {
			String stringTempMaterial = tempListMaterial.get(0).getName();
			for (int i=1; i < tempListMaterial.size(); i++) {
				stringTempMaterial += ", "+tempListMaterial.get(i).getName();
			}
			this.setMaterials(stringTempMaterial);
			return stringTempMaterial;
		}
		return (new String());
	}
	
	//Check material constrain in list
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
	
	
	//Get price of bread
	public int getPriceMaterial() {
		ArrayList<Material> tempListMaterial = this.getListMaterial();
		int tempPrice = this.getPrice();
		if(tempListMaterial!=null) {
			for (Material tempMaterial : tempListMaterial) {
				tempPrice += tempMaterial.getPrice();
			}
			return tempPrice;
		}
		return 0;
	}
	
	
	//Function chose cha_lua/cha_bo of Banh_my_thit
	public Material choseCha() {
		Material cha = new Material();
		int choseMenuOption = -1;
		Integer arr[] = {1, 2};
		ArrayList<Integer> eMenuOption = new ArrayList<>(Arrays.asList(arr));
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			do {
				System.out.println("---------------------------------------------");
				System.out.println("Ban an 'Cha lua' hay 'Cha bo' vay? ");
				System.out.println("1. Cha lua");
				System.out.println("2. Cha bo");

				System.out.println("---------------------------------------------");
				System.out.print("\n\nMoi chon: ");

				choseMenuOption = Integer.parseInt(br.readLine());
				
			} while (!eMenuOption.contains(choseMenuOption));
			
			//Exit if chose option Exit
			if (choseMenuOption == 1) {
				cha = new Material("Cha_lua", 5);
			}else {
				cha = new Material("Cha_bo", 5);
			}
		} catch (IOException e) {
			System.out.println("Error - chon loai banh my: "+e);
		}
		return cha;
	}
	
	//Buy bread
	public void buy() {
		int choseMenuOption1 = -1;
		Integer arr[] = {1, 2, 3};
		ArrayList<Integer> eMenuOption = new ArrayList<>(Arrays.asList(arr));
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			do {
				System.out.println("---------------------------------------------");
				System.out.println("Ban da mua '"+this.getNameProduct()+"'. Ban co muon: ");
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
				        
				        if(this.getListMaterial().size()>7) {
                                            System.out.println("Chi duoc mua toi da 8 thanh phan!");
                                            choseOption2 = 1; 
                                            this.buy();
                                        }else {
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
			}
			else if(choseMenuOption1==2) {
				if(this.getListMaterial()!=null) {
					this.delMaterial();
				}else {
					System.out.println("Khong co gi de bo!");
					this.buy();
				}
			}
			else {
				if( this.getListMaterial()!= null && this.getListMaterial().size()>0) {
					System.out.print("Ban muon mua voi so luong bao nhieu?  ");
					int tempChose = Integer.parseInt(br.readLine());
					this.setCount(tempChose);
					this.getListStringMaterials();
				}else this.buy();
				return;
			}
		} catch (IOException e) {
			System.out.println("Error: "+e);
		}
	}
	
	//Add material 
    public void addMaterial() {
		
		int choseMenuOption = -1;

		
		if(this.getListMaterial()==null) {
			this.setListMaterial(new ArrayList<Material>());
		}
					
		
		Integer arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
		ArrayList<Integer> eMenuOption = new ArrayList<>(Arrays.asList(arr));
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			//List list Material
			String[] listMaterials = {"Trung_chien", "Cha_bong", "Cha_lua", "Cha_bo", "Nem", "Thit", "Ca_hoi", "Rau", "Gia_vi", "Banh_my_khong" };
			int tempNO = 0;
				do {
					System.out.println("---------------------------------------------");
					System.out.println("Ban muon them mon nao: ");
					for (int i = 0; i < 10 ; i++) {
						{
							
							if(checkMaterial(new Material(listMaterials[i], i))) {
								continue;
							}
							else {
								tempNO = i+1;
								System.out.println(tempNO+". "+listMaterials[i]);
							}
						}	
					}
					System.out.println(11 + ". Thoat");
					System.out.println("---------------------------------------------");
					System.out.print("\n\nMoi chon: ");
					
					choseMenuOption = Integer.parseInt(br.readLine());
					
				} while (!eMenuOption.contains(choseMenuOption));
			

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
				
			case 10:
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
			case 11:
				break;
			}
			
		} catch (IOException e) {
			System.out.println("Error: mua them mon - "+e);
		}		
	}
	
    //Delete material
    public void delMaterial() {
		//Get listMaterial to temple
		ArrayList<Material> tempListMaterial = this.getListMaterial();
		
		//Print chose delete listMaterial
		if(tempListMaterial.size() > 0 || this.getListMaterial() != null) {
			
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
				if (choseMenuOption == (arr.length) ) {
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
	
	//toString()
	public String toString() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		this.getListStringMaterials();
		this.setTotalPrice(this.getPriceMaterial()*this.count);
		String temp = new String("--------------------------------------------------------------------------------------------------------");
		return temp+"\n  N0."+this.getNo()+"   Name product: "+ this.getNameProduct() + "  Materials: ["+ this.getMaterials()+"]\n" + "  Price one bread: "
				+ this.getPriceMaterial() + "k Count: " + this.getCount() + " Total price: " + this.getTotalPrice()
				+ "k  Time: " + dtf.format(this.getDateTime());
		
	}
	
	
	//Get,Set:
		public int getNo() {
			return no;
		}
		public void setNo(int no) {
			this.no = no;
		}
		public String getNameProduct() {
			return nameProduct;
		}
		public void setNameProduct(String nameProduct) {
			this.nameProduct = nameProduct;
		}
		public LocalDateTime  getDateTime() {
			return dateTime;
		}
		public void setDateTime(LocalDateTime now) {
			this.dateTime = now;
		}
		public ArrayList<Material> getListMaterial() {
			return listMaterial;
		}
		public void setListMaterial(ArrayList<Material> listMaterial) {
			this.listMaterial = listMaterial;
		}
		public int getTotalPrice() {
			return totalPrice;
		}
		public void setTotalPrice(int totalPrice) {
			this.totalPrice = totalPrice;
		}
		public String getMaterials() {
			return materials;
		}
		public void setMaterials(String materials) {
			this.materials = materials;
		}
		public int getCount() {
			return count;
		}
		public void setCount(int count) {
			this.count = count;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}

		@Override
		public int compareTo(BanhMy o) {
			if (this.getTotalPrice() < o.getTotalPrice() ) {
	               return 1;
	           } else {
	               if (this.getTotalPrice() == o.getTotalPrice()) {
	                   return 0;
	               } else {
	                   return -1;
	               }
	           }
		}
}

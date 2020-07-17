import java.time.LocalDateTime;
import java.util.ArrayList;

abstract class Product {
	private int no;
	private String nameProduct;
	private LocalDateTime dateTime;
	private ArrayList<Material> listMaterial;
	private String materials;
	private int count;

	private int price;
	private int totalPrice;

	public Product() {}
	public Product(int no, String nameProduct, LocalDateTime  dateTime, ArrayList<Material> listMaterial,
			int totalPrice) {
		super();
		this.no = no;
		this.nameProduct = nameProduct;
		this.dateTime = dateTime;
		this.listMaterial = listMaterial;
		this.totalPrice = totalPrice;
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
	
	abstract  void addMaterial();
	abstract void delMaterial();
	
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
}

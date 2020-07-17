
public class Material {
	private String name;
	private int price;
	
	//Constructor:
	public Material() {
		// TODO Auto-generated constructor stub
	}
	
	public Material(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	//get(),set():
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}

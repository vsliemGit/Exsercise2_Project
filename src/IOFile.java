import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class IOFile {
	private static String urlFile = new String("Test.dat");
	
	public static void writeFile(BanhMy bm) {
		try {
			FileOutputStream fos = new FileOutputStream(urlFile);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			// write object to file
			oos.writeObject(bm);
			System.out.println("Ghi file thanh cong!");
			// closing resources
			oos.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<BanhMy> loadFile() {
		ArrayList<BanhMy> tempList = new ArrayList<BanhMy>();
		
		try {
			FileInputStream fis = new FileInputStream(urlFile);
			ObjectInputStream input = new ObjectInputStream(fis);
			boolean cont = true;
			while(cont) {
					BanhMy bm = (BanhMy)input.readObject();
				    if (bm != null) {
				    	tempList.add(bm);
				    } else {
				      cont = false;
				    }
			}
			System.out.println("Da doc het file");
			input.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return tempList;
	}
}
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Comparator;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

public class IOFile{
    public static void writeToBinary (String filename, BanhMy obj, boolean append){
        File file = new File (filename);
        ObjectOutputStream out = null;

        try{
            if (!file.exists () || !append) out = new ObjectOutputStream (new FileOutputStream (filename));
            else out = new AppendableObjectOutputStream (new FileOutputStream (filename, append));
            out.writeObject(obj);
            out.flush ();
        }catch (Exception e){
            e.printStackTrace ();
        }finally{
            try{
                if (out != null) out.close ();
            }catch (Exception e){
                e.printStackTrace ();
            }
        }
    }

    public static ArrayList<BanhMy> readFromBinaryFile (String filename){
        File file = new File (filename);
        ArrayList<BanhMy> listBreads = new ArrayList<BanhMy>();
        if (file.exists ()){
            ObjectInputStream ois = null;
            try{
                ois = new ObjectInputStream (new FileInputStream (filename));
                while (true){
                	BanhMy s = (BanhMy)ois.readObject ();
                	listBreads.add(s);
                }
            }catch (EOFException e){

            }catch (Exception e){
                e.printStackTrace ();
            }finally{
                try{
                    if (ois != null) ois.close();
                }catch (IOException e){
                    e.printStackTrace ();
                }
            }
            
            return listBreads;
            
        }
        
        return listBreads;
    }

    private static class AppendableObjectOutputStream extends ObjectOutputStream {
          public AppendableObjectOutputStream(OutputStream out) throws IOException {
            super(out);
          }

          @Override
          protected void writeStreamHeader() throws IOException {}
    }

	
}

package chat;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
public class farmerr implements Serializable{

    String FirstName;
    String LastName;
    String UserName;
    String Password;
    public farmerr(){}
    public farmerr(String FirstName, String LastName, String UserName, String Password) {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.UserName = UserName;
        this.Password = Password;
    }
    public String getFirstName() {
        return this.FirstName;
    }

    public void setFirstName(String FirstName){
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return this.LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getUserName() {
        return this.UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassword() {
        return this.Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    @Override
    public String toString() {
        return 
            " FirstName= " + getFirstName() + "\n" +
            " LastName= " + getLastName() + "\n" +
            " UserName= " + getUserName() + "\n" +
            " Password= " + getPassword() + "\n";
    }
    
        public static void WriteToFile(farmerr f) {
        ArrayList<farmerr> list = readFromFile();
        list.add(f);
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("farmer"));
            output.writeObject(list);
            output.close();
        } catch (IOException e) {
        }
    }

    public static ArrayList<farmerr> readFromFile() {
        ArrayList<farmerr> list = new ArrayList<farmerr>();
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("farmer"));
            list = (ArrayList<farmerr>) input.readObject();
        } catch (ClassNotFoundException c) {
        } catch (ClassCastException d) {
        } catch (IOException i) {
        }
        return list;
    }

    public static boolean search(String name) {
        ArrayList<farmerr> list = readFromFile();
        for (farmerr f : list) {
            if (f.getFirstName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static void delete(farmerr F) {
        ArrayList<farmerr> list = readFromFile();
        for (farmerr f : list) {
            if (f.getFirstName().equals(F.getFirstName())) {
                list.remove(f);
                break;
            }
        }
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("farmer"));
            output.writeObject(list);
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




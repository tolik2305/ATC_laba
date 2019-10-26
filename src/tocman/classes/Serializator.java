package tocman.classes;

import java.io.*;

public class Serializator implements Serializable{

    public boolean serialization(PhoneNumbers phoneNumbers){
        boolean flag=false;

        File file = new File("D:/Phones.txt");

        ObjectOutputStream oos = null;

        try {
            FileOutputStream fos = new FileOutputStream(file);
            if(fos!=null){
                for (PhoneNumber phoneNumber1:phoneNumbers.list) {
                    oos = new ObjectOutputStream(fos);
                    oos.writeObject(phoneNumber1);
                    flag=true;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(oos!=null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return flag;
    }

    public PhoneNumbers deserialization(PhoneNumbers phoneNumbers) throws InvalidObjectException {
        File file = new File("D:/Phones.txt");
        ObjectInputStream ois = null;
        try {
            FileInputStream fis = new FileInputStream(file);
            if(fis!=null) {
                ois = new ObjectInputStream(fis);
                phoneNumbers.add((PhoneNumber) ois.readObject());
                return phoneNumbers;
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        finally {
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        throw new InvalidObjectException("Object fail");
    }
}


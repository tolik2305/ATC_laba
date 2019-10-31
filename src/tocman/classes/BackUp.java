package tocman.classes;

import java.io.*;

public class BackUp extends Thread {

    private static File file;
    private static PhoneNumbers phoneNumbers;

    public BackUp(String pathname, PhoneNumbers phoneNumbers){
        file = new File(pathname);
        BackUp.phoneNumbers = phoneNumbers;
    }

    @Override
    public void run(){
        BackUp();
    }

    private static void BackUp() {
        ObjectOutputStream oos = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            if (fileOutputStream != null) {
                oos = new ObjectOutputStream(fileOutputStream);
                oos.writeObject(phoneNumbers.list);
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if(oos!=null) {
                try {
                    oos.close();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}

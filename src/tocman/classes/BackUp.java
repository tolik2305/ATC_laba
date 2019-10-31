package tocman.classes;

import java.io.*;

public class BackUp extends Thread {

    File file;
    PhoneNumbers phoneNumbers;

    public BackUp(String pathname, PhoneNumbers phoneNumbers){
        file = new File(pathname);
        this.phoneNumbers = phoneNumbers;
    }

    public void run(){
            while (true) {
                try {
                    Thread.sleep(10000);
                    System.out.println("BackUP");
                    BackUp(phoneNumbers);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }

    public void BackUp(PhoneNumbers phoneNumbers) {
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
        }
        finally {
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

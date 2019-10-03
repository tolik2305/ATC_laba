package tocman.classes;

import tocman.ClassMain;

import java.util.ArrayList;
import java.util.Scanner;

public class PhoneNumbers {

    Scanner scanner = new Scanner(System.in);

    ArrayList<PhoneNumber> list;

    int counter;

    public PhoneNumbers(){
        this.list = new ArrayList<>();
    }

    public PhoneNumbers(int length){
        this.list = new ArrayList<>(length);
    }

    public void add(PhoneNumber phoneNumber){
        list.add(phoneNumber);
    }

    String number;

    public void print(){
        for (PhoneNumber phoneNumber : list) {
            System.out.println("Номер: телефона: " + phoneNumber.number + "\nФ.И.О.: " + phoneNumber.fullName + "\nАдрес: " + phoneNumber.adress + '\n' + "Телефон: " + phoneNumber.typeTelephone + '\n');
        }
        backToMenu();
    }

    public void getDataByNumber(){
        System.out.println("Введите нужный номер телефона: ");
        number = scanner.next();
        counter=0;
        for (PhoneNumber phoneNumber: list) {
            if(number.equals(phoneNumber.number)){
                System.out.println("Номер: "+phoneNumber.number + "\nФ.И.О.: " + phoneNumber.fullName + "\nАдрес: " + phoneNumber.adress + '\n' + "Телефон: " + phoneNumber.typeTelephone + '\n');
                break;
            }
            else if(counter==list.size()-1){
                System.out.println("Номер не найден!!!");
            }
            counter++;
        }
        backToMenu();
    }


    public void getDataByFullName(){
        System.out.println("Введите фамилию абонента: ");
        String Surname = scanner.next();
        counter=0;
        for (PhoneNumber phoneNumber: list){
            if(phoneNumber.fullName!=null) {
                if (phoneNumber.fullName.contains(Surname)) {
                    System.out.println("Номер: " + phoneNumber.number + "\nФ.И.О.: " + phoneNumber.fullName + "\nАдрес: " + phoneNumber.adress + '\n' + "Телефон: " + phoneNumber.typeTelephone + '\n');
                }
                else if(counter==list.size()-1){
                    System.out.println("Абонент с такой фамилией не найден!!!");
                }
            }
            counter++;
        }
        backToMenu();
    }

    public void reassignementOfOwnership(){
        counter=0;
        System.out.println("Введите номер, которому хотите поменять владельца: ");
        number = scanner.next();
        scanner.nextLine();
        for (PhoneNumber phoneNumber: list) {
            if(number.equals(phoneNumber.number)){
                System.out.println("Введите Ф.И.О. нового владельца: ");
                phoneNumber.fullName = scanner.nextLine();
                System.out.println("Переименование успешно выполнено");
                break;
            }
            else if (counter==list.size()-1){
                System.out.println("Такой номер телефона не найден");
            }
            counter++;
        }
        backToMenu();
    }

    public void listOfAvailableNumbers(){
        for (PhoneNumber phoneNumber : this.list) {
            if (phoneNumber.fullName == null && phoneNumber.adress == null) {
                System.out.println("Номер: " + phoneNumber.number + "\nФ.И.О.: " + phoneNumber.fullName + "\nАдрес: " + phoneNumber.adress + '\n' + "Телефон: " + phoneNumber.typeTelephone + '\n');
            }
        }
        backToMenu();
    }


    public void backToMenu(){
        int result = -1;
        while (result<0||result>1) {
            System.out.println("Вернуться в меню? (1 - да, 0 - нет)");
            result = Integer.parseInt(scanner.next());
            if (result == 1) {
                ClassMain.Menu();
            }
        }
    }

}

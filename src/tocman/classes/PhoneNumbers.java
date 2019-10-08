package tocman.classes;

import tocman.ClassMain;

import java.util.ArrayList;
import java.util.Scanner;

public class PhoneNumbers {

    Scanner scanner = new Scanner(System.in);

    ArrayList<PhoneNumber> list;

    boolean isCorrectly = false;

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

    /**
     * Функция вывода на экран
     */
    public void print(){
        for (PhoneNumber phoneNumber : list) {
            System.out.println("Номер: телефона: " + phoneNumber.number + "\nФ.И.О.: " + phoneNumber.fullName + "\nАдрес: " + phoneNumber.adress + '\n' + "Телефон: " + phoneNumber.typeTelephone + '\n');
        }
        backToMenu();
    }

    /**
     * Функция поиска записи по номеру телефона
     */
    public void getDataByNumber(){
        System.out.println("Введите нужный номер телефона: ");
        number = scanner.next();
        while (!isCorrectly) {
            if (number.matches("[+][0-9]{12}")) {
                for (PhoneNumber phoneNumber : list) {
                    if (number.equals(phoneNumber.number)) {
                        System.out.println("Номер: " + phoneNumber.number + "\nФ.И.О.: " + phoneNumber.fullName + "\nАдрес: " + phoneNumber.adress + '\n' + "Телефон: " + phoneNumber.typeTelephone + '\n');
                        backToMenu();
                    }
                }
            }
        }
        System.out.println("Номер не найден!!!");
        backToMenu();
    }

    /**
     * Функция поиска записи по Фамилии абонента
     */
    public void getDataByFullName(){
        System.out.println("Введите фамилию абонента: ");
        String Surname = scanner.next();
        while (!isCorrectly) {
            if (Surname.matches("[А-Я][а-я]{3,}")) {
                for (PhoneNumber phoneNumber : list) {
                    if (phoneNumber.fullName != null) {
                        if (phoneNumber.fullName.contains(Surname)) {
                            System.out.println("Номер: " + phoneNumber.number + "\nФ.И.О.: " + phoneNumber.fullName + "\nАдрес: " + phoneNumber.adress + '\n' + "Телефон: " + phoneNumber.typeTelephone + '\n');
                            backToMenu();
                        }
                    }
                }
                System.out.println("Абонент с такой фамилией не найден!!!");
                backToMenu();
            }
        }
    }

    /**
     * Функция переименования владельца для определённого номера телефона
     */
    public void reassignementOfOwnership(){
        isCorrectly=false;
        System.out.println("Введите номер, которому хотите поменять владельца: ");
        number = scanner.next();
        scanner.nextLine();
        while(!isCorrectly) {
            if (number.matches("[+][0-9]{12}")) {
                for (PhoneNumber phoneNumber : list) {
                    if (number.equals(phoneNumber.number)) {
                        System.out.println("Введите Ф.И.О. нового владельца: ");
                        phoneNumber.fullName = scanner.nextLine();
                        System.out.println("Переименование успешно выполнено");
                        backToMenu();
                    }
                }
                System.out.println("Такой номер телефона не найден");
                backToMenu();
            }
        }
    }

    /**
     * Функция вывода списка свободных номеров
     */
    public void listOfAvailableNumbers(){
        for (PhoneNumber phoneNumber : this.list) {
            if (phoneNumber.fullName == null && phoneNumber.adress == null) {
                System.out.println("Номер: " + phoneNumber.number + "\nФ.И.О.: " + phoneNumber.fullName + "\nАдрес: " + phoneNumber.adress + '\n' + "Телефон: " + phoneNumber.typeTelephone + '\n');
            }
        }
        backToMenu();
    }


    /**
     * Функция возвращения в меню
     */
    public void backToMenu(){
        String result = "-1";
        while (result.equals("-1")) {
            System.out.println("Вернуться в меню? (1 - да, 0 - нет)");
            result = scanner.next();
            if (result.matches("[0-1]{1}") && result.equals("1")) {
                ClassMain.Menu();
            }
        }
    }

}

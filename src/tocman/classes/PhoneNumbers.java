package tocman.classes;

import tocman.ClassMain;

import java.util.Scanner;

public class PhoneNumbers {

    Scanner scanner = new Scanner(System.in);

    private PhoneNumber[] list;

    public PhoneNumbers(){
        PhoneNumber[] phoneNumber = new PhoneNumber[0];
    }

    /**
     * Создание списка на кол-во записей length
     * @param length кол-во записей в списке
     */
    public PhoneNumbers(final int length){
        this.list = new PhoneNumber[length];
    }

    /**
     *
     * @param phoneNumber сама запись
     * @param position позиция на которую добавляется запись
     */
    public void add(final PhoneNumber phoneNumber, final int position) {
        this.list[position-1] = phoneNumber;
    }

    String number;

    /**
     * Функция вывода списка на экран
     */
    public void print(){
        for (PhoneNumber phoneNumber : this.list) {
            System.out.println("Номер: телефона: " + phoneNumber.number + "\nФ.И.О.: " + phoneNumber.fullName + "\nАдрес: " + phoneNumber.adress + '\n' + "Телефон: " + phoneNumber.typeTelephone + '\n');
        }
        backToMenu();
    }

    /**
     * @param isCoorectly результат проверки на корректность вводимых данных
     */
    boolean isCorrectly=false;

    /**
     * Функция поиска записи по номеру телефона
     */
    public void getDataByNumber(){
        System.out.println("Введите нужный номер телефона: ");
        number = scanner.next();
        while (!isCorrectly) {
            if (number.matches("[+][0-9]{12}")) {
                isCorrectly = true;
                for (int i = 0; i < this.list.length; i++) {
                    if (number.equals(this.list[i].number)) {
                        System.out.println("Номер: " + this.list[i].number + "\nФ.И.О.: " + this.list[i].fullName + "\nАдрес: " + this.list[i].adress + '\n' + "Телефон: " + this.list[i].typeTelephone + '\n');
                        backToMenu();
                    } else if (i == this.list.length - 1) {
                        System.out.println("Номер не найден!");
                        backToMenu();
                    }
                }
            } else {
                System.out.println("Номер введён в неверном формате, повторите ввод: ");
                number = scanner.next();
                scanner.nextLine();
            }
        }
    }

    /**
     * Функция поиска записи по Фамилии абонента
     */
    public void getDataByFullName(){
        isCorrectly=false;
        System.out.println("Введите фамилию абонента: ");
        String Surname = scanner.next();
        while (!isCorrectly) {
            if (Surname.matches("[А-Я][а-я]{3,}")) {
                for (int i = 0; i < this.list.length; i++) {
                    if (this.list[i].fullName != null) {
                        if (this.list[i].fullName.contains(Surname)) {
                            isCorrectly=true;
                            System.out.println("Номер: " + this.list[i].number + "\nФ.И.О.: " + this.list[i].fullName + "\nАдрес: " + this.list[i].adress + '\n' + "Телефон: " + this.list[i].typeTelephone + '\n');
                            backToMenu();
                        }
                    } else if (i == this.list.length - 1) {
                        System.out.println("Такой абонент не найден");
                        backToMenu();
                    }
                }
            } else {
                System.out.println("Фамилия введена неверном формате, повторите ввод: ");
                Surname = scanner.next();
                scanner.nextLine();
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
                for (int i = 0; i < this.list.length; i++) {
                    if (number.equals(this.list[i].number)) {
                        System.out.println("Введите Ф.И.О. нового владельца: ");
                        isCorrectly=true;
                        this.list[i].fullName = scanner.nextLine();
                        System.out.println("Переименование успешно выполнено");
                        backToMenu();
                    }
                    else if (i == this.list.length - 1) {
                        System.out.println("Такой номер не найден в базе");
                        backToMenu();
                    }
                }
            }
            else {
                System.out.println("Номер введён в неверном формате, повторите ввод: ");
                number = scanner.next();
                scanner.nextLine();
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

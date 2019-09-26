package tocman.classes;

import tocman.Main;

import java.util.Arrays;
import java.util.Scanner;

public class PhoneNumbers {

    Scanner scanner = new Scanner(System.in);

    private PhoneNumber[] list;

    public PhoneNumber[] getList() {
        return list;
    }

    public PhoneNumbers(){
        PhoneNumber[] phoneNumber = new PhoneNumber[0];
    }

    public PhoneNumbers(int length){
        this.list = new PhoneNumber[length];
    }

    public void add(PhoneNumber phoneNumber, int position) {
        this.list[position-1] = phoneNumber;
    }

    String number;
    String surname;

    public boolean equals(PhoneNumber phoneNumber) {
        System.out.println("Проверка на совпадение: " + number + " == " + phoneNumber.number);
        return this.number ==  phoneNumber.number;
    }

    public void print(){
        for (int i=0;i<this.list.length;i++){
            System.out.println("Номер: телефона: "+this.list[i].number + "\nФ.И.О.: " + this.list[i].fullName + "\nАдрес: " + this.list[i].adress + '\n'+ "Телефон: "+this.list[i].typeTelephone + '\n');
        }
        backToMenu();
    }

    public void getDataByNumber(){
        System.out.println("Введите нужный номер телефона: ");
        number = scanner.next();
        for(int i = 0;i < this.list.length; i++){
            if(number.equals(this.list[i].number)){
                System.out.println("Номер: "+this.list[i].number + "\nФ.И.О.: " + this.list[i].fullName + "\nАдрес: " + this.list[i].adress + '\n' + "Телефон: " + this.list[i].typeTelephone + '\n');
                break;
            }
            else if(i == this.list.length-1){
                System.out.println("Номер не найден!");
            }
        }
        backToMenu();
    }

    public void getDataByFullName(){
        System.out.println("Введите фамилию абонента: ");
        boolean isFounded = false;
        String Surname = scanner.next();
        for (int i=0;i<this.list.length;i++){
            if(this.list[i].fullName!=null) {
                if (this.list[i].fullName.contains(Surname)) {
                    isFounded = true;
                    System.out.println("Номер: " + this.list[i].number + "\nФ.И.О.: " + this.list[i].fullName + "\nАдрес: " + this.list[i].adress + '\n' + "Телефон: " + this.list[i].typeTelephone + '\n');
                }
            }
            else if(i == this.list.length - 1&&!isFounded)
                System.out.println("Такой абонент не найден");
        }

        backToMenu();
    }

    public void reassignementOfOwnership(){
        boolean isFounded = false;
        System.out.println("Введите номер, которому хотите поменять владельца: ");
        number = scanner.next();
        scanner.nextLine();
        for(int i=0;i<this.list.length;i++){
            if(number.equals(this.list[i].number)){
                System.out.println("Введите Ф.И.О. нового владельца: ");
                isFounded = true;
                this.list[i].fullName = scanner.nextLine();
                System.out.println("Переименование успешно выполнено");
                break;
            }
            else if(i==this.list.length&&!isFounded)
                System.out.println("Такой номер не найден в базе");
        }
        backToMenu();
    }

    public void listOfAvailableNumbers(){
        for (int i = 0; i < this.list.length; i++){
            if(list[i].fullName == null&&list[i].adress == null){
                System.out.println("Номер: "+this.list[i].number + "\nФ.И.О.: " + this.list[i].fullName + "\nАдрес: " + this.list[i].adress + '\n' + "Телефон: " + this.list[i].typeTelephone + '\n');
            }
        }
        backToMenu();
    }

    public void backToMenu(){
        int result = -1;
        while (result<0||result>1) {
            System.out.println("Вернуться в меню? (1 - да, 0 - нет)");
            result = Integer.parseInt(scanner.next());
            if (result == 1)
                Main.Menu();
        }
    }

}

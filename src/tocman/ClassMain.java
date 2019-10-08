package tocman;

import tocman.classes.PhoneNumber;
import tocman.classes.PhoneNumbers;

import java.util.Scanner;

public class ClassMain {
    public static PhoneNumbers phoneNumbers;

    public static void main(final String[] args) {
        phoneNumbers = new PhoneNumbers(10);

        phoneNumbers.add(new PhoneNumber("+380685397284", PhoneNumber.Telephone.Неизвестно), 1);
        phoneNumbers.add(new PhoneNumber("+380996529404", "Петров Анатолий Васильевич", "г.Одесса, ул.Филатова, 37", PhoneNumber.Telephone.Мобильный), 2);
        phoneNumbers.add(new PhoneNumber("+380982292557", PhoneNumber.Telephone.Мобильный), 3);
        phoneNumbers.add(new PhoneNumber("+380677767677", "Иванов Иван Иванович", "г.Одесса, Старопортофранковская, 4б", PhoneNumber.Telephone.Домашний), 4);
        phoneNumbers.add(new PhoneNumber("+380977789987", PhoneNumber.Telephone.Неизвестно), 5);
        phoneNumbers.add(new PhoneNumber("+380933393393", "Петров Анатолий Фёдорович", "с.Виноградовка, ул.Ленина, 167", PhoneNumber.Telephone.Рабочий), 6);
        phoneNumbers.add(new PhoneNumber("+380959555955", "Иванов Пётр Петрович", "г.Киев, ул.Мира, 73г", PhoneNumber.Telephone.Мобильный), 7);
        phoneNumbers.add(new PhoneNumber("+380966669686", PhoneNumber.Telephone.Неизвестно), 8);
        phoneNumbers.add(new PhoneNumber("+380995939339", "Волков Иван Степанович", "г.Одесса, ул.Пестеля, 2а", PhoneNumber.Telephone.Неизвестно), 9);
        phoneNumbers.add(new PhoneNumber("+380995939333", PhoneNumber.Telephone.Неизвестно), 10);

        Menu();
    }

    /**
     * Основное меню
     */
    public static void Menu(){
        int menuNumber = 0;
        Scanner scanner = new Scanner(System.in);
        while(menuNumber==0){
            System.out.println("Выберите нужный пункт: " +
                    "\n1) Сведения об абоненте по его телефонному номеру" +
                    "\n2) Поиск телефонного номера по фамилии" +
                    "\n3) Изменение владельца телефонного номера" +
                    "\n4) Список свободных номеров" +
                    "\n5) Список всех номеров" +
                    "\n6) Выход" +
                    "\nВведите цифру нужного пункта и нажмите Enter: ");
            boolean isCorrectly = false;
            String str="";
            while (!isCorrectly) {
                str = scanner.next();
                if (str.equals("1")||str.equals("2")||str.equals("3")||str.equals("4")||str.equals("5")||str.equals("6")) {
                    isCorrectly = true;
                }
                else {
                    System.out.println("Введите корректное значение: ");
                }
            }
            menuNumber = Integer.parseInt(str);
            switch (menuNumber){
                case 1: phoneNumbers.getDataByNumber(); break;
                case 2: phoneNumbers.getDataByFullName(); break;
                case 3: phoneNumbers.reassignementOfOwnership(); break;
                case 4: phoneNumbers.listOfAvailableNumbers(); break;
                case 5: phoneNumbers.print(); break;
                case 6: System.exit(0); break;
                default: menuNumber=0;
            }
        }
    }
}

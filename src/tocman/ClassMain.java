package tocman;

import tocman.classes.PhoneNumber;
import tocman.classes.PhoneNumbers;
import tocman.classes.Serializator;

import java.io.InvalidObjectException;
import java.util.Scanner;

public class ClassMain {
    public static PhoneNumbers phoneNumbers;

    public static void main(final String[] args) {

        phoneNumbers = new PhoneNumbers(10);

//        phoneNumbers.add(new PhoneNumber("+380(68)539-72-84", PhoneNumber.Telephone.Неизвестно));
//        phoneNumbers.add(new PhoneNumber("+380(99)652-94-04", "Петров Анатолий Васильевич", "г.Одесса, ул.Филатова, 37", PhoneNumber.Telephone.Мобильный));
//        phoneNumbers.add(new PhoneNumber("+380(98)229-25-57", PhoneNumber.Telephone.Неизвестно));
//        phoneNumbers.add(new PhoneNumber("+380(67)776-76-77", "Иванов Иван Иванович", "г.Одесса, Старопортофранковская, 4б", PhoneNumber.Telephone.Домашний));
//        phoneNumbers.add(new PhoneNumber("+380(97)778-99-87", PhoneNumber.Telephone.Неизвестно));
//        phoneNumbers.add(new PhoneNumber("+380(93)339-33-93", "Петров Анатолий Фёдорович", "с.Виноградовка, ул.Ленина, 167", PhoneNumber.Telephone.Рабочий));
//        phoneNumbers.add(new PhoneNumber("+380(95)955-59-55", "Иванов Пётр Иванович", "г.Киев, ул.Мира, 73г", PhoneNumber.Telephone.Мобильный));
//        phoneNumbers.add(new PhoneNumber("+380(96)666-96-86", PhoneNumber.Telephone.Неизвестно));
//        phoneNumbers.add(new PhoneNumber("+380(99)593-93-33", PhoneNumber.Telephone.Неизвестно));
//        phoneNumbers.add(new PhoneNumber("+380(99)593-93-39", "Волков Иван Степанович", "г.Одесса, ул.Пестеля, 2а", PhoneNumber.Telephone.Неизвестно));

        Menu();
    }

    /**
     * Основное меню
     */
    public static void Menu(){
        int menuNumber;
        Scanner scanner = new Scanner(System.in);
        PhoneNumber phoneNumber = new PhoneNumber();
        Serializator serializator = new Serializator();
        while(true){
            System.out.println("Выберите нужный пункт: " +
                    "\n1) Сведения об абоненте по его телефонному номеру" +
                    "\n2) Поиск телефонного номера по фамилии" +
                    "\n3) Изменение владельца телефонного номера" +
                    "\n4) Список свободных номеров" +
                    "\n5) Список всех номеров" +
                    "\n6) Записать данные в файл" +
                    "\n7) Считать данные из файла" +
                    "\n0) Выход" +
                    "\nВведите цифру нужного пункта и нажмите Enter: ");
            boolean isCorrectly = false;
            String tempMenuNumber="";
            while (!isCorrectly) {
                tempMenuNumber = scanner.next();
                scanner.nextLine();
                if(tempMenuNumber.matches("[1-7,0]{1}")){
                    isCorrectly=true;
                }
                else {
                    System.out.println("Введите корректное значение: ");
                }
            }
            menuNumber = Integer.parseInt(tempMenuNumber);
            switch (menuNumber) {
                case 1: {
                    isCorrectly = false;
                    while (!isCorrectly) {
                        String number;
                        System.out.println("Введите нужный номер телефона в формате +Х(YY)ZZZ-ZZ-ZZ где вместо X - код страны, Y - код оператора, Z - номер телефона: ");
                        number = scanner.next();
                        if (number.matches("[+][0-9]{1,4}[(][0-9]{2}[)][0-9]{3}[-][0-9]{2}[-][0-9]{2}")) {
                            System.out.println(phoneNumbers.getDataByNumber(number));
                            isCorrectly = true;
                        } else {
                            System.out.println("Номер введён в неверном формате, повторите ввод: ");
                        }
                    }
                }
                break;
                case 2: {
                    isCorrectly = false;
                    while (!isCorrectly) {
                        System.out.println("Введите фамилию абонента: ");
                        String Surname = scanner.next();
                        if (Surname.matches("[А-Я][а-я]{2,}")) {
                            System.out.println(phoneNumbers.getDataByFullName(Surname));
                            isCorrectly = true;
                        } else {
                            System.out.println("Фамилия введена неверном формате, повторите ввод: ");
                        }
                    }
                }
                break;
                case 3: {
                    isCorrectly = false;
                    String number;
                    while (!isCorrectly) {
                        System.out.println("Введите номер, которому хотите поменять владельца: ");
                        number = scanner.next();
                        scanner.nextLine();
                        if (number.matches("[+][0-9]{1,4}[(][0-9]{2}[)][0-9]{3}[-][0-9]{2}[-][0-9]{2}")) {
                            if (phoneNumbers.IsInList(number)) {
                                System.out.println(phoneNumbers.getDataByNumber(number));
                                System.out.println("Введите Ф.И.О. нового владельца: ");
                                String fullname = scanner.nextLine();
                                phoneNumbers.reassignementOfOwnership(number, fullname);
                                isCorrectly = true;
                            }
                        } else {
                            System.out.println("Номер введён в неверном формате, повторите ввод: ");
                        }
                    }
                }
                break;
                case 4: {
                    System.out.println(phoneNumbers.listOfAvailableNumbers());
                } break;
                case 5: {
                    System.out.println(phoneNumbers.toString());
                } break;
                case 6: {
                    serializator.serialization(phoneNumbers);
                } break;
                case 7: {
                    try {
                        serializator.deserialization(phoneNumbers);
                        System.out.println(phoneNumbers.toString());
                    } catch (InvalidObjectException e) {
                        e.printStackTrace();
                    }
                } break;
                case 0: System.exit(0); break;
            }
        }
    }
}

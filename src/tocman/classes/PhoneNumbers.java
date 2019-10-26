package tocman.classes;

import java.util.ArrayList;

public class PhoneNumbers {

    public ArrayList<PhoneNumber> list;

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
    @Override
    public String toString() {
        String numbers = "";
        for (PhoneNumber phoneNumber: this.list) {
            numbers += ("Номер: " + phoneNumber.number + "\nФ.И.О.: " + phoneNumber.fullName + "\nАдрес: " + phoneNumber.adress + '\n' + "Телефон: " + phoneNumber.typeTelephone + '\n'+ '\n');
        }
        return numbers;
    }

    /**
     * Функция поиска записи по номеру телефона
     */
    public String getDataByNumber(String number) {
        for (PhoneNumber phoneNumber: this.list) {
            if (number.equals(phoneNumber.number)) {
                return "Номер: " + phoneNumber.number + "\nФ.И.О.: " + phoneNumber.fullName + "\nАдрес: " + phoneNumber.adress + '\n' + "Телефон: " + phoneNumber.typeTelephone + '\n';
            }
        }
        return "Номер не найден!";
    }

    /**
     * Функция поиска записи по Фамилии абонента
     */
    public String getDataByFullName(String surname) {
        for (PhoneNumber phoneNumber: this.list)
        {
            if (phoneNumber.fullName != null) {
                if (phoneNumber.fullName.contains(surname)) {
                    isCorrectly = true;
                    return "Номер: " + phoneNumber.number + "\nФ.И.О.: " + phoneNumber.fullName + "\nАдрес: " + phoneNumber.adress + '\n' + "Телефон: " + phoneNumber.typeTelephone + '\n';
                }
            }
        }
        return "Такой абонент не найден";
    }

    /**
     * Функция переименования владельца для определённого номера телефона
     */
    public String reassignementOfOwnership(String number, String fullname) {
        for (PhoneNumber phoneNumber:this.list) {
            if (number.equals(phoneNumber.number)) {
                phoneNumber.fullName = fullname;
                return "Переименование успешно выполнено";
            }
        }
        return "Такой номер не найден в базе";
    }

    /**
     * Проверка есть ли номер в списке
     * @param number номер телефона
     */
    public boolean IsInList(String number) {
        for (PhoneNumber phoneNumber:this.list){
            if (number.equals(phoneNumber.number)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Функция вывода списка свободных номеров
     */
    public String listOfAvailableNumbers() {
        String numbers = "";
        for (PhoneNumber phoneNumber : this.list) {
            if (phoneNumber.fullName == null && phoneNumber.adress == null) {
                numbers += "Номер: " + phoneNumber.number + "\nФ.И.О.: " + phoneNumber.fullName + "\nАдрес: " + phoneNumber.adress + '\n' + "Телефон: " + phoneNumber.typeTelephone + '\n'+ '\n';
            }
        }
        return numbers;
    }
}
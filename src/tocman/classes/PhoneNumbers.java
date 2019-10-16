package tocman.classes;

import tocman.ClassMain;

import java.util.Arrays;
import java.util.Scanner;

public class PhoneNumbers {

    private PhoneNumber[] list;

    public PhoneNumbers() {
        PhoneNumber[] phoneNumber = new PhoneNumber[0];
    }

    /**
     * Создание списка на кол-во записей length
     *
     * @param length кол-во записей в списке
     */
    public PhoneNumbers(final int length) {
        this.list = new PhoneNumber[length];
    }

    /**
     * @param phoneNumber сама запись
     * @param position    позиция на которую добавляется запись
     */
    public void add(final PhoneNumber phoneNumber, final int position) {
        this.list[position - 1] = phoneNumber;
    }

    /**
     * Функция вывода списка на экран
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
     * @param isCoorectly результат проверки на корректность вводимых данных
     */
    boolean isCorrectly = false;

    /**
     * Функция поиска записи по номеру телефона
     */
    public String getDataByNumber(String number) {
        for (int i = 0; i < this.list.length; i++) {
            if (number.equals(this.list[i].number)) {
                return "Номер: " + this.list[i].number + "\nФ.И.О.: " + this.list[i].fullName + "\nАдрес: " + this.list[i].adress + '\n' + "Телефон: " + this.list[i].typeTelephone + '\n';
            }
        }
        return "Номер не найден!";
    }

    /**
     * Функция поиска записи по Фамилии абонента
     */
    public String getDataByFullName(String surname) {
        for (int i = 0; i < this.list.length; i++) {
            if (this.list[i].fullName != null) {
                if (this.list[i].fullName.contains(surname)) {
                    isCorrectly = true;
                    return "Номер: " + this.list[i].number + "\nФ.И.О.: " + this.list[i].fullName + "\nАдрес: " + this.list[i].adress + '\n' + "Телефон: " + this.list[i].typeTelephone + '\n';
                }
            }
        }
        return "Такой абонент не найден";
    }

    /**
     * Функция переименования владельца для определённого номера телефона
     */
    public String reassignementOfOwnership(String number, String fullname) {
        for (int i = 0; i < this.list.length; i++) {
            if (number.equals(this.list[i].number)) {
                this.list[i].fullName = fullname;
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
        for (int i = 0; i < this.list.length; i++) {
            if (number.equals(this.list[i].number)) {
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
                numbers += "Номер: " + phoneNumber.number + "\nФ.И.О.: " + phoneNumber.fullName + "\nАдрес: " + phoneNumber.adress + '\n' + "Телефон: " + phoneNumber.typeTelephone + '\n';
            }
        }
        return numbers;
    }
}

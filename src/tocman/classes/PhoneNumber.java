package tocman.classes;

import java.io.Serializable;

public class PhoneNumber implements Serializable {

    String number;
    String fullName;
    String adress;

    public enum Telephone{
        Рабочий,
        Мобильный,
        Домашний,
        Неизвестно
    }

    Telephone typeTelephone;

    public PhoneNumber(){
    }

    public PhoneNumber(final String number, final String fullName, final String adress, final Telephone telephone){
        this.number = number;
        this.fullName = fullName;
        this.adress = adress;
        typeTelephone = telephone;
    }

    public PhoneNumber(final String number, final Telephone telephone){
        this.number = number;
        this.fullName = null;
        this.adress = null;
        typeTelephone = telephone;
    }
}

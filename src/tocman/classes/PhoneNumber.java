package tocman.classes;

public class PhoneNumber {

    String number;
    String fullName;
    String adress;

    public enum Telephone{
        Рабочий,
        Мобильный,
        Домашний,
        Неизвестно1
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

package tocman.classes;

public class PhoneNumber {

    String number;
    String fullName;
    String adress;

    public enum Telephone{
        Work,
        Home,
        Mobile,
        Unknown;
    }

    Telephone typeTelephone;

    public PhoneNumber(){
    }

    public PhoneNumber(String number, String fullName, String adress, Telephone telephone){
        this.number = number;
        this.fullName = fullName;
        this.adress = adress;
        typeTelephone = telephone;
    }

    public PhoneNumber(String number, Telephone telephone){
        this.number = number;
        this.fullName = null;
        this.adress = null;
        typeTelephone = telephone;
    }
}

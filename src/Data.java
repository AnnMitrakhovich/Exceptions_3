import java.util.Scanner;

public class Data {
    private String firstName;
    private String secondName;
    private String lastName;
    private String dateOfBirth;
    private long numberPhone;
    private String gender;

    public Data(String firstName, String secondName, String lastName, String dateOfBirth, long numberPhone, String gender) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.numberPhone = numberPhone;
        this.gender = gender;
    }
    public Data() {
        this("", "", "", "", 0, "");
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public long getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(long numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "<" + firstName + ">" +
                "<" + secondName + ">" +
                "<" + lastName + ">" +
                "<" + dateOfBirth + ">" +
                "<" + numberPhone + ">" +
                "<" + gender + ">";
    }
}

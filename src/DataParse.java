import Exceptions.ParsingDataExceptions;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataParse {
    private final Pattern namePattern;
    private final String datePattern;
    private final Pattern phonePattern;
    private final Pattern genderPattern;


    public DataParse(Pattern namePattern, String datePattern, Pattern phonePattern, Pattern genderPattern) {
        this.namePattern = namePattern;
        this.datePattern = datePattern;
        this.phonePattern = phonePattern;
        this.genderPattern = genderPattern;
    }

    public Data parsePersonDate(String data) throws ParsingDataExceptions {
        String[] partsInfo = data.split(" ");
        int countData = partsInfo.length;
        if (countData != 6) {
            throw new ParsingDataExceptions();
        }
        Data personData = new Data();
        if (isValidName(partsInfo[0]) & isValidName(partsInfo[1]) & isValidName(partsInfo[2])
                & isValidDateB(partsInfo[3]) & isValidPhone(partsInfo[4]) & isValidGender(partsInfo[5])) {
            personData.setFirstName(partsInfo[0]);
            personData.setSecondName(partsInfo[1]);
            personData.setLastName(partsInfo[2]);
            personData.setDateOfBirth(partsInfo[3]);
            personData.setNumberPhone(Long.parseLong(partsInfo[4]));
            personData.setGender(partsInfo[5]);
        } else {
            throw new ParsingDataExceptions();
        }
        return personData;
    }

    public boolean isValidName(String name) {
        String regexName = "^[а-яА-Яa-zA-Z]{2,}$"; // Шаблон для проверки ФИО. Любые буквы кирилицы или латиницы, не менее 2х
        Pattern p = Pattern.compile(regexName);
        Matcher m = p.matcher(name);
        return m.matches();
    }

    public boolean isValidDateB(String dateB) {
        String regexDate = "^(0?[1-9]|[12][0-9]|3[01])[.](0?[1-9]|1[012])[.](\\d{4})$"; // Дата рождения в формате dd.mm.yyyy
        Pattern p = Pattern.compile(regexDate);
        Matcher m = p.matcher(dateB);
        return m.matches();
    }

    public boolean isValidPhone(String phone) {
        String regexPhone = "^\\d{5,15}$"; // Шаблон телефонного номера, набор любых цифр длиной от 5 до 15 знаков
        Pattern p = Pattern.compile(regexPhone);
        Matcher m = p.matcher(phone);
        return m.matches();
    }

    public boolean isValidGender(String gender) {
        String regexGender = "^[fmFM]$"; // Шаблон для определения пола - любая из букв f или m независимо от регистра
        Pattern p = Pattern.compile(regexGender);
        Matcher m = p.matcher(gender);
        return m.matches();
    }

    // Проверим заполнение данными, если не все поля заполнены - выбасываем соответствующее исключение
    public void checkData(Data personData) {
        if (personData.getFirstName().isEmpty() || personData.getSecondName().isEmpty() || personData.getLastName().isEmpty()){
            throw new ParsingDataExceptions("Не заполнено ФИО");
        }
        if (personData.getDateOfBirth() == null){
            throw new ParsingDataExceptions("Не заполнена дата рождения");
        }

        if(personData.getGender().isEmpty()){
            throw new ParsingDataExceptions("Не заполнен пол");
        }
    }


}



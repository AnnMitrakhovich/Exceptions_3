import java.io.FileWriter;
import java.util.Scanner;

public class DataSave {
    private Data data;
    private DataParse parsedData;

    public void dataSave() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Фамилия Имя Отчество датарождения номертелефона пол");
        String data = scan.nextLine();
        DataParse parsedData = new DataParse();
        Data personData = parsedData.parsePersonDate(data);
        parsedData.checkData(personData);
        System.out.println(personData.toString());

        String file = personData.getFirstName() + ".txt";
        try (FileWriter fw = new FileWriter(file, true)) {
            fw.write(personData.toString() + "\n");
            fw.close();
        } catch (Exception e) {
            System.out.println("Ошибка записи файла");
        }
    }


}

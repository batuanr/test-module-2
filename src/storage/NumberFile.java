package storage;

import model.PhoneNumber;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class NumberFile {
    private static NumberFile numberFile;
    private final  String PHONE_NUMBER_FILE = "number.obj";

    private NumberFile() {
    }

    public static NumberFile getInstance(){
        if (numberFile == null){
            numberFile = new NumberFile();
        }
        return numberFile;
    }


    public List<PhoneNumber> readFile() throws IOException, ClassNotFoundException {
        List<PhoneNumber> phoneNumberList = new ArrayList<>();
        File file = new File(PHONE_NUMBER_FILE);
        if (!file.exists()){
            file.createNewFile();
        }
        if (file.length() >0){
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object object = objectInputStream.readObject();
            phoneNumberList = (List<PhoneNumber>) object;
            objectInputStream.close();
            fileInputStream.close();
            return phoneNumberList;
        }
        else return phoneNumberList;
    }
    public  void writeFile(List<PhoneNumber> phoneNumberList) throws IOException{
        FileOutputStream fileOutputStream = new FileOutputStream(PHONE_NUMBER_FILE);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(phoneNumberList);
        objectOutputStream.close();
        fileOutputStream.close();
    }
}

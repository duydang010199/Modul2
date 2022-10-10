package bai2;

import java.io.*;

public class SaveFileCSV {
    public static void main(String[] args) {
        String csvFile = "C:\\Users\\ADMIN\\OneDrive\\Máy tính\\Book2.csv";
        File file = new File(csvFile);
        String line = "";
        try{
            BufferedReader br = new BufferedReader(new FileReader(csvFile));
            line = br.readLine();//Read va loai bo dong 1
            while ((line = br.readLine()) != null && !line.isEmpty()){
                String fields[] = line.split(",");
                System.out.println("id: " + fields[0] + " code: " + fields[1] + " name: " + fields[2]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException eio) {
            eio.printStackTrace();
        }
    }
}

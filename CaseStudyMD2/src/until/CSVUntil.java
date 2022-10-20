package until;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVUntil {
    public static List<String> readFile(String path) {
        List<String> lines = new ArrayList<>();
        try {
            File file = new File(path);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null)
            {
                if(!line.trim().isEmpty()){
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(path + " không có dữ liệu.");
        }
        return lines;
    }
    public static <T> void writeFile(String fileName, List<T> item){
        try{
            PrintWriter printWriter = new PrintWriter(fileName);
            for (Object items: item){
                printWriter.write(items.toString());
                printWriter.println();
            }
            printWriter.flush();
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}

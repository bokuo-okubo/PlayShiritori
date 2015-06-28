package helpers;

import java.io.*;

/**
 * Created by bko on 6/28/15.
 */
public class FileHandler {

    public String openFile(String filePath) throws FileNotFoundException {
        String rtnStr = "";
        try {
            File file = new File(filePath);
            BufferedReader br = new BufferedReader(new FileReader(file));

            String str;
            while ((str = br.readLine()) != null) {
                rtnStr = rtnStr + str;
            }

            br.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
        return rtnStr;
    }
}

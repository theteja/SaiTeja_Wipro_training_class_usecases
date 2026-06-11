package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CsvUtil {

    public static Object[][] getCsvData() throws Exception {

        String path = System.getProperty("user.dir")
                + "\\src\\test\\resources\\testdata\\LoginData.csv";

        System.out.println("Reading CSV : " + path);

        List<Object[]> data = new ArrayList<>();

        BufferedReader br = new BufferedReader(
                new FileReader(path));

        String line;

        br.readLine(); // Skip header

        while ((line = br.readLine()) != null) {

            String[] values = line.split(",");

            data.add(new Object[] {
                    values[0].trim(),
                    values[1].trim()
            });
        }

        br.close();

        return data.toArray(new Object[0][]);
    }
}
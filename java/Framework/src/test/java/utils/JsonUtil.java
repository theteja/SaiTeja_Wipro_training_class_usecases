package utils;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonUtil {

    public static Object[][] getJsonData() throws Exception {

        String path = System.getProperty("user.dir")
                + "\\src\\test\\resources\\testdata\\LoginData.json";

        System.out.println("Reading JSON : " + path);

        String content =
                new String(Files.readAllBytes(Paths.get(path)));

        JSONArray array =
                new JSONArray(content);

        Object[][] data =
                new Object[array.length()][2];

        for (int i = 0; i < array.length(); i++) {

            JSONObject obj =
                    array.getJSONObject(i);

            data[i][0] =
                    obj.getString("username");

            data[i][1] =
                    obj.getString("password");
        }

        return data;
    }
}
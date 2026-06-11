package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.DataProvider;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class JsonDataProvider {

    @DataProvider(name = "loginData")
    public static Object[][] getLoginData() throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        InputStream inputStream =
                JsonDataProvider.class.getClassLoader()
                        .getResourceAsStream("testdata/users.json");

        List<Map<String, String>> users =
                mapper.readValue(inputStream,
                        new TypeReference<List<Map<String, String>>>() {});

        Object[][] data = new Object[users.size()][3];

        for (int i = 0; i < users.size(); i++) {

            data[i][0] = users.get(i).get("username");
            data[i][1] = users.get(i).get("password");
            data[i][2] = users.get(i).get("expectedResult");
        }

        return data;
    }
}
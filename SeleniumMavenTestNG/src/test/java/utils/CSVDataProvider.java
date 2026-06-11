package utils;

import com.opencsv.CSVReader;
import org.testng.annotations.DataProvider;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CSVDataProvider {

    @DataProvider(name = "loginData")
    public static Object[][] getData() throws Exception {

        InputStream inputStream =
                CSVDataProvider.class.getClassLoader()
                        .getResourceAsStream("testdata/loginData-1.csv");

        CSVReader reader =
                new CSVReader(new InputStreamReader(inputStream));

        List<String[]> records = reader.readAll();

        List<Object[]> data = new ArrayList<>();

        // Skip header row
        for (int i = 1; i < records.size(); i++) {

            String[] row = records.get(i);

            data.add(new Object[]{
                    row[0],
                    row[1],
                    row[2]
            });
        }

        return data.toArray(new Object[0][]);
    }
}
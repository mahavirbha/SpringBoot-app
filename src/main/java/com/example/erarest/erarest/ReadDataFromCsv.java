package com.example.erarest.erarest;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.json.simple.JSONObject;

public class ReadDataFromCsv {
    public static String readDataFromCsv(long binValue) throws IOException, CsvException {
        String s = "";
        String fileName = "F:\\visaProject\\MC-SBART\\latest.csv";
        try (CSVReader reader = new CSVReader(new FileReader(fileName))) {

            List<String[]> rows = reader.readAll();
            List<String> data = new ArrayList<String>();
            boolean flag = true;
            JSONObject jsonObject = new JSONObject();
            for (String[] row : rows) {
                if (flag) {
                    flag = false;
                    continue;
                }

                if (Long.parseLong(row[2]) <= binValue && Long.parseLong(row[3]) >= binValue) {
                    for (int i = 0; i < row.length; i++) {
                        data.add(row[i]);
                        // jsonObject.put(i, row[i]);
                        // 6 - card brand
                        // 7 - country(card domicile)
                        // 5 - Card Type
                        // 0 - Company Name
                        if (i == 6) {
                            jsonObject.put("Card Brand", row[i]);
                        } else if (i == 7) {
                            jsonObject.put("Card Domicile", row[i]);
                            s = row[i];
                        } else if (i == 5) {
                            jsonObject.put("Card Type", row[i]);
                        } else if (i == 0) {
                            jsonObject.put("Company Name", row[i]);

                        }
                    }
                    break;
                }

            }
            FileWriter file = new FileWriter("F:\\visaProject\\MC-SBART\\output.json");
            file.write(jsonObject.toJSONString());
            file.close();
            String path = "F:\\visaProject\\MC-SBART\\output.json";
            try {
                String content = Files.readString(Paths.get(path));
                s = content + "<" + s;
                System.out.println(content);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // return '"' + s + '"';
        return s;
    }

}

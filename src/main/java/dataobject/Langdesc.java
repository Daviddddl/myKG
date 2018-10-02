package dataobject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Langdesc {
    private String factorCode;
    private String description;

    public Langdesc(String factorCode, String description) {
        this.factorCode = factorCode;
        this.description = description;
    }

    public String getFactorCode() {
        return factorCode;
    }

    public void setFactorCode(String factorCode) {
        this.factorCode = factorCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static List<Langdesc> getAllLangdescList() throws IOException {

        String srcPath = "src/main/java/data/SR-Leg_ASC/LANGDESC.txt";

        List<Langdesc> langdescList = new ArrayList<>();
        FileInputStream inputStream = new FileInputStream(srcPath);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String strObj;
        while ((strObj = bufferedReader.readLine()) != null){
            strObj = Pattern.compile("\\^").matcher(strObj).replaceAll(" \\^ ");
            strObj = Pattern.compile("[\\pP]").matcher(strObj).replaceAll(" ");
            String[] strs = strObj.split("\\^");
            Langdesc langdesc = new Langdesc(strs[0], strs[1]);
            langdescList.add(langdesc);
        }
        return langdescList;
    }
}

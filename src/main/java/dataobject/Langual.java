package dataobject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Langual {
    private String ndbNo;
    private String factorCode;

    public Langual(String ndbNo, String factorCode) {
        this.ndbNo = ndbNo;
        this.factorCode = factorCode;
    }

    public String getNdbNo() {
        return ndbNo;
    }

    public void setNdbNo(String ndbNo) {
        this.ndbNo = ndbNo;
    }

    public String getFactorCode() {
        return factorCode;
    }

    public void setFactorCode(String factorCode) {
        this.factorCode = factorCode;
    }

    public static List<Langual> getAllLangualList() throws IOException {

        String srcPath = "src/main/java/data/SR-Leg_ASC/LANGUAL.txt";

        List<Langual> langualList = new ArrayList<>();
        FileInputStream inputStream = new FileInputStream(srcPath);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String strObj;
        while ((strObj = bufferedReader.readLine()) != null){
            strObj = Pattern.compile("\\^").matcher(strObj).replaceAll(" \\^ ");
            strObj = Pattern.compile("[\\pP]").matcher(strObj).replaceAll(" ");
            String[] strs = strObj.split("\\^");
            Langual langual = new Langual(strs[0], strs[1]);
            langualList.add(langual);
        }
        return langualList;
    }

}

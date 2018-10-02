package dataobject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class NutrDef {
    private String nutrNo;
    private String units;
    private String tagname;
    private String nutrDesc;
    private String numDec;
    private String srOrder;

    public NutrDef(String nutrNo, String units, String tagname, String nutrDesc, String numDec, String srOrder) {
        this.nutrNo = nutrNo;
        this.units = units;
        this.tagname = tagname;
        this.nutrDesc = nutrDesc;
        this.numDec = numDec;
        this.srOrder = srOrder;
    }

    public String getNutrNo() {
        return nutrNo;
    }

    public void setNutrNo(String nutrNo) {
        this.nutrNo = nutrNo;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String getTagname() {
        return tagname;
    }

    public void setTagname(String tagname) {
        this.tagname = tagname;
    }

    public String getNutrDesc() {
        return nutrDesc;
    }

    public void setNutrDesc(String nutrDesc) {
        this.nutrDesc = nutrDesc;
    }

    public String getNumDec() {
        return numDec;
    }

    public void setNumDec(String numDec) {
        this.numDec = numDec;
    }

    public String getSrOrder() {
        return srOrder;
    }

    public void setSrOrder(String srOrder) {
        this.srOrder = srOrder;
    }

    public static List<NutrDef> getAllNutrDefList() throws IOException {

        String srcPath = "src/main/java/data/SR-Leg_ASC/NUTR_DEF.txt";

        List<NutrDef> nutrDefList = new ArrayList<>();
        FileInputStream inputStream = new FileInputStream(srcPath);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String strObj;
        while ((strObj = bufferedReader.readLine()) != null){
            strObj = Pattern.compile("\\^").matcher(strObj).replaceAll(" \\^ ");
            strObj = Pattern.compile("[\\pP]").matcher(strObj).replaceAll(" ");
            String[] strs = strObj.split("\\^");
            NutrDef nutrDef = new NutrDef(strs[0], strs[1], strs[2], strs[3], strs[4], strs[5]);
            nutrDefList.add(nutrDef);
        }
        return nutrDefList;
    }


}

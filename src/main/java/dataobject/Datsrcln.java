package dataobject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Datsrcln {
    private String ndbNo;
    private String nutrNo;
    private String dataSrcId;

    public Datsrcln(String ndbNo, String nutrNo, String dataSrcId) {
        this.ndbNo = ndbNo;
        this.nutrNo = nutrNo;
        this.dataSrcId = dataSrcId;
    }

    public String getNdbNo() {
        return ndbNo;
    }

    public void setNdbNo(String ndbNo) {
        this.ndbNo = ndbNo;
    }

    public String getNutrNo() {
        return nutrNo;
    }

    public void setNutrNo(String nutrNo) {
        this.nutrNo = nutrNo;
    }

    public String getDataSrcId() {
        return dataSrcId;
    }

    public void setDataSrcId(String dataSrcId) {
        this.dataSrcId = dataSrcId;
    }

    public static List<Datsrcln> getAllDatsrclnList() throws IOException {

        String srcPath = "src/main/java/data/SR-Leg_ASC/DATSRCLN.txt";

        List<Datsrcln> datsrclnList = new ArrayList<>();
        FileInputStream inputStream = new FileInputStream(srcPath);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String strObj;
        while ((strObj = bufferedReader.readLine()) != null){
            strObj = Pattern.compile("\\^").matcher(strObj).replaceAll(" \\^ ");
            strObj = Pattern.compile("[\\pP]").matcher(strObj).replaceAll(" ");
            String[] strs = strObj.split("\\^");
            Datsrcln datsrcln = new Datsrcln(strs[0], strs[1], strs[2]);
            datsrclnList.add(datsrcln);
        }
        return datsrclnList;
    }
}

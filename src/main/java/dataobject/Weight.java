package dataobject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Weight {
    private String ndbNo;
    private String seq;
    private String amount;
    private String msreDesc;
    private String gmWgt;
    private String numDataPts;
    private String stdDev;

    public Weight(String ndbNo, String seq, String amount, String msreDesc, String gmWgt, String numDataPts, String stdDev) {
        this.ndbNo = ndbNo;
        this.seq = seq;
        this.amount = amount;
        this.msreDesc = msreDesc;
        this.gmWgt = gmWgt;
        this.numDataPts = numDataPts;
        this.stdDev = stdDev;
    }

    public String getNdbNo() {
        return ndbNo;
    }

    public void setNdbNo(String ndbNo) {
        this.ndbNo = ndbNo;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getMsreDesc() {
        return msreDesc;
    }

    public void setMsreDesc(String msreDesc) {
        this.msreDesc = msreDesc;
    }

    public String getGmWgt() {
        return gmWgt;
    }

    public void setGmWgt(String gmWgt) {
        this.gmWgt = gmWgt;
    }

    public String getNumDataPts() {
        return numDataPts;
    }

    public void setNumDataPts(String numDataPts) {
        this.numDataPts = numDataPts;
    }

    public String getStdDev() {
        return stdDev;
    }

    public void setStdDev(String stdDev) {
        this.stdDev = stdDev;
    }

    public static List<Weight> getAllWeightList() throws IOException {

        String srcPath = "src/main/java/data/SR-Leg_ASC/WEIGHT.txt";

        List<Weight> weightList = new ArrayList<>();
        FileInputStream inputStream = new FileInputStream(srcPath);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String strObj;
        while ((strObj = bufferedReader.readLine()) != null){
            strObj = Pattern.compile("\\^").matcher(strObj).replaceAll(" \\^ ");
            strObj = Pattern.compile("[\\pP]").matcher(strObj).replaceAll(" ");
            String[] strs = strObj.split("\\^");
            Weight weight = new Weight(strs[0], strs[1], strs[2], strs[3], strs[4], strs[5], strs[6]);
            weightList.add(weight);
        }
        return weightList;
    }

}

package dataobject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class NutData {

    private String ndbNo;
    private String nutrNo;
    private String nutrVal;
    private String numDataPts;
    private String stdError;
    private String srcCd;
    private String derivCd;
    private String refNdbNo;
    private String addNutrMark;
    private String numStudies;
    private String min;
    private String max;
    private String df;
    private String lowEb;
    private String upEb;
    private String statCmt;
    private String addmodDate;

    public NutData(String ndbNo, String nutrNo, String nutrVal, String numDataPts, String stdError, String srcCd, String derivCd, String refNdbNo, String addNutrMark, String numStudies, String min, String max, String df, String lowEb, String upEb, String statCmt, String addmodDate) {
        this.ndbNo = ndbNo;
        this.nutrNo = nutrNo;
        this.nutrVal = nutrVal;
        this.numDataPts = numDataPts;
        this.stdError = stdError;
        this.srcCd = srcCd;
        this.derivCd = derivCd;
        this.refNdbNo = refNdbNo;
        this.addNutrMark = addNutrMark;
        this.numStudies = numStudies;
        this.min = min;
        this.max = max;
        this.df = df;
        this.lowEb = lowEb;
        this.upEb = upEb;
        this.statCmt = statCmt;
        this.addmodDate = addmodDate;
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

    public String getNutrVal() {
        return nutrVal;
    }

    public void setNutrVal(String nutrVal) {
        this.nutrVal = nutrVal;
    }

    public String getNumDataPts() {
        return numDataPts;
    }

    public void setNumDataPts(String numDataPts) {
        this.numDataPts = numDataPts;
    }

    public String getStdError() {
        return stdError;
    }

    public void setStdError(String stdError) {
        this.stdError = stdError;
    }

    public String getSrcCd() {
        return srcCd;
    }

    public void setSrcCd(String srcCd) {
        this.srcCd = srcCd;
    }

    public String getDerivCd() {
        return derivCd;
    }

    public void setDerivCd(String derivCd) {
        this.derivCd = derivCd;
    }

    public String getRefNdbNo() {
        return refNdbNo;
    }

    public void setRefNdbNo(String refNdbNo) {
        this.refNdbNo = refNdbNo;
    }

    public String getAddNutrMark() {
        return addNutrMark;
    }

    public void setAddNutrMark(String addNutrMark) {
        this.addNutrMark = addNutrMark;
    }

    public String getNumStudies() {
        return numStudies;
    }

    public void setNumStudies(String numStudies) {
        this.numStudies = numStudies;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public String getDf() {
        return df;
    }

    public void setDf(String df) {
        this.df = df;
    }

    public String getLowEb() {
        return lowEb;
    }

    public void setLowEb(String lowEb) {
        this.lowEb = lowEb;
    }

    public String getUpEb() {
        return upEb;
    }

    public void setUpEb(String upEb) {
        this.upEb = upEb;
    }

    public String getStatCmt() {
        return statCmt;
    }

    public void setStatCmt(String statCmt) {
        this.statCmt = statCmt;
    }

    public String getAddmodDate() {
        return addmodDate;
    }

    public void setAddmodDate(String addmodDate) {
        this.addmodDate = addmodDate;
    }

    public static List<NutData> getAllNutDataList() throws IOException {

        String srcPath = "src/main/java/data/SR-Leg_ASC/NUT_DATA.txt";

        List<NutData> nutDataList = new ArrayList<>();
        FileInputStream inputStream = new FileInputStream(srcPath);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String strObj;
        while ((strObj = bufferedReader.readLine()) != null){
            strObj = Pattern.compile("\\^").matcher(strObj).replaceAll(" \\^ ");
            strObj = Pattern.compile("[\\pP]").matcher(strObj).replaceAll(" ");
            String[] strs = strObj.split("\\^");
            NutData nutData = new NutData(strs[0], strs[1], strs[2], strs[3], strs[4], strs[5], strs[6], strs[7], strs[8], strs[9], strs[10], strs[11], strs[12], strs[13], strs[14], strs[15], strs[16]);
            nutDataList.add(nutData);
        }
        return nutDataList;
    }

}

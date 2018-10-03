package dataobject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FoodDes {

    private String ndbNo;
    private String fdGrpCd;
    private String longDesc;
    private String shrtDesc;
    private String comName;
    private String manufacName;
    private String survey;
    private String refDesc;
    private String refuse;
    private String sciName;
    private String nFactor;
    private String proFactor;
    private String fatFactor;
    private String choFactor;

    public String getNdbNo() {
        return ndbNo;
    }

    public void setNdbNo(String ndbNo) {
        this.ndbNo = ndbNo;
    }

    public String getFdGrpCd() {
        return fdGrpCd;
    }

    public void setFdGrpCd(String fdGrpCd) {
        this.fdGrpCd = fdGrpCd;
    }

    public String getLongDesc() {
        return longDesc;
    }

    public void setLongDesc(String longDesc) {
        this.longDesc = longDesc;
    }

    public String getShrtDesc() {
        return shrtDesc;
    }

    public void setShrtDesc(String shrtDesc) {
        this.shrtDesc = shrtDesc;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getManufacName() {
        return manufacName;
    }

    public void setManufacName(String manufacName) {
        this.manufacName = manufacName;
    }

    public String getSurvey() {
        return survey;
    }

    public void setSurvey(String survey) {
        this.survey = survey;
    }

    public String getRefDesc() {
        return refDesc;
    }

    public void setRefDesc(String refDesc) {
        this.refDesc = refDesc;
    }

    public String getRefuse() {
        return refuse;
    }

    public void setRefuse(String refuse) {
        this.refuse = refuse;
    }

    public String getSciName() {
        return sciName;
    }

    public void setSciName(String sciName) {
        this.sciName = sciName;
    }

    public String getNFactor() {
        return nFactor;
    }

    public void setNFactor(String nFactor) {
        this.nFactor = nFactor;
    }

    public String getProFactor() {
        return proFactor;
    }

    public void setProFactor(String proFactor) {
        this.proFactor = proFactor;
    }

    public String getFatFactor() {
        return fatFactor;
    }

    public void setFatFactor(String fatFactor) {
        this.fatFactor = fatFactor;
    }

    public String getChoFactor() {
        return choFactor;
    }

    public void setChoFactor(String choFactor) {
        this.choFactor = choFactor;
    }

    public FoodDes(String ndbNo, String fdGrpCd, String longDesc, String shrtDesc, String comName, String manufacName, String survey, String refDesc, String refuse, String sciName, String nFactor, String proFactor, String fatFactor, String choFactor) {
        this.ndbNo = ndbNo;
        this.fdGrpCd = fdGrpCd;
        this.longDesc = longDesc;
        this.shrtDesc = shrtDesc;
        this.comName = comName;
        this.manufacName = manufacName;
        this.survey = survey;
        this.refDesc = refDesc;
        this.refuse = refuse;
        this.sciName = sciName;
        this.nFactor = nFactor;
        this.proFactor = proFactor;
        this.fatFactor = fatFactor;
        this.choFactor = choFactor;
    }

    public static List<FoodDes> getAllFoodDesList() throws IOException {

        String srcPath = "src/main/java/data/SR-Leg_ASC/FOOD_DES.txt";

        List<FoodDes> foodDesList = new ArrayList<>();
        FileInputStream inputStream = new FileInputStream(srcPath);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String strObj;
        while ((strObj = bufferedReader.readLine()) != null){
            strObj = Pattern.compile("\\^").matcher(strObj).replaceAll(" \\^ ");
            strObj = Pattern.compile("[\\pP]").matcher(strObj).replaceAll(" ");
            String[] strs = strObj.split("\\^");
            FoodDes foodDes = new FoodDes(strs[0], strs[1], strs[2], strs[3], strs[4], strs[5], strs[6], strs[7], strs[8], strs[9], strs[10], strs[11], strs[12], strs[13]);
            foodDesList.add(foodDes);
        }
        return foodDesList;
    }
}

package dataobject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Footnote {
    private String ndbNo;
    private String footntNo;
    private String footntTyp;
    private String nutrNo;
    private String footntTxt;

    public Footnote(String ndbNo, String footntNo, String footntTyp, String nutrNo, String footntTxt) {
        this.ndbNo = ndbNo;
        this.footntNo = footntNo;
        this.footntTyp = footntTyp;
        this.nutrNo = nutrNo;
        this.footntTxt = footntTxt;
    }

    public String getNdbNo() {
        return ndbNo;
    }

    public void setNdbNo(String ndbNo) {
        this.ndbNo = ndbNo;
    }

    public String getFootntNo() {
        return footntNo;
    }

    public void setFootntNo(String footntNo) {
        this.footntNo = footntNo;
    }

    public String getFootntTyp() {
        return footntTyp;
    }

    public void setFootntTyp(String footntTyp) {
        this.footntTyp = footntTyp;
    }

    public String getNutrNo() {
        return nutrNo;
    }

    public void setNutrNo(String nutrNo) {
        this.nutrNo = nutrNo;
    }

    public String getFootntTxt() {
        return footntTxt;
    }

    public void setFootntTxt(String footntTxt) {
        this.footntTxt = footntTxt;
    }

    public static List<Footnote> getAllFootnoteList() throws IOException {

        String srcPath = "src/main/java/data/SR-Leg_ASC/FOOTNOTE.txt";

        List<Footnote> FootnoteList = new ArrayList<>();
        FileInputStream inputStream = new FileInputStream(srcPath);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String strObj;
        while ((strObj = bufferedReader.readLine()) != null){
            strObj = Pattern.compile("\\^").matcher(strObj).replaceAll(" \\^ ");
            strObj = Pattern.compile("[\\pP]").matcher(strObj).replaceAll(" ");
            String[] strs = strObj.split("\\^");
            Footnote Footnote = new Footnote(strs[0], strs[1], strs[2], strs[3], strs[4]);
            FootnoteList.add(Footnote);
        }
        return FootnoteList;
    }
}

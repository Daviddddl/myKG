package dataobject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class DerivCd {
    private String derivCd;
    private String derivDesc;

    public String getDerivCd() {
        return derivCd;
    }

    public void setDerivCd(String derivCd) {
        this.derivCd = derivCd;
    }

    public String getDerivDesc() {
        return derivDesc;
    }

    public void setDerivDesc(String derivDesc) {
        this.derivDesc = derivDesc;
    }

    public DerivCd(String derivCd, String derivDesc) {
        this.derivCd = derivCd;
        this.derivDesc = derivDesc;
    }

    public static List<DerivCd> getAllDerivCdList() throws IOException {

        String srcPath = "src/main/java/data/SR-Leg_ASC/DERIV_CD.txt";

        List<DerivCd> derivCdList = new ArrayList<>();
        FileInputStream inputStream = new FileInputStream(srcPath);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String strObj;
        while ((strObj = bufferedReader.readLine()) != null){
            strObj = Pattern.compile("\\^").matcher(strObj).replaceAll(" \\^ ");
            strObj = Pattern.compile("[\\pP]").matcher(strObj).replaceAll(" ");
            String[] strs = strObj.split("\\^");
            DerivCd derivCd = new DerivCd(strs[0], strs[1]);
            derivCdList.add(derivCd);
        }
        return derivCdList;
    }
}

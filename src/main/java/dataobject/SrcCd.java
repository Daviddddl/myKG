package dataobject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class SrcCd {
    private String srcCd;
    private String srcCdDesc;

    public SrcCd(String srcCd, String srcCdDesc) {
        this.srcCd = srcCd;
        this.srcCdDesc = srcCdDesc;
    }

    public String getSrcCd() {
        return srcCd;
    }

    public void setSrcCd(String srcCd) {
        this.srcCd = srcCd;
    }

    public String getSrcCdDesc() {
        return srcCdDesc;
    }

    public void setSrcCdDesc(String srcCdDesc) {
        this.srcCdDesc = srcCdDesc;
    }

    public static List<SrcCd> getAllSrcCdList() throws IOException {

        String srcPath = "src/main/java/data/SR-Leg_ASC/SRC_CD.txt";

        List<SrcCd> srcCdList = new ArrayList<>();
        FileInputStream inputStream = new FileInputStream(srcPath);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String strObj;
        while ((strObj = bufferedReader.readLine()) != null){
            strObj = Pattern.compile("\\^").matcher(strObj).replaceAll(" \\^ ");
            strObj = Pattern.compile("[\\pP]").matcher(strObj).replaceAll(" ");
            String[] strs = strObj.split("\\^");
            SrcCd srcCd = new SrcCd(strs[0], strs[1]);
            srcCdList.add(srcCd);
        }
        return srcCdList;
    }

}

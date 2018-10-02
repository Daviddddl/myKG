package dataobject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class FdGroup {
    private String fdGrpCd;
    private String fdGrpDesc;

    public FdGroup(String fdGrpCd, String fdGrpDesc) {
        this.fdGrpCd = fdGrpCd;
        this.fdGrpDesc = fdGrpDesc;
    }

    public String getFdGrpCd() {
        return fdGrpCd;
    }

    public void setFdGrpCd(String fdGrpCd) {
        this.fdGrpCd = fdGrpCd;
    }

    public String getFdGrpDesc() {
        return fdGrpDesc;
    }

    public void setFdGrpDesc(String fdGrpDesc) {
        this.fdGrpDesc = fdGrpDesc;
    }

    public static List<FdGroup> getAllFdGroupList() throws IOException {

        String srcPath = "src/main/java/data/SR-Leg_ASC/FD_GROUP.txt";

        List<FdGroup> fdGroupList = new ArrayList<>();
        FileInputStream inputStream = new FileInputStream(srcPath);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String strObj;
        while ((strObj = bufferedReader.readLine()) != null){
            strObj = Pattern.compile("\\^").matcher(strObj).replaceAll(" \\^ ");
            strObj = Pattern.compile("[\\pP]").matcher(strObj).replaceAll(" ");
            String[] strs = strObj.split("\\^");
            FdGroup fdGroup = new FdGroup(strs[0], strs[1]);
            fdGroupList.add(fdGroup);
        }
        return fdGroupList;
    }
}

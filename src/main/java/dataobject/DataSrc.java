package dataobject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class DataSrc {
    private String dataSrcId;
    private String authors;
    private String title;
    private String year;
    private String journal;
    private String volCity;
    private String issueState;
    private String startPage;
    private String endPage;

    public DataSrc(String dataSrcId, String authors, String title, String year, String journal, String volCity, String issueState, String startPage, String endPage) {
        this.dataSrcId = dataSrcId;
        this.authors = authors;
        this.title = title;
        this.year = year;
        this.journal = journal;
        this.volCity = volCity;
        this.issueState = issueState;
        this.startPage = startPage;
        this.endPage = endPage;
    }

    public String getDataSrcId() {
        return dataSrcId;
    }

    public void setDataSrcId(String dataSrcId) {
        this.dataSrcId = dataSrcId;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public String getVolCity() {
        return volCity;
    }

    public void setVolCity(String volCity) {
        this.volCity = volCity;
    }

    public String getIssueState() {
        return issueState;
    }

    public void setIssueState(String issueState) {
        this.issueState = issueState;
    }

    public String getStartPage() {
        return startPage;
    }

    public void setStartPage(String startPage) {
        this.startPage = startPage;
    }

    public String getEndPage() {
        return endPage;
    }

    public void setEndPage(String endPage) {
        this.endPage = endPage;
    }

    public static List<DataSrc> getAllDataSrcList() throws IOException {

        String srcPath = "src/main/java/data/SR-Leg_ASC/DATA_SRC.txt";

        List<DataSrc> dataSrcList = new ArrayList<>();
        FileInputStream inputStream = new FileInputStream(srcPath);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String strObj;
        while ((strObj = bufferedReader.readLine()) != null){
            strObj = Pattern.compile("\\^").matcher(strObj).replaceAll(" \\^ ");
            strObj = Pattern.compile("[\\pP]").matcher(strObj).replaceAll(" ");
            String[] strs = strObj.split("\\^");
            DataSrc dataSrc = new DataSrc(strs[0], strs[1], strs[2], strs[3], strs[4], strs[5], strs[6], strs[7], strs[8]);
            dataSrcList.add(dataSrc);
        }
        return dataSrcList;
    }
}

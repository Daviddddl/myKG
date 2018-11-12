package dataobject;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Disease {
    private String diseaseName;
    private List<Disease> children;

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public List<Disease> getChildren() {
        return children;
    }

    public void setChildren(List<Disease> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Disease{" +
                "diseaseName='" + diseaseName + '\'' +
                ", children=" + children +
                '}';
    }

    private static String readFile(){
        StringBuilder laststr= new StringBuilder();
        File file=new File("src/main/java/data/disease/HumanDisease.json");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String tempString;
            while ((tempString = reader.readLine()) != null)
                laststr.append(tempString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return laststr.toString();
    }

    public static List<Disease> getDiseaseNodes(){
        List<Disease> diseaseList = new ArrayList<>();
        JSONObject diseaseJson = JSONObject.parseObject(readFile());
        String firstParentName = diseaseJson.getString("name"); // br08402
        JSONArray firstChildrenArray = diseaseJson.getJSONArray("children");
        List<Disease> firstChildList = new ArrayList<>();

        for (Object firstChildren : firstChildrenArray){
            JSONObject diseaseJson2 = (JSONObject)firstChildren;
            String secondParentName = diseaseJson2.getString("name"); // Cancers
            JSONArray secondChildrenArray = diseaseJson2.getJSONArray("children");
            List<Disease> secondChildList = new ArrayList<>();

            for (Object secondChildren : secondChildrenArray) {
                JSONObject diseaseJson3 = (JSONObject) secondChildren;
                String thirdParentName = diseaseJson3.getString("name"); // Head and neck cancers
                JSONArray thirdChildrenArray = diseaseJson3.getJSONArray("children");
                List<Disease> thirdChildList = new ArrayList<>();

                for (Object thirdChildren : thirdChildrenArray) {
                    JSONObject diseaseJson4 = (JSONObject) thirdChildren;
                    String lastName = diseaseJson4.getString("name"); // H00016 Oral cancer

                    Disease disease = new Disease();
                    disease.setDiseaseName(lastName);
                    disease.setChildren(null);
                    diseaseList.add(disease);
                    thirdChildList.add(disease);
                }

                Disease disease = new Disease();
                disease.setDiseaseName(thirdParentName);
                disease.setChildren(thirdChildList);
                diseaseList.add(disease);
                secondChildList.add(disease);
            }

            Disease disease = new Disease();
            disease.setDiseaseName(secondParentName);
            disease.setChildren(secondChildList);
            diseaseList.add(disease);
            firstChildList.add(disease);
        }

        Disease disease = new Disease();
        disease.setDiseaseName(firstParentName);
        disease.setChildren(firstChildList);
        diseaseList.add(disease);

        return diseaseList;
    }
}

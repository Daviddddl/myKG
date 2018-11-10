package service;

import dataobject.Disease;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DiseaseServiceImpl implements DiseaseService{
    @Override
    public Disease getDiseaseByName(String diseaseName) {
        for (Disease disease : Disease.getDiseaseNodes())
            if (diseaseName.equals(disease.getDiseaseName()))
                return disease;
        return null;
    }

    @Override
    public List<Disease> getDiseaseChildrenByName(String diseaseName) {
        for (Disease disease : Disease.getDiseaseNodes())
            if (diseaseName.equals(disease.getDiseaseName()))
                return disease.getChildren();
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new DiseaseServiceImpl().getDiseaseByName("br08402"));
    }
}

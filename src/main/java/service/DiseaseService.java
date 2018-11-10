package service;

import dataobject.Disease;

import java.util.List;

public interface DiseaseService {
    Disease getDiseaseByName(String diseaseName);
    List<Disease> getDiseaseChildrenByName(String diseaseName);

}

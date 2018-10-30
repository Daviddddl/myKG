package service;

import dataobject.Disease;

public interface DiseaseService {
    Disease getDiseaseByName(String diseaseName);
}

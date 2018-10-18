package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface NodeService {

    List<HashMap> getNodesByLabels(String label, Integer num, List<String> keys);
    List<Map> getRelationsByName(String relationName, Integer num);
}

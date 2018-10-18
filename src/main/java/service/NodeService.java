package service;

import java.util.HashMap;
import java.util.List;

public interface NodeService {

    List<HashMap> getNodesByLabel(String label, Integer num, List<String> keys);
}

package service;

import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.StatementResult;
import org.springframework.stereotype.Service;
import utils.Neo4jConfig;
import utils.Neo4jUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class NodeServiceImpl implements NodeService{

    private Neo4jUtil neo4jUtil = new Neo4jConfig().getNeo4j();

    public NodeServiceImpl() throws IOException {
    }

    @Override
    public List<HashMap> getNodesByLabel(String label, Integer num, List<String> keys) {
        if (num == null)
            num = 25;
        StringBuilder stringBuilder = new StringBuilder("MATCH (n:" + label + ") RETURN ");
        if (keys != null)
            keys.forEach(s -> stringBuilder.append("n.").append(s).append(","));
        else
            stringBuilder.append("n,");
        stringBuilder.deleteCharAt(stringBuilder.length() - 1).append(" LIMIT ").append(num);
        System.out.println(stringBuilder.toString());
        StatementResult result = neo4jUtil.myNeo4j(stringBuilder.toString());
        List<HashMap> hashMapList = new ArrayList<>();
        while (result.hasNext()){
            Record record = result.next();
            System.out.println(record);
            HashMap<String, String> hashMap = new HashMap<>();
            if (keys != null)
                keys.forEach(s -> hashMap.put(s, record.get("n." + s).asString()));
            hashMapList.add(hashMap);
        }
        neo4jUtil.close();
        return hashMapList;
    }
}

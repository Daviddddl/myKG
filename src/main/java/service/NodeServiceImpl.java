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
import java.util.Map;

@Service
public class NodeServiceImpl implements NodeService{

    private Neo4jUtil neo4jUtil = new Neo4jConfig().getNeo4j();

    public NodeServiceImpl() throws IOException {
    }

    @Override
    public List<HashMap> getNodesByLabels(String label, Integer num, List<String> keys) {

        num = num ==  null ? 25 : num;

        StringBuilder stringBuilder = new StringBuilder("MATCH (n:" + label + ") RETURN ");
        if (keys != null)
            keys.forEach(s -> stringBuilder.append("n.").append(s).append(","));
        else
            stringBuilder.append("n,");
        stringBuilder.deleteCharAt(stringBuilder.length() - 1).append(" LIMIT ").append(num);
//        System.out.println(stringBuilder.toString());
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

    @Override
    public List<Map> getRelationsByName(String relationName, Integer num) {

        num = num ==  null ? 25 : num;

        StatementResult result = neo4jUtil.myNeo4j("MATCH p=()-[r:" + relationName + "]->() RETURN p LIMIT " + num);
        List<Map> mapList = new ArrayList<>();
        while (result.hasNext()){
            Record record = result.next();
            mapList.add(record.asMap());
        }
        neo4jUtil.close();
        return mapList;
    }
}

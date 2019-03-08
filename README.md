## Food & Disease KG

### How to access
http://172.29.34.165:7474

### update maven dependency versions
```
mvn versions:set -DnewVersion=1.0.1-SNAPSHOT
```

### TODO
1. Optimize the visualization.(Modify labels of Nodes, to make them easier to understand)
2. Adjust the relationship of "Group" to contain more information between Food & Disease. 
    - And the main relation between them will be "nutrition". 
        - Eg. 
            - < Disease ~> Food > The cause of XXX disease is the lack of YYY nutrients, and ZZZ food is rich in YYY nutrients.
            - < Food ~> Disease > If you eat XXX food regularly, you will consume a lot of YYY nutrients, which will be beneficial to the treatment of ZZZ1 disease, which will cause ZZZ2 disease however.
    - Maybe there will be more other relations.
3. Merge work.
4. More data of Disease-KG will come soon: Disease Mapping, Disease Classification, Human Organ Systems and Cells, etc. 
5. Develop more functionally available interfaces to provide upper-level services.

package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SocialNetwork {
    private Map<String, List<String>> listMap = new HashMap<>();


    public void addVertex(String person){
        listMap.put(person,new ArrayList<>());
    }

    public void addEdge(String person1, String person2){

    }

    public static void main(String[] args) {

    }
}

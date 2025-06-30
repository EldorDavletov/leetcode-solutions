package binarysearch;

import leetcodesolutions.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SnapshotArray {
    private List<TreeMap<Integer,Integer>> list;
    private  int snapId=0;

    public SnapshotArray(int len){
        list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            TreeMap<Integer,Integer> map = new TreeMap<>();
            map.put(0,0);
            list.add(map);
        }
    }

    public void set(int index, int val) {
        TreeMap<Integer,Integer> map = list.get(index);
        map.put(snapId,val);

    }

    public int snap() {
        return snapId++;
    }

    public int get(int index, int snap_id) {
        TreeMap<Integer,Integer> map = list.get(index);
        return map.floorEntry(snap_id).getValue();
    }

    public static void main(String[] args) {
        SnapshotArray obj = new SnapshotArray(10);
        System.out.println(obj.list);


    }
}

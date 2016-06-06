package test;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.HashMap;
import java.util.List;

/**
 * Created by xin on 2016/3/22.
 */
public class IOTest {
    public static void main(String[] args) throws IOException {
        new IOTest().operate2();
    }

    public void operate2() throws IOException{
        BufferedReader bufr = new BufferedReader(new FileReader("info.txt"));
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        String line;
        while ((line = bufr.readLine())!=null){
            String[] strs = line.split("\\|");
            String key = strs[3];
            if (map.containsKey(key)){
                int value = map.get(key);
                map.put(key,++value);
            }else {
                map.put(key,1);
            }
        }
        bufr.close();
        for (String key : map.keySet()) {
            System.out.println(key+":"+map.get(key));
        }
    }

    public void operate() throws IOException {
        File file = new File("info.txt");
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        List<String> list = FileUtils.readLines(file);
        for (String str : list) {
            String[] strs = str.split("\\|");
            String key = strs[3];
            if (map.containsKey(key)){
                int value = map.get(key);
                map.put(key,++value);
            }else {
                map.put(key,1);
            }
        }
        for (String key : map.keySet()) {
            System.out.println(key+":"+map.get(key));
        }
    }
}


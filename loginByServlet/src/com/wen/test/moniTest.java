package com.wen.test;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class moniTest {
    public static void main(String[] args) throws Exception {

        Map<String,Integer> scores = new HashMap<>();
        //读取正确答案
        ArrayList<String> arr_daan = getDataForFile("C:\\Users\\wenhe\\Desktop\\答案.txt");
        System.out.println("正确答案:"+arr_daan);
        //读取学员答案
        File f = new File("C:\\Users\\wenhe\\Desktop\\答案");
        File[] files = f.listFiles();
        for (int i = 0; i < files.length; i++) {
            File file = files[i];
            String name = file.getName().split("\\.")[0];
            System.out.println("读取 --"+name+"-- 答案....");
            ArrayList<String> daan = getDataForFile(file.getPath());
            int score = getScore(arr_daan, daan);
            scores.put(name,score);
            System.out.println("--------------------"+name+":"+score);
        }

        //输出得分
        BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\wenhe\\Desktop\\答案\\AAAA成绩.txt"));
        Set<Map.Entry<String, Integer>> entries = scores.entrySet();
        for(Map.Entry<String, Integer> entry : entries){
            bw.write(entry.getKey()+": "+entry.getValue());
            bw.newLine();
            bw.flush();
        }
        bw.close();
        System.out.println("已全部批阅完成---------------------------");

    }

    public static ArrayList<String> getDataForFile(String path) throws Exception {
        ArrayList<String> arr_daan = new ArrayList();
        BufferedReader bf = new BufferedReader(new FileReader(path));
        String line ;
        while((line=bf.readLine())!=null){
            String[] split = line.split(",");
            for (int i = 0;i<split.length;i++){
                arr_daan.add(split[i]);
            }
        }
        bf.close();
        return arr_daan;
    }

    public static int getScore(ArrayList<String> a1 ,ArrayList<String> a2){
        int score = 0;
        for (int i = 0; i < a1.size(); i++) {
            if(a1.get(i).equalsIgnoreCase(a2.get(i))){
                score=score+4;
            }else{
                System.out.println("第"+(i+1)+"错!!");
            }
        }
        return score;

    }


}

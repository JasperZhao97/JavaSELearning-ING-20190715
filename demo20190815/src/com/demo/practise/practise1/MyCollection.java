package com.demo.practise.practise1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MyCollection {
    private HashMap companys = new HashMap();

    /**
     * 根据公司添加信息
     *
     * @param company
     * @param city
     * @param hasty
     * @param product
     */
    public void set(String company, String city, String hasty, String product) {
        //判断是否存在该公司
        if (!companys.isEmpty() && companys.containsKey(company)) {
            HashMap citys = (HashMap) companys.get(company);
            //判断是否存在该城市
            if (!citys.isEmpty() && citys.containsKey(city)) {
                HashMap hastys = (HashMap) citys.get(city);
                //判断是否存在该仓库
                if (!hastys.isEmpty()&&hastys.containsKey(hasty)) {
                    ArrayList products = (ArrayList) hastys.get(hasty);
                    products.add(product);
                } else {
                    ArrayList products = new ArrayList();
                    products.add(product);
                    hastys.put(hasty, products);
                }
            } else {
                ArrayList products = new ArrayList();
                products.add(product);
                HashMap<String, ArrayList> hastys = new HashMap<>();
                hastys.put(hasty, products);
                citys.put(city, hastys);
            }
        } else {
            //新建产品线性表
            ArrayList products = new ArrayList();
            products.add(product);
            //新建仓库Map，key为仓库，value为产品list
            HashMap<String, ArrayList> hastys = new HashMap<>();
            hastys.put(hasty, products);
            //新建城市Map，key为城市，value为仓库Map
            HashMap<String, HashMap> citys = new HashMap<>();
            citys.put(city, hastys);
            //将仓库Map当做value加入
            companys.put(company, citys);
        }
    }

    /**
     * 输出想要的公司的信息
     * @param company
     */
    /*public void show(String company) {
        System.out.println("公司：" + company);
        Set<Map.Entry<String, HashMap>> citys = ((HashMap) (companys.get(company))).entrySet();
        for (Map.Entry<String, HashMap> city : citys) {
            System.out.println("城市：" + city.getKey());
            Set<Map.Entry<String, ArrayList>> hastys = ((HashMap) (city.getValue())).entrySet();
            for (Map.Entry<String, ArrayList> hasty : hastys) {
                System.out.println("仓库：" + hasty.getKey());
                ArrayList products = new ArrayList();
                products = (ArrayList) hasty.getValue();
                System.out.print("商品：");
                System.out.println(products);
            }
        }
    }*/

    /**
     * 输出所有的公司信息
     */
    public void showall() {
        Set<Map.Entry<String, HashMap>> companys1 = companys.entrySet();
        for (Map.Entry<String, HashMap> company : companys1) {
            System.out.println("---------------------------------");
            System.out.println("公司：" + company.getKey());
            Set<Map.Entry<String, HashMap>> citys = ((HashMap) (company.getValue())).entrySet();
            for (Map.Entry<String, HashMap> city : citys) {
                System.out.println("城市：" + city.getKey());
                Set<Map.Entry<String, ArrayList>> hastys = ((HashMap) (city.getValue())).entrySet();
                for (Map.Entry<String, ArrayList> hasty : hastys) {
                    System.out.println("仓库：" + hasty.getKey());
                    ArrayList products = new ArrayList();
                    products = (ArrayList) hasty.getValue();
                    System.out.print("商品：");
                    System.out.println(products);
                }
            }
        }

    }
}

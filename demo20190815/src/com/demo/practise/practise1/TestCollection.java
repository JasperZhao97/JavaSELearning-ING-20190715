package com.demo.practise.practise1;

public class TestCollection {
    public static void main(String[] args) {
        MyCollection myCollection = new MyCollection();
        myCollection.set("国际软件有限公司","重庆","渝北仓库1","软件外包1");
        myCollection.set("国际软件有限公司","重庆","渝北仓库1","软件外包2");
        myCollection.set("国际软件有限公司","重庆","渝北仓库2","软件外包1");
        myCollection.set("国际软件有限公司","天津","北仓库1","服务外包1");
        myCollection.set("中国开发","昆明","南仓库1","开发语言");
//        myCollection.show("国际软件有限公司");
//        System.out.println("---------------------------------");
//        myCollection.show("中国开发");
//        System.out.println("---------------------------------");
        myCollection.showall();
    }
}

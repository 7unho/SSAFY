package com.ssafy.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DomTest {
    public static void main(String[] args) throws Exception {
        // 공장 객체 ( Factory )
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        String xmlPath = "./day220729/src/com/ssafy/xml/";
        // 일꾼 객체 ( Builder )
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(xmlPath + "test2.xml");

        // DOM 프로그래밍의 시작
        Element root = doc.getDocumentElement();
        System.out.printf("루트 태그명 : %s\n", root.getTagName());

        System.out.println(root.getChildNodes().item(0).getNodeValue());
        System.out.println(root.getFirstChild().getNodeValue());
        System.out.println(root.getTextContent());

//        FileOutputStream fos = new FileOutputStream(xmlPath + "test2.xml");


        File file = new File("test3.xml");

        FileOutputStream fos = new FileOutputStream(xmlPath + file);

        // 파라미터로 int를 넣어주어도 ascii 코드 값으로 write한다

        fos.write(97);
        fos.close();
    }
}

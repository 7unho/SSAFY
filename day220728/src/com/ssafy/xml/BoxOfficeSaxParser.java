package com.ssafy.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BoxOfficeSaxParser extends DefaultHandler {
    private final File xml = new File("./day220728/src/com/ssafy/xml/boxoffice.xml");
    private List<BoxOffice> list = new ArrayList<>();
    private BoxOffice current;
    private String content;

    public List<BoxOffice> getBoxOffice() {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            parser.parse(xml, this);

        } catch (SAXParseException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("문서 읽기 시작");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("문서 읽기 완료");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        // qName -> 태그의 이름
        // qName이 dailyBoxOffice와 같다면 해당 태그부터 BoxOffice 객체를 생성
        if (qName.equals("dailyBoxOffice")) current = new BoxOffice();

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
//        if (qName.equals("dailyBoxOffice")) {
//            list.add(current);
//            content = null;
//        } else if (qName.equals("rank")) current.setRank(Integer.parseInt(content));
//         else if (qName.equals("movieNm")) current.setMovieNm(this.content);
//         else if (qName.equals("openDt")) current.setOpenDt(current.toDate(this.content));
//         else if (qName.equals("audiAcc")) current.setAudiAcc(Integer.parseInt(content));

         switch (qName){
             case "dailyBoxOffice":
                 list.add(current);
                 current = null;
                 break;
             case "rank":
                 current.setRank(Integer.parseInt(content));
                 break;
             case "movieNm":
                 current.setMovieNm(this.content);
                 break;
             case "openDt":
                 current.setOpenDt(current.toDate(this.content));
                 break;
             case "audiAcc":
                 current.setAudiAcc(Integer.parseInt(content));
                 break;
         }
    }



    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // 태그가 가지고 있는 속성의 값 구하기.
        this.content = new String(ch, start, length);
    }
}
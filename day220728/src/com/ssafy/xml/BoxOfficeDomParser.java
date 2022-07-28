package com.ssafy.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BoxOfficeDomParser {
    private final File xml = new File("./day220728/src/com/ssafy/xml/boxoffice.xml");
    private List<BoxOffice> list = new ArrayList<>();

    public List<BoxOffice> getBoxOffice(){
        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc = builder.parse(xml);

            Element root = doc.getDocumentElement();
            parse(root);
        } catch (ParserConfigurationException e){
            e.printStackTrace();
        } catch (SAXException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

        return list;
    }

    private void parse(Element root){
        NodeList boxOffices = root.getElementsByTagName("dailyBoxOffice");
        for (int i = 0; i < boxOffices.getLength(); i++) {
            Node child = boxOffices.item(i);
            list.add(getBoxOffice(child));
        }
    }

    private static BoxOffice getBoxOffice(Node node){
        BoxOffice boxoffice = new BoxOffice();

        NodeList subNodes = node.getChildNodes();
        for (int j = 0; j < subNodes.getLength(); j++) {
            Node sub = subNodes.item(j);

            switch (sub.getNodeName()){
                case "rank":
                    boxoffice.setRank(Integer.parseInt(sub.getTextContent()));
                    break;
                case "movieNm":
                    boxoffice.setMovieNm(sub.getTextContent());
                    break;
                case "openDt":
                    boxoffice.setOpenDt(boxoffice.toDate(sub.getTextContent()));
                    break;
                case "audiAcc":
                    boxoffice.setAudiAcc(Integer.parseInt(sub.getTextContent()));
                    break;
            }
        }

        return boxoffice;
    }
}

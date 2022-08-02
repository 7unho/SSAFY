package com.ssafy.xml;

import com.ssafy.xml.book.Book;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DomTest2 {
    DocumentBuilderFactory factory;
    DocumentBuilder builder;

    Document doc;

    String filePath = "./day220729/src/com/ssafy/xml/book/";

    private List<Book> list = new ArrayList<>();

    public DomTest2() {
        try {
            factory = DocumentBuilderFactory.newInstance();
            builder = factory.newDocumentBuilder();
            File file = new File("books.xml");

            /// openAPI addredd
            doc = builder.parse(filePath + file);
            NodeList titleList = doc.getElementsByTagName("title");

            System.out.println("도서 개수 : " + titleList.getLength());

            for (int i = 0; i < titleList.getLength(); i++) {
                String title = titleList.item(i).getTextContent();
                System.out.println(title);
            }

            // 홍길동 저자의 책 제목과 가격 출력
            Element root = doc.getDocumentElement();
            parse(root);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void parse(Element root){
        NodeList books = root.getElementsByTagName("books");

        for (int i = 0; i < books.getLength(); i++) {
            Node child = books.item(i);
            list.add(getBook(child));
        }
    }

    private static Book getBook(Node node){
        Book book = new Book();

        NodeList subNodes = node.getChildNodes();
        for (int i = 0; i < subNodes.getLength(); i++) {
            Node sub = subNodes.item(i);

            switch (sub.getNodeName()){
                case "title":
                    book.setTitle(sub.getTextContent());
                    break;
                case "author":
                    book.setAuthor(sub.getTextContent());
                    break;
                case "price":
                    book.setPrice(Integer.parseInt(sub.getTextContent()));
                    break;
            }
        }

        return book;
    }

    public static void main(String[] args) {
        // 미션 : books.xml 을 DOM parsing 후 도서제목을 출력하시오.
//        List<Book> list = new DomTest2().get

    }
}

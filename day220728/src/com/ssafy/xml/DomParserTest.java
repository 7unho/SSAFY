package com.ssafy.xml;

import java.util.List;

public class DomParserTest {
    public static void main(String[] args) {
        BoxOfficeDomParser parser = new BoxOfficeDomParser();
        List<BoxOffice> list = parser.getBoxOffice();

        for (BoxOffice info: list) {
            System.out.println(info);
        }
    }
}

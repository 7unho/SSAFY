package com.ssafy.xml;

import java.util.List;

public class SaxParserTest {
    public static void main(String[] args) {
        BoxOfficeSaxParser handler = new BoxOfficeSaxParser();

        List<BoxOffice> list = handler.getBoxOffice();

        for (BoxOffice boxOffice: list) {
            System.out.println(boxOffice);
        }
    }
}

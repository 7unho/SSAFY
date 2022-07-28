package com.ssafy.json;

import java.util.List;

public class JsonParserTest {
    public static void main(String[] args) {
        UseJson parser = new UseJson();

        try{
            List<BoxOffice> list = parser.getBoxOffice();

            for (BoxOffice info : list) {
                System.out.println(info);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

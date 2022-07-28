package com.ssafy.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssafy.xml.BoxOffice;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UseJson {
    private final File json = new File("./day220728/src/com/ssafy/json/boxoffice.json");
    private List<com.ssafy.json.BoxOffice> list = new ArrayList<>();

    @SuppressWarnings({"unchecked", "rawtypess"})
    public List<com.ssafy.json.BoxOffice> getBoxOffice() throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();

        // 날짜 변경과 관련된 룰 지정
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));

        Map<String, Map<String, Object>> result = mapper.readValue(json, Map.class);
        List<Map<String, Object>> list = (List) result.get("boxOfficeResult").get("dailyBoxoffceList");

        for (Map<String, Object> info : list) {
            BoxOffice boxOffice = mapper.convertValue(info, BoxOffice.class);
            System.out.println(boxOffice);
        }

        return this.list;
    }

}

package com.ssafy.xml;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BoxOffice extends com.ssafy.gui.BoxOffice {
    private Integer rank;
    private String movieNm;
    private Date openDt;
    private Integer audiAcc;

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getMovieNm() {
        return movieNm;
    }

    public void setMovieNm(String movieNm) {
        this.movieNm = movieNm;
    }

    public Date getOpenDt() {
        return openDt;
    }

    public void setOpenDt(Date openDt) {
        this.openDt = openDt;
    }

    public Integer getAudiAcc() {
        return audiAcc;
    }

    public void setAudiAcc(Integer audiAcc) {
        this.audiAcc = audiAcc;
    }

    public Date toDate(String date){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");

        try{
            return format.parse(date);
        } catch (ParseException e){
            e.printStackTrace();
            return new Date();
        }
    }

    @Override
    public String toString() {
        return "[rank=" + rank + ", movieNm=" + movieNm + ", openDt=" + openDt + ", AudiAcc=" + audiAcc + "]";
    }
}

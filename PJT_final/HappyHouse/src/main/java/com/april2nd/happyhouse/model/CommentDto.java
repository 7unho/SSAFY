package com.april2nd.happyhouse.model;

public class CommentDto {
    private String no;
    private int articleno;
    private String content;
    private String regtime;
    private String writer;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public int getArticleno() {
        return articleno;
    }

    public void setArticleno(int articleno) {
        this.articleno = articleno;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRegtime() {
        return regtime;
    }

    public void setRegtime(String regtime) {
        this.regtime = regtime;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    @Override
    public String toString() {
        return "CommentDto{" +
                "no='" + no + '\'' +
                ", articleno=" + articleno +
                ", content='" + content + '\'' +
                ", regtime='" + regtime + '\'' +
                ", writer='" + writer + '\'' +
                '}';
    }
}

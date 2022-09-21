package com.april2nd.live1;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class MyTagHandler extends TagSupport{
	//태그를 만났을때 실행할 (로직적인)코드를 기술
    
	@Override
	public int doStartTag() throws JspException {
	    JspWriter out = pageContext.getOut(); //브라우저 출력객체
	    //반복문, 조건문,  DB연결
	    try {
			for(int i=0; i<10; i++) {
			  if(i%2==0)
				out.print("<font color=blue>커스텀태그 안녕~^O^</font><br>");
			  else	
			    out.print("<font color=red>커스텀태그 안녕~^O^</font><br>");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
		return SKIP_BODY;//엘리먼트의 본문이 없는 경우  ----> 내용없음  ---> 빈태그
	}//doStartTag
}




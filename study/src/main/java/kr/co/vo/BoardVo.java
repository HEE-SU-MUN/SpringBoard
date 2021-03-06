package kr.co.vo;
import java.util.Date;

import lombok.Data;

public class BoardVo {

		private long bno;
		private String title;
		private String content;
		private String writer;
		private Date regdate;
		private Date updateDate;
		public long getBno() {
			return bno;
		}
		public void setBno(long bno) {
			this.bno = bno;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public String getWriter() {
			return writer;
		}
		public void setWriter(String writer) {
			this.writer = writer;
		}
		public Date getRegdate() {
			return regdate;
		}
		public void setRegdate(Date regdate) {
			this.regdate = regdate;
		}
		public Date getUpdateDate() {
			return updateDate;
		}
		public void setUpdateDate(Date updateDate) {
			this.updateDate = updateDate;
		}
}
		
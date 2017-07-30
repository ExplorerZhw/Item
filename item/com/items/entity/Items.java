package com.items.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public class Items implements Serializable{
		
		private String title;
		private String location;
		private Date time;
		private String content;
		private List<String> member;
		private Date startime;
		private Date endtime;
		
		public Date getStartime() {
			return startime;
		}
		public void setStartime(Date startime) {
			this.startime = startime;
		}
		public Date getEndtime() {
			return endtime;
		}
		public void setEndtime(Date endtime) {
			this.endtime = endtime;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		public Date getTime() {
			return time;
		}
		public void setTime(Date time) {
			this.time = time;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public List<String> getMember() {
			return member;
		}
		public void setMember(List<String> member) {
			this.member = member;
		}
		@Override
		public String toString() {
			return "Meet [content=" + content + ", endtime=" + endtime
					+ ", location=" + location + ", member=" + member
					+ ", startime=" + startime + ", time=" + time + ", title="
					+ title + "]";
		}
		
		
}

package com.socialhub.modelos;

import java.util.Date;

public abstract class Item implements Comparable<Item>{
	public static final int FACEBOOK = 0;
	public static final int TWITTER = 1;
	
	public abstract int getType();
	
	public abstract Date getCreatedAt();
	
	public abstract String getAuthor();
	
	public abstract String getMessage();
	
	public abstract int getLikeCount();
	
	public abstract int getSharedCount();
	
	public  abstract String getAuthorImage();
	
	public  abstract String getImage();
	
	@Override
	public int compareTo(Item o) {
		if(getCreatedAt().after(o.getCreatedAt())) return -1;
		if(getCreatedAt().before(o.getCreatedAt())) return 1;
		return 0;
	}
	
	
}

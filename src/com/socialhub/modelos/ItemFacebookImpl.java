package com.socialhub.modelos;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.springframework.social.facebook.api.Post;

public class ItemFacebookImpl extends Item {
	private Post post;
	
	public ItemFacebookImpl(Post post) {
		super();
		this.post = post;
	}
	
	public ItemFacebookImpl() {}
	
	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	@Override
	public int getType() {
		return Item.FACEBOOK;
	}

	@Override
	public Date getCreatedAt() {
		return post.getCreatedTime();
	}

	@Override
	public String getAuthor() {
		return post.getFrom().getName();
	}

	@Override
	public String getMessage() {
		return post.getMessage();
	}

	@Override
	public int getLikeCount() {
		return ((ArrayList) ((HashMap<String, Object>) post.getExtraData().get("likes")).get("data")).size();
	}

	@Override
	public int getSharedCount() {
		return post.getShares();
	}

	@Override
	public String getAuthorImage() {
		return "";
	}

	@Override
	public String getImage() {
		return post.getPicture();
	}

}

package com.socialhub.modelos;

import java.util.Date;

import org.springframework.social.twitter.api.Tweet;

public class ItemTwitterImpl extends Item{
	private Tweet tweet;
	
	public ItemTwitterImpl() {}
	
	public ItemTwitterImpl(Tweet tweet) {
		super();
		this.tweet = tweet;
	}

	public Tweet getTweet() {
		return tweet;
	}

	public void setTweet(Tweet tweet) {
		this.tweet = tweet;
	}

	@Override
	public int getType() {
		return Item.TWITTER;
	}

	@Override
	public Date getCreatedAt() {
		return tweet.getCreatedAt();
	}

	@Override
	public String getAuthor() {
		return tweet.getFromUser();
	}

	@Override
	public String getMessage() {
		return tweet.getText();
	}

	@Override
	public int getLikeCount() {
		return tweet.getFavoriteCount();
	}

	@Override
	public int getSharedCount() {
		return tweet.getRetweetCount();
	}

	@Override
	public String getAuthorImage() {
		return tweet.getProfileImageUrl();
	}

	@Override
	public String getImage() {
		return "";
	}

}

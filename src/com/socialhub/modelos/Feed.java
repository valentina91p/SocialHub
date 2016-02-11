package com.socialhub.modelos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import org.springframework.social.facebook.api.Post;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.stereotype.Component;

@Component
public class Feed {
	
	private ArrayList<Item> posts;
	
	public Feed(){
		posts = new ArrayList<Item>();
	}
	
	public void add(Object[] newPosts){
		for(Object post: newPosts){
			if(post instanceof Post)
				posts.add(new ItemFacebookImpl((Post)post));
			else
				posts.add(new ItemTwitterImpl((Tweet)post));
		}
		Collections.sort(posts);
	}

	public ArrayList<Item> getPosts() {
		return posts;
	}
	
	
	
	
}

package com.socialhub.controladores;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;

public class SimpleConnectionSignUp  implements ConnectionSignUp{
		private final AtomicLong userIdSequence = new AtomicLong();
		
		public String execute(Connection<?> connection) {
			return Long.toString(userIdSequence.incrementAndGet());
		}

}

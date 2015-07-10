package com.socialhub.config;

import com.socialhub.modelos.Usuario;

public final class SecurityContext {

	private static final ThreadLocal<Usuario> usuarioActual = new ThreadLocal<Usuario>();

	public static Usuario getUsuarioActual() {
		Usuario user = usuarioActual.get();
		if (user == null) {
			throw new IllegalStateException("No user is currently signed in");
		}
		return user;
	}

	public static void setUsuarioActual(Usuario user) {
		usuarioActual.set(user);
	}

	public static boolean userSignedIn() {
		return usuarioActual.get() != null;
	}

	public static void remove() {
		usuarioActual.remove();
	}

}
package com.socialhub.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.socialhub.dao.UsuarioDAO;
import com.socialhub.modelos.Usuario;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioDAO usuarioDAO;
 
    @Transactional
    public void addUsuario(Usuario p) {
        this.usuarioDAO.addUsuario(p);
    }
 
    @Transactional
    public void updateUsuario(Usuario p) {
        this.usuarioDAO.updateUsuario(p);
    }
 
    @Transactional
    public List<Usuario> listUsuarios() {
        return this.usuarioDAO.listUsuarios();
    }
 
    @Transactional
    public Usuario getUsuarioById(int id) {
        return this.usuarioDAO.getUsuarioById(id);
    }
    
    @Transactional
    public Usuario loadUsuarioByUsername(String username) {
        return this.usuarioDAO.getUsuarioByUsername(username);
    }
 
    @Transactional
    public void removeUsuario(int id) {
        this.usuarioDAO.removeUsuario(id);
    }
}

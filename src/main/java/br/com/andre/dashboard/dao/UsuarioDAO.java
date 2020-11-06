package br.com.andre.dashboard.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.andre.dashboard.model.Usuario;



public interface UsuarioDAO extends CrudRepository<Usuario, Integer>{
	
	
	public Usuario findByRacfAndSenha(String racf, String senha);
	
	public Usuario findByRacfOrEmail(String racf, String email);
	
	

}

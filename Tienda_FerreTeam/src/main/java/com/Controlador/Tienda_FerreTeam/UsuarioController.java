package com.Controlador.Tienda_FerreTeam;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DAO.Tienda_FerreTeam.UsuarioDAO;
import com.DTO.Tienda_FerreTeam.UsuarioVO;

@RestController
public class UsuarioController {
	
	@RequestMapping("/listarUsuarios")
	public ArrayList<UsuarioVO> listarUsuarios()
	{
		UsuarioDAO Dao = new UsuarioDAO();
		
		return Dao.ListaUsuarios();
	}
	
	@RequestMapping("/ConsultarUsuarios")
	public ArrayList<UsuarioVO> ConsultarUsuario(int Documento)
	{
		UsuarioDAO Dao = new UsuarioDAO();
		return Dao.ConsultarUsuario(Documento);
	}
	
	@RequestMapping("/RegistrarUsuarios")
	public void RegistrarUsuario(UsuarioVO persona)
	{
		UsuarioDAO Dao = new UsuarioDAO();
		Dao.RegistrarUsuario(persona);
	}
	
	@RequestMapping("/EliminarUsuarios")
	public void EliminarUsuario(int Documento)
	{
		UsuarioDAO Dao = new UsuarioDAO();
		Dao.EliminarUsuario(Documento);
	}

	@RequestMapping("/ActualizarUsuarios")
	public void ActualizarUsuario(int Documento, String Nombre, String Correo)
	{
		UsuarioDAO Dao = new UsuarioDAO();
		Dao.ActualizarUsuario(Documento, Nombre, Correo);
	}
}

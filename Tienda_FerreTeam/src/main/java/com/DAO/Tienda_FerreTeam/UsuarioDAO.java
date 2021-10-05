package com.DAO.Tienda_FerreTeam;

import java.sql.*;
import java.util.ArrayList;
 //Permite el acceso a la bd


import com.DTO.Tienda_FerreTeam.UsuarioVO;

public class UsuarioDAO {
	
	//Metodo para consultar usuarios
	
	public ArrayList<UsuarioVO> ListaUsuarios()
	{
		ArrayList<UsuarioVO> milista = new ArrayList<UsuarioVO>();
		Conexion con = new Conexion();
		
		try
		{
			PreparedStatement consulta = con.getCon().prepareStatement("SELECT * FROM T_Usuarios");
			ResultSet rs = consulta.executeQuery();
			while(rs.next())
			{
				UsuarioVO persona = new UsuarioVO();
				persona.setCedula(Integer.parseInt(rs.getString("Cedula_Usu")));
				persona.setNombre(rs.getString("Nombre_Usu"));
				persona.setCorreo(rs.getString("Correo_Usu"));
				persona.setUsuario(rs.getString("Usuario"));
				persona.setClave(rs.getString("Clave_Usu"));
				
				milista.add(persona);
			}
			rs.close();
			consulta.close();
			con.desconectar();
			
		}
		catch(Exception e)
		{
			System.out.println("Error no se pudo conectar" + e);
		}
		return milista;
	}
	
	//Para consultar un usuario por Numero de documento
	public ArrayList<UsuarioVO> ConsultarUsuario(int Documento)
	{
		ArrayList<UsuarioVO> milista = new ArrayList<UsuarioVO>();
		Conexion con = new Conexion();
		try
		{
			PreparedStatement consulta = con.getCon().prepareStatement("SELECT * FROM T_USUARIOS WHERE Cedula_Usu = ?");
			consulta.setInt(1, Documento);
			ResultSet rs = consulta.executeQuery();
			
			if(rs.next())
			{
				UsuarioVO persona = new UsuarioVO();
				persona.setCedula(Integer.parseInt(rs.getString("Cedula_Usu")));
				persona.setNombre(rs.getString("Nombre_Usu"));
				persona.setCorreo(rs.getString("Correo_Usu"));
				persona.setUsuario(rs.getString("Usuario"));
				persona.setClave(rs.getString("Clave_Usu"));
				
				milista.add(persona);
			}
			rs.close();
			consulta.close();
			con.desconectar();
			
		}
		catch(Exception e)
		{
			System.out.println("Error Usuario No Encontrado" + e);
		}
		return milista;
	}
	//Para registrar un usuario 
	public void RegistrarUsuario(UsuarioVO persona)
	{
		Conexion con = new Conexion();
		try
		{
			Statement stmt = con.getCon().createStatement();
			stmt.executeUpdate("INSERT INTO T_Usuarios Values('"+persona.getCedula()+"','"+persona.getNombre()+"','"+persona.getCorreo()+"','"+persona.getUsuario()+"','"+persona.getClave()+"')");
			System.out.println("El usuario ha sido agregado Exitosamente !");
			con.desconectar();
		}
		catch(Exception e)
		{
			System.out.println("Error de Conexión: Usuario no agregado" + e);
		}
	}
	
	//Para eliminar un usuario por Numero de documento
		public void EliminarUsuario(int Documento)
		{
			Conexion con = new Conexion();
			try
			{
				PreparedStatement consulta = con.getCon().prepareStatement("DELETE FROM T_USUARIOS WHERE Cedula_Usu = ?");
				consulta.setInt(1, Documento);
				consulta.executeUpdate();
				System.out.println("El usuario ha sido Eliminado");
				
				consulta.close();
				con.desconectar();
				
			}
			catch(Exception e)
			{
				System.out.println("Error Usuario No Eliminado" + e);
			}
		}
		//Para actualizar un usuario 
		public void ActualizarUsuario(int Documento, String Nombre, String Correo)
		{
			Conexion con = new Conexion();
			try
			{
				PreparedStatement consulta = con.getCon().prepareStatement("UPDATE T_USUARIOS SET Nombre_Usu = ?, Correo_Usu = ? WHERE Cedula_Usu = ?");
				consulta.setString(1, Nombre);
				consulta.setString(2, Correo);
				consulta.setInt(3, Documento);
				consulta.executeUpdate();
				System.out.println("El usuario ha sido Actualizado");
				
				consulta.close();
				con.desconectar();
				
			}
			catch(Exception e)
			{
				System.out.println("Error Usuario No Actualizado" + e);
			}
		}
	}
	



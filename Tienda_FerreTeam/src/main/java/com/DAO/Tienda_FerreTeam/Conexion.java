package com.DAO.Tienda_FerreTeam;

import java.sql.*;

public class Conexion {
	
	//Parametros de Conexion
	String bd = "DB_FERRETEAM";
	String Login = "root";
	String Password = "Admin_2021";
	String URL = "jdbc:mysql://localhost/"+bd;
	
	Connection con = null;
	
	//Constructor de Conexión
	public Conexion()
	{
		try
		{
			//Obtener el driver para MySQL
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Obtener la conexión
			con=DriverManager.getConnection(URL,Login,Password);
			if(con != null)
				System.out.println("Conexión Exitosa"); 
		}
		catch(SQLException e)
		{
			System.out.println("Error de Conexión: " + e);
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("Error de Conexión: " + e);			
		}
		catch(Exception e)
		{
			System.out.println("Error de Conexión: " + e);				
		}
	}
	
	//Metodo para retornar la conexión
	public Connection getCon()
	{
		return con;
	}

	//Metodo para desconectar Base de Datos
	public void desconectar()
	{
		con = null;
	}
}


package com.Controlador.Tienda_FerreTeam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.DAO.Tienda_FerreTeam.Conexion;

@SpringBootApplication
public class TiendaFerreTeamApplication {

	public static void main(String[] args) {
		SpringApplication.run(TiendaFerreTeamApplication.class, args);
		
		//Conexion conn = new Conexion();
		//conn.getCon();
		
	}

}

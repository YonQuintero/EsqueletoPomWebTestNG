package PagesObjects;

import java.io.File;

import org.openqa.selenium.WebDriver;

import MapsObjects.MapObjectRegistro;

public class PageObjectRegistro extends MapObjectRegistro {

	public PageObjectRegistro(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public void crearCuenta(String correo, File rutaCarpeta, String generarEvidencia)throws Exception
	{
		
		
		//CLICK EN CREAR CUENTA
		click(linkCrear1Cuenta, rutaCarpeta, generarEvidencia);
		//CLICK EN LAS COOKIES
		click(linkEntendido, rutaCarpeta,generarEvidencia);
		
	}
	public void crearMiCuenta(String correo, File rutaCarpeta, String generarEvidencia) throws Exception
	{
			//ACEPTAR TERMINOS Y CONDICIONES
			click(terminosCondiciones, rutaCarpeta,generarEvidencia);
			//CLICK EN CONTINUAR
			click(btnContinuar, rutaCarpeta,generarEvidencia);
			//CLICK EN VALIDAR
			click(btnValidar, rutaCarpeta,generarEvidencia);		
			// LIMPIAR LA CAJA DE TEXTO 
			borrar(txtBusqueda1, rutaCarpeta,generarEvidencia);
			// ENVIAR UN VALOR
			sendkey(correo, txtBusqueda1, rutaCarpeta,generarEvidencia);
			//TIEMPO DE ESPERA
			tiempoEspera(2000);
			
	}
}

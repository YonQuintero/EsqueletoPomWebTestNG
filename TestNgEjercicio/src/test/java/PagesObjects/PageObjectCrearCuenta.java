package PagesObjects;

import java.io.File;


import org.openqa.selenium.WebDriver;

import MapsObjects.MapObjectCrearCuenta;

public class PageObjectCrearCuenta extends MapObjectCrearCuenta{

	public PageObjectCrearCuenta(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public void crearMiCuenta(String Correo, File rutaCarpeta, String generarEvidencia) throws Exception
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
		sendkey(Correo, txtBusqueda1, rutaCarpeta,generarEvidencia);
		//TIEMPO DE ESPERA
		tiempoEspera(2000);
	}
}

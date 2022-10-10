package PagesObjects;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

import MapsObjects.MapObjectHome;

public class PageObjectHome extends MapObjectHome {

	public PageObjectHome(WebDriver driver) {
		super(driver);

	}

	//METODO INICIAL
		public void urlAcceso(String url)throws InterruptedException,  IOException
		{
			driver.get(url);
			//busquedaInicial();
		}
		//METODO PRIMERA PRUEBA
		public void busquedaInicial(String producto, File rutaCarpeta, String generarEvidencia) throws  Exception
		{
			try {
				
			
			// LIMPIAR LA CAJA DE TEXTO DE BUSQUEDA
			borrar(txtBusqueda, rutaCarpeta,generarEvidencia);
			// ENVIAR UN VALOR A BUSCAR
			sendkey(producto, txtBusqueda, rutaCarpeta,generarEvidencia);
			//ACEPTAMOS LA BUSQUEDA
			submit(txtBusqueda, rutaCarpeta,generarEvidencia);
			//TIEMPO DE ESPERA
			tiempoEspera(2000);
			//DAMOS CLICK EN LA X DEL MENSAJE INFORMATIVO PARA CONTINUAR
			click(linkX,rutaCarpeta,generarEvidencia);
			//DAMOS CLICK EN ENTENDIDO PARA ACEPTAR LAS COOKIES
			click(linkEntendido, rutaCarpeta,generarEvidencia);
			//DAMOS CLICK EN EL PRIMER RESULTADO
			click(btnPrimerResultado, rutaCarpeta,generarEvidencia);		
			// INGRESAMOS EN AÑADIR AL CARRITO
			click(linkCarrito, rutaCarpeta,generarEvidencia);	
			//TIEMPO DE ESPERA
			tiempoEspera(2000);
			//DAMOS CLICK EN CREAR CUENTA
			click(linkCrearCuenta,rutaCarpeta,generarEvidencia);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
}

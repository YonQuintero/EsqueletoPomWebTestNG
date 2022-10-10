package PagesObjects;

import java.io.File;
import java.io.IOException;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import MapsObjects.MapObjectHomeT;



public class PageObjectHomeT extends MapObjectHomeT {
	
	//CREAR CONSTRUCTOR DE LA CLASE
	public PageObjectHomeT(WebDriver driver)
	{
		super(driver);
	}
	//METODO INICIAL
		public void urlAcceso(String url)throws InterruptedException,  IOException
		{
			driver.get(url);
			
		}
		//METODO PRIMERA PRUEBA
		public void paginaPrincipal( File rutaCarpeta, String generarEvidencia)throws Exception
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
		    // BAJAR UN POCO EL SCROLL
		    js.executeScript("window.scrollBy(0,200)");
			//DAMOS CLICK EN ALERTAS
			click(btnAlertas, rutaCarpeta,generarEvidencia);
			//TIEMPO DE ESPERA
			tiempoEspera(2000);
			js.executeScript("window.scrollBy(0,200)");
			//DAMOS CLICK EN EL SIGUIENTE TAMBIEN DONDE DICE ALERTAS
			click(btnAlerta2, rutaCarpeta,generarEvidencia);
			tiempoEspera(2000);
		}
		
		

}

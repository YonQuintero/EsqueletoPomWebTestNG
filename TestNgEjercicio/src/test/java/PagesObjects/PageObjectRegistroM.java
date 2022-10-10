package PagesObjects;

import java.io.File;
import java.io.IOException;


import org.openqa.selenium.WebDriver;

import MapsObjects.MapObjectRegistroM;


public class PageObjectRegistroM extends MapObjectRegistroM
{
		//CREAR CONSTRUCTOR DE LA CLASE
		public PageObjectRegistroM(WebDriver driver)
		{
			super(driver);
		}
		//METODO INICIAL
		public void urlAcceso(String url)throws InterruptedException,  IOException
		{
			driver.get(url);
			
		}
		
		//METODO DE PRUEBA
		public void registroMercury( File rutaCarpeta, String generarEvidencia) throws Exception
		{
			tiempoEspera(2000);
			click(btnRegistro, rutaCarpeta,generarEvidencia);
		}
}

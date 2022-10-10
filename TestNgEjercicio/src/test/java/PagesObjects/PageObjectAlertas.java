package PagesObjects;



import java.io.File;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import MapsObjects.MapObjectAlertas;





public class PageObjectAlertas extends MapObjectAlertas
{
	//CREAR CONSTRUCTOR DE LA CLASE
		public PageObjectAlertas(WebDriver driver)
		{
			super(driver);
		}
		public void alertas( File rutaCarpeta, String generarEvidencia,String Nombre)throws Exception
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
		    // BAJAR UN POCO EL SCROLL
			js.executeScript("window.scrollBy(0,200)");
			
			//DAMOS CLICK EN LA PRIMERA ALERTA
			click(btnAlerta1, rutaCarpeta,generarEvidencia);
			tiempoEspera(2000);
			//DAMOS ACEPTAR 
			driver.switchTo().alert().accept();
			tiempoEspera(2000);
			//DAMOS CLICK EN LA SEGUNDA ALERTA
			click(btnAlertas2, rutaCarpeta,generarEvidencia);
			tiempoEspera(6000);
			//DAMOS ACEPTAR
			driver.switchTo().alert().accept();
			tiempoEspera(6000);
			//DAMOS CLICK EN LA TERCERA ALERTA
			click(btnAlerta3, rutaCarpeta,generarEvidencia);
			tiempoEspera(2000);
			//DAMOS ACEPTAR
			driver.switchTo().alert().accept();
			tiempoEspera(2000);
			//NUEVAMENTE INGRESAMOS A LA TERCERA ALERTA
			click(btnAlerta3, rutaCarpeta,generarEvidencia);
			tiempoEspera(4000);
			//DAMOS CANCELAR
			driver.switchTo().alert().dismiss();
			tiempoEspera(4000);
			//DAMOS CLICK EN LA CUARTA ALERTA
			click(btnAlerta4, rutaCarpeta,generarEvidencia);
			tiempoEspera(2000);
			//ENVIAMOS LA INFORMACIÓN
			driver.switchTo().alert().sendKeys(Nombre);
			//DAMOS ACEPTAR
			driver.switchTo().alert().accept();
			tiempoEspera(2000);
			//capturaPantalla(rutaCarpeta, null, generarEvidencia);
			
									
			
		}
}

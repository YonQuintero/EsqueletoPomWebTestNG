package MapsObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ClasesBase.ClaseBase;

public class MapObjectRegistroM extends ClaseBase
{	
		//CONSTRUCTOR DE LA CLASE
		public MapObjectRegistroM(WebDriver driver)
		{
			super(driver);
		}
		//ELEMENTOS PAGINA INICIAL
		protected By btnRegistro= By.xpath("//*[text()='REGISTER']");
	

}

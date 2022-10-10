package MapsObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ClasesBase.ClaseBase;

public class MapObjectCrearCuenta extends ClaseBase {

	public MapObjectCrearCuenta(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	//ELEMENTOS QUE VALIDAMOS PARA CONTINUAR CON LA CREACION DE CUENTA
		protected By terminosCondiciones=By.xpath("//*[@type='checkbox']");
		protected By btnContinuar=By.xpath("//*[@class='andes-button__content']");
		protected By btnValidar=By.xpath("//*[@class='andes-button__text']");
		protected By txtBusqueda1=By.xpath("//*[@type='email']");
}

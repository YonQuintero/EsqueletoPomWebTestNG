package MapsObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ClasesBase.ClaseBase;

public class MapObjectRegistro extends ClaseBase {

	public MapObjectRegistro(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	//ELEMENTOS QUE VALIDAMOS PARA CONTINUAR CON LA CREACION DE CUENTA
	    protected By linkCrear1Cuenta=By.xpath("//*[@data-link-id='registration']");
	    protected By linkEntendido=By.xpath("//button[@data-testid='action:understood-button']");
		protected By terminosCondiciones=By.xpath("//*[@type='checkbox']");
		protected By btnContinuar=By.xpath("//*[@class='andes-button__content']");
		protected By btnValidar=By.xpath("//*[@class='andes-button__text']");
		protected By txtBusqueda1=By.xpath("//*[@type='email']");
}

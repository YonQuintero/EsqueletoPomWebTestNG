package MapsObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ClasesBase.ClaseBase;


public class MapObjectHome extends ClaseBase {

	public MapObjectHome(WebDriver driver) {
		super(driver);
		
	}
	protected By txtBusqueda=By.xpath("//input[@Name='as_word']");
	protected By btnBuscar=By.name("btnk");
	protected By linkX=By.xpath("//*[@class='andes-tooltip-button-close']");
	protected By linkEntendido=By.xpath("//button[@data-testid='action:understood-button']");
	protected By btnPrimerResultado=By.xpath("(//img[@class='ui-search-result-image__element shops__image-element'])[1]");
	protected By linkCarrito= By.xpath("//button[@class='andes-button andes-spinner__icon-base andes-button--quiet']/span");
	protected By linkCrearCuenta=By.xpath("//*[text()='Crear cuenta']");
	protected By linkCrear1Cuenta=By.xpath("//*[@data-link-id='registration']");

}

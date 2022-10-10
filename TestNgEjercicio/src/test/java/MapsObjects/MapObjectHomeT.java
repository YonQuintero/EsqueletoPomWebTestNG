package MapsObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ClasesBase.ClaseBase;

public class MapObjectHomeT extends ClaseBase {

	//CONSTRUCTOR DE LA CLASE
	public MapObjectHomeT(WebDriver driver) {
		super(driver);
	}
	//ELEMENTOS PAGINA INICIAL
	protected By btnAlertas=By.xpath("//*[text()='Alerts, Frame & Windows']");
	protected By btnAlerta2=By.xpath("//span[text()='Alerts']");

}

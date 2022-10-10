package MapsObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ClasesBase.ClaseBase;

public class MapObjectAlertas extends ClaseBase {

	public MapObjectAlertas(WebDriver driver)
	{
	super(driver);
	}
	//ELEMENTOS PANTALLA DE ALERTAS
	protected By btnAlerta1=By.xpath("//button[@id='alertButton']");
	protected By btnAlertas2=By.xpath("//button[@id='timerAlertButton']");
	protected By btnAlerta3=By.xpath("//button[@id='confirmButton']");
	protected By btnAlerta4=By.xpath("//button[@id='promtButton']");
}

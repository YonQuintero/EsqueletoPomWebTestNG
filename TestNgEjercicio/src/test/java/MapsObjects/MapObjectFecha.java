package MapsObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ClasesBase.ClaseBase;

public class MapObjectFecha extends ClaseBase {
	//CONSTRUCTOR DE LA CLASE
	public MapObjectFecha(WebDriver driver)
	{
		super(driver);		
	}
	//ELEMENTOS DE LA PAGINA
	//protected By btnWidget=By.xpath("//*[text()='Widgets']");
	protected By btnWidget=By.xpath("(//div[@class='card-up'])[4]");
	protected By btnDataPicker=By.xpath("//*[text()='Date Picker']");
	protected By txtDate=By.xpath("//*[@id='datePickerMonthYearInput']");
	protected By btnMes=By.xpath("//*[@id='datePickerMonthYear']/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/select/option");
	protected By btnDia=By.xpath("//div[@aria-label='Choose Sunday, August 7th, 2022']");
	protected By btnFechaHora=By.xpath("//*[@id='dateAndTimePickerInput']");
	//protected By btnMeses=By.xpath("//*[@class='react-datepicker__month-dropdown-container react-datepicker__month-dropdown-container--scroll']/div/divv[8]");
	protected By btnAnte=By.xpath("//*[@class='react-datepicker__navigation react-datepicker__navigation--previous']");
	protected By btnDia1=By.xpath("//*[@aria-label='Choose Monday, August 8th, 2022']");
	protected By btnHora=By.xpath("//*[@id=\"dateAndTimePicker\"]/div[2]/div[2]/div/div/div[3]/div[2]/div/ul/li");
}

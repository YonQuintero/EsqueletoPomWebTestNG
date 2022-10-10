package PagesObjects;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;


import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import MapsObjects.MapObjectFecha;



public class PageObjectFecha extends MapObjectFecha {
	// CREAR CONSTRUCTOR DE LA CLASE
	public PageObjectFecha(WebDriver driver)

	{
		super(driver);
	}

	// METODO INICIAL
	public void urlAcceso(String url) throws InterruptedException, IOException {
		driver.get("url");

	}
	//METODO DE PRUEBA
	public void fechas2( File rutaCarpeta,String generarEvidencia)throws Exception
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    // BAJAR UN POCO EL SCROLL
	    js.executeScript("window.scrollBy(0,250)");
	    //DAMOS CLICK EN WIDGETS
	    click(btnWidget, rutaCarpeta,generarEvidencia);
	    // BAJAR UN POCO EL SCROLL
	    js.executeScript("window.scrollBy(0,400)");
	    //DAMOS CLICK EN DATAÍCKER
	    click(btnDataPicker, rutaCarpeta,generarEvidencia);
	    //DAR CLICK PARA SELECIONAR LA FECHA
	    //click(txtDate, rutaCarpeta);
	    tiempoEspera(2000);
	    //LIMPIAR CAJA DE TEXTO
	    borrar(txtDate, rutaCarpeta,generarEvidencia);
	    tiempoEspera(2000);
	    String fechas2 = fechaSistema();
	    String[] fechaVector= fechas2.split("-");
	    int dia= Integer.parseInt(fechaVector[0]);
	    int mes= Integer.parseInt(fechaVector[1]);
	    int anno= Integer.parseInt(fechaVector[2]);
	    dia=dia-1;
	    mes=mes-1;
	    anno=anno-1;
	    fechas2=dia+"/"+mes+"/"+anno;
	    sendkey(fechas2,txtDate, rutaCarpeta,generarEvidencia );
	    tiempoEspera(1000);
	    //DAMOS CLICK EN EL SIGUIENTE CUADRO DE FECHA
	    click(btnFechaHora, rutaCarpeta,generarEvidencia);
	    tiempoEspera(2000);
	    //LIMPIAR CAJA DE TEXTO
	    borrar(btnFechaHora, rutaCarpeta,generarEvidencia);
	    tiempoEspera(2000);
	    Month meses= LocalDate.now().minusMonths(1).getMonth();
	    fechas2=meses+"/"+dia+"/"+anno;
	    
	    sendkey(fechas2,btnFechaHora, rutaCarpeta ,generarEvidencia);
	    tiempoEspera(2000);
	    List<WebElement> hora= listaElementos(btnHora);
	    hora.get(63).click();
	    tiempoEspera(2000);
	    //capturaPantalla(rutaCarpeta,null, generarEvidencia);
	    
	}
}

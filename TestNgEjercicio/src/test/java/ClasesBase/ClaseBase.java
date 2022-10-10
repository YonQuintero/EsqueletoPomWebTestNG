package ClasesBase;

import java.io.File;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Utilidades.GenerarReportePdf;

public class ClaseBase {
	protected static WebDriver driver;
	//CONSTRUCTOR DE CLASE
		public ClaseBase(WebDriver driver)
		{
			super();
		}
		public void capturaPantalla(File rutaCarpeta,By locator, String generarEvidencia)throws Exception
		{
			
			String hora = HoraSistema();
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(rutaCarpeta+"\\"+hora+".png"));
			tiempoEspera(1000);
			String rutaImagen = new File(rutaCarpeta+"\\"+hora+".png").toString();
			
			//INSTANCIAMOS LA CLASE GENERAR PDF
			GenerarReportePdf informePdf = new GenerarReportePdf();
			//SE PROCEDE A INSERTAR LOCALIZADOR EN LA IMAGEN PDF
			informePdf.crearBody(locator, rutaImagen);
			
			//ELIMINAR IMAGEN CREADA
			eliminarArchivo(rutaImagen);
			}
		public void captureScreenError(File rutaCarpeta, By locator, String generarEvidencia, String msnError) throws Exception
	    {
	        if (generarEvidencia.equals("Si"))
	        {
	            String hora = HoraSistema();
	            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	            FileUtils.copyFile(scrFile, new File(rutaCarpeta+"\\"+hora+".png"));
	            String rutaImagen =new File(rutaCarpeta+"\\"+hora+".png").toString();
	            
	            //INSTACIAMOS LA CLASE GENERAR PDF
	            GenerarReportePdf informePdf = new GenerarReportePdf();
	            //SE PROCEDE A INSERTAR LOCALIZADOR HE IMAGEN EN EL PDF
	            informePdf.crearbodyError(locator,rutaImagen,msnError);
	            //ELIMINAR IMAGEN CREADA
	            
	            eliminarArchivo(rutaImagen);
	        }
	    }
		
		
		public File crearCarpeta(String nomTest)
		{
			//ALMACENAMOS LA FECHA DEL SISTEMA
			String fecha = fechaHora();
			//CREAMOS EL NOMBRE DE LA CARPETA
			String nomCarpeta = nomTest+"-"+fecha;
			//OBTENEMOS LA RUTA DE ALOJAMIENTO DE SALIDA Y EL NOMBRE DEL TEST A EJECUTAR
			File directorio = new File("./output/"+nomCarpeta);
			//CREAMOS LA CARPETA
			directorio.mkdir();
			return directorio;
		}
		
		public static String fechaHora()
		{
			//TOMAMOS LA FECHA DEL SISTEMA
			LocalDateTime fechaSistema = LocalDateTime.now();
			//DEFINIR FORMATO FECHA
			DateTimeFormatter fecha = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
			//DAR FORMATO A LA FECHA DEL SISTEMA
			String formatFecha = fecha.format(fechaSistema);
			return formatFecha;
		}
		public String fechaHora1()
		{
			//TOMAMOS LA FECHA DEL SISTEMA
			LocalDateTime fechaSistema = LocalDateTime.now();
			//DEFINIR FORMATO FECHA
			DateTimeFormatter fecha = DateTimeFormatter.ofPattern("MMddyyyy-HHmmss");
			//DAR FORMATO A LA FECHA DEL SISTEMA
			String formatFecha = fecha.format(fechaSistema);
			return formatFecha;
		}
		
		public String HoraSistema()
		{
			//TOMAMOS LA FECHA DEL SISTEMA
			LocalTime horaSistema = LocalTime.now();
			//DEFINIR FORMATO FECHA
			DateTimeFormatter fecha = DateTimeFormatter.ofPattern("HHmmss");
			//DAR FORMATO A LA FECHA DEL SISTEMA
			String hora = fecha.format(horaSistema);
			return hora;
		}
		public String fechaSistema()
		{
			//TOMAMOS LA FECHA DEL SISTEMA
			LocalDateTime fechaSistema = LocalDateTime.now();
			//DEFINIR FORMATO FECHA
			DateTimeFormatter fecha = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			//DAR FORMATO A LA FECHA DEL SISTEMA
			String formatFecha = fecha.format(fechaSistema);
			return formatFecha;
		}
		//METODO DE NAVEGADOR
		public static WebDriver chromeDriverConnection()
		{
			//SETEAR LAS OPCIONES DE NAVEGADOR
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			
			//SETEAR LAS PROPIEDADES DEL NAVEGADOR
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver2.exe");
			driver = new ChromeDriver();
			
			//MAXIMIZAR NAVEGADOR
			driver.manage().window().maximize();
			return driver;
		}
			
			//METODO CLICK
			public void click(By locator, File rutaCarpeta, String generarEvidencia) throws InterruptedException, Exception
			
			{
				try {
					capturaPantalla(rutaCarpeta, locator, generarEvidencia);
					driver.findElement(locator).click();
					tiempoEspera(1000);
				} catch (Exception e) {
					captureScreenError(rutaCarpeta, locator, generarEvidencia,e.toString());
					throw new InterruptedException();
				}
				
				
				
				
				
			}
			
			
			//TIEMPO DE ESPERA
			protected void tiempoEspera(long tiempo) throws InterruptedException 
			{
				
				Thread.sleep(tiempo);
				
			}
			
			//IMPRIMIR CONSOLA
			protected void imprimirConsola(Exception mensaje) throws InterruptedException 
			{
				
				System.out.println(mensaje);
			}

			//METODO BORRAR
			public void borrar(By locator, File rutaCarpeta,String generarEvidencia) throws Exception
			{
				driver.findElement(locator).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
				//driver.findElement(locator).clear();
				tiempoEspera(1000);
				capturaPantalla(rutaCarpeta,locator,generarEvidencia);
			}
			
			//METODO ENVIAR TEXTO
			public void sendkey(String inputText, By locator, File rutaCarpeta,String generarEvidencia) throws Exception
			{
				driver.findElement(locator).sendKeys(inputText);
				tiempoEspera(1000);
				capturaPantalla(rutaCarpeta,locator,generarEvidencia);
			}
			
			//METODO ENTER SUBMIT
			public void submit(By locator, File rutaCarpeta, String generarEvidencia) throws Exception
			{
				driver.findElement(locator).submit();
				tiempoEspera(1000);
				capturaPantalla(rutaCarpeta,locator, generarEvidencia);
			}
			public List<WebElement> listaElementos(By locator) throws Exception
	        {
	          
	            List<WebElement> elemento=driver.findElements(locator);
	            return elemento;
	            
	        }
			
			//METODO PARA REALIZAR UN SCROLL
			public void scroll(int y,int numMovimientos){
			    JavascriptExecutor js = (JavascriptExecutor) driver;
			    for (int i=0; i<=numMovimientos; i++) {
			        js.executeScript("window.scrollBy(0," + y + ")");
			}
			   			
			   
			}
			public static String fechaHora2()
			{
				//TOMAMOS LA FECHA DEL SISTEMA
				LocalDateTime fechaSistema = LocalDateTime.now();
				//DEFINIR FORMATO FECHA
				DateTimeFormatter fecha = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				//DAR FORMATO A LA FECHA DEL SISTEMA
				String formatFecha = fecha.format(fechaSistema);
				return formatFecha;
			}
			
			public void eliminarArchivo(String rutaImagen)
			{
				File fichero = new File(rutaImagen);
				fichero.delete();
			}
			public String obtenerTextoLocalizador(By locator) throws Exception
			{
				return(driver.findElement(locator).getText());	
			}
	}


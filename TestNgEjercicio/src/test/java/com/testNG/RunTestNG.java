package com.testNG;

import org.testng.annotations.Test;

import ClasesBase.ClaseBase;
import PagesObjects.PageObjectAlertas;
import PagesObjects.PageObjectCrearCuenta;
import PagesObjects.PageObjectDatosRegistro;
import PagesObjects.PageObjectFecha;
import PagesObjects.PageObjectHome;
import PagesObjects.PageObjectHomeT;
import PagesObjects.PageObjectRegistro;
import PagesObjects.PageObjectRegistroM;
import Utilidades.ExcelUtilidades;
import Utilidades.GenerarReportePdf;
import Utilidades.MyScreenRecorder;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;



import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterClass;

public class RunTestNG {
	WebDriver driver;
	PageObjectHome mercadoLibre;
	PageObjectCrearCuenta crearCuenta;
	PageObjectRegistro crearMiCuenta;
	PageObjectHomeT paginaPrincipal;
	PageObjectAlertas alertas;
	PageObjectFecha fecha;
	ClaseBase claseBase;
	PageObjectRegistroM registro;
    PageObjectDatosRegistro datosRegistro;
	GenerarReportePdf generarReportePdf;
	String rutaImagenMercadoLibre;
	String rutaImagenTools;
	@BeforeClass
	@Parameters({ "url", "rutaOutput","rutaImagenMercadoLibre","rutaImagenTools" })
	public void beforeClass(@Optional("default") String url,
							@Optional("default") String rutaOutput,
							@Optional("default") String rutaMercadoLibre,
							@Optional("default") String rutaTools)
	{

		//ASIGNAMOS LAS OPCIONES Y LA CONFIGURACION DEL NAVEGADOR A LA VARIABLE DRIVER
        driver= ClaseBase.chromeDriverConnection();
        claseBase = new ClaseBase(driver);
        mercadoLibre = new PageObjectHome(driver);
        crearCuenta = new PageObjectCrearCuenta(driver);
        crearMiCuenta = new PageObjectRegistro(driver);
        paginaPrincipal = new PageObjectHomeT(driver);
        alertas= new PageObjectAlertas(driver);
        fecha= new PageObjectFecha(driver);
        registro= new PageObjectRegistroM(driver);
        datosRegistro= new PageObjectDatosRegistro(driver);
        //AGREGAR IMAGEN EN EL ENCABEZADO DEL PDF
     	generarReportePdf= new GenerarReportePdf();
     	//generarReportePdf.setRutaImagen("./imagenes/LogoMercadoLibre.PNG");
     	rutaImagenMercadoLibre= rutaMercadoLibre;
     	rutaImagenTools= rutaTools;
     	
		
	}

	@DataProvider(name="busqueda")
	  public Object[][] datos() throws Exception
	  {
			Object[][] arreglo=ExcelUtilidades.getTableArray("./Data/MercadoLibre.xlsx", "mercadoLibre");
		      return arreglo; 
		
	 }

	@Test(dataProvider = "busqueda", priority=1)
	public void pruebaInicialTestNG( String ejecutarCaso, String generarEvidencia, String correo,String url, String producto) throws Exception {
			//OBTENER EL NOMBRE DEL METODO A EJECUTAR
    		String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
    		//CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
	    	File rutaCarpeta = claseBase.crearCarpeta( nomTest);
		if (ejecutarCaso.equals("Si")) {
			//ACCEDER AL METODO DE ABRIR PAGINA
			mercadoLibre.urlAcceso(url);
			
	    	if(generarEvidencia.contains("Si")) {
	    	//IMAGEN DEL ENCABEZADO	
	    	generarReportePdf.setRutaImagen(rutaImagenMercadoLibre);
	    	//INICIA GRABACION DEL VIDEO
	    	MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
	    	//INICIA CREACION DE REPORTE PDF
			generarReportePdf.crearPlantilla(nomTest, rutaCarpeta);
	    	// ACCEDER AL METODO DE PRUEBA INICIAL
	    	mercadoLibre.busquedaInicial(producto, rutaCarpeta,generarEvidencia);
	    	// ACCEDER AL METODO DE PRUEBA CREAR CUENTA
	    	crearCuenta.crearMiCuenta(correo, rutaCarpeta,generarEvidencia);
	    	//FINALIZA GRABACION DEL VIDEO
	      	MyScreenRecorder.stopRecording();
	        //FINALIZA CREACION DE REPORTE PDF
			generarReportePdf.cerrarPlantilla();
	    	}else
	    	{
	    		//ACCEDER AL METODO DE ABRIR PAGINA
				mercadoLibre.urlAcceso(url);
	    		// ACCEDER AL METODO DE PRUEBA INICIAL
		    	mercadoLibre.busquedaInicial(producto,rutaCarpeta, generarEvidencia);
		    	// ACCEDER AL METODO DE PRUEBA CREAR CUENTA
		    	crearCuenta.crearMiCuenta(correo, rutaCarpeta, generarEvidencia);
	    	}
		}else {
			System.out.println("La automatización no se ejecutara");
		}

	}
	@DataProvider(name="Registro")
	  public Object[][] datos1() throws Exception
	  {
			Object[][] arreglo=ExcelUtilidades.getTableArray("./Data/MercadoLibre.xlsx", "registro");
		      return arreglo; 
		
	 }
	@Test(dataProvider = "Registro", priority=2)
	public void Registro( String ejecutarCaso, String generarEvidencia, String correo,String url, String producto) throws Exception {
			//OBTENER EL NOMBRE DEL METODO A EJECUTAR
    		String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
    		//CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
	    	File rutaCarpeta = claseBase.crearCarpeta( nomTest);
		if (ejecutarCaso.equals("Si")) {
			//ACCEDER AL METODO DE ABRIR PAGINA
			mercadoLibre.urlAcceso(url);
			
	    	if(generarEvidencia.contains("Si")) {
	    	//IMAGEN DEL ENCABEZADO
	    	generarReportePdf.setRutaImagen(rutaImagenMercadoLibre);
	    	//INICIA GRABACION DEL VIDEO
	    	MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
	    	//INICIA CREACION DE REPORTE PDF
			generarReportePdf.crearPlantilla(nomTest, rutaCarpeta);
	    	// ACCEDER AL METODO DE PRUEBA INICIAL
			crearMiCuenta.crearCuenta(correo, rutaCarpeta, generarEvidencia);
	    	// ACCEDER AL METODO DE PRUEBA CREAR CUENTA
			crearMiCuenta.crearMiCuenta(correo, rutaCarpeta,generarEvidencia);
	    	//FINALIZA GRABACION DEL VIDEO
	      	MyScreenRecorder.stopRecording();
	        //FINALIZA CREACION DE REPORTE PDF
			generarReportePdf.cerrarPlantilla();
	    	}else
	    	{
	    		//ACCEDER AL METODO DE ABRIR PAGINA
				mercadoLibre.urlAcceso(url);
	    		// ACCEDER AL METODO DE PRUEBA INICIAL
		    	mercadoLibre.busquedaInicial(producto,rutaCarpeta, generarEvidencia);
		    	// ACCEDER AL METODO DE PRUEBA CREAR CUENTA
		    	crearCuenta.crearMiCuenta(correo, rutaCarpeta, generarEvidencia);
	    	}
		}else {
			System.out.println("La automatización no se ejecutara");
		}
	}
	@DataProvider(name="Alertas")
	  public Object[][] datos3() throws Exception
	  {
		Object[][] arreglo=ExcelUtilidades.getTableArray("./Data/MercadoLibre.xlsx", "tools");
		      return arreglo; 
	 }
	@Test(dataProvider = "Alertas", priority=3)
	public void alertas(String ejecutarCaso, String generarEvidencia,String url, String Nombre) throws Exception {
		
		if (ejecutarCaso.equals("Si")) {
			// OBTENER EL NOMBRE DEL METODO A EJECUTAR
			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
			// CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
			File rutaCarpeta = claseBase.crearCarpeta( nomTest);
			if(generarEvidencia.contains("Si")) {
		//IMAGEN DEL ENCABEZADO
		generarReportePdf.setRutaImagen(rutaImagenTools);		
		// ACCEDER A LA PAGINA PRINCIPAL
		paginaPrincipal.urlAcceso(url);
		//INICIA GRABACION DEL VIDEO
		MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
		//INICIA CREACION DE REPORTE PDF
		generarReportePdf.crearPlantilla(nomTest, rutaCarpeta);
		// ACCEDER AL METODO DE PRUEBA INICIAL
		paginaPrincipal.paginaPrincipal( rutaCarpeta, generarEvidencia);
		// ACCEDER A LOS METODOS DE ALERTAS
		alertas.alertas( rutaCarpeta, generarEvidencia, Nombre);
		//FINALIZA GRABACION DEL VIDEO
		MyScreenRecorder.stopRecording();
		//FINALIZA CREACION DE REPORTE PDF
		generarReportePdf.cerrarPlantilla();
			}else {
				// ACCEDER A LA PAGINA PRINCIPAL
				paginaPrincipal.urlAcceso(url);
				// ACCEDER AL METODO DE PRUEBA INICIAL
				paginaPrincipal.paginaPrincipal( rutaCarpeta, generarEvidencia);
				// ACCEDER A LOS METODOS DE ALERTAS
				alertas.alertas( rutaCarpeta, generarEvidencia, Nombre);
			}
		}else {
			System.out.println("La automatización no se ejecutara");
		}
	}
	@DataProvider(name="Widgets")
	  public Object[][] datos4() throws Exception
	  {
		Object[][] arreglo=ExcelUtilidades.getTableArray("./Data/MercadoLibre.xlsx", "fechas");
		      return arreglo; 
	 }
	@Test(dataProvider = "Widgets", priority=4)
	public void Widgets(String ejecutarCaso, String generarEvidencia,String url) throws Exception {
		
		if (ejecutarCaso.equals("Si")) {
			// OBTENER EL NOMBRE DEL METODO A EJECUTAR
			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
			// CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
			File rutaCarpeta = claseBase.crearCarpeta( nomTest);
			if(generarEvidencia.contains("Si")) {
		//IMAGEN DEL ENCABEZADO
		generarReportePdf.setRutaImagen(rutaImagenTools);
		// ACCEDER A LA PAGINA PRINCIPAL
		paginaPrincipal.urlAcceso(url);
		//INICIA GRABACION DEL VIDEO
		MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
		//INICIA CREACION DE REPORTE PDF
		generarReportePdf.crearPlantilla(nomTest, rutaCarpeta);
		// ACCEDER AL METODO DE PRUEBA INICIAL
		//paginaPrincipal.paginaPrincipal( rutaCarpeta, generarEvidencia);
		// ACCEDER A LOS METODOS DE ALERTAS
		fecha.fechas2(rutaCarpeta, generarEvidencia);
		//FINALIZA GRABACION DEL VIDEO
		MyScreenRecorder.stopRecording();
		//FINALIZA CREACION DE REPORTE PDF
		generarReportePdf.cerrarPlantilla();
			}else {
				// ACCEDER A LA PAGINA PRINCIPAL
				paginaPrincipal.urlAcceso(url);
				// ACCEDER AL METODO DE PRUEBA INICIAL
				//paginaPrincipal.paginaPrincipal( rutaCarpeta, generarEvidencia);
				// ACCEDER A LOS METODOS DE ALERTAS
				fecha.fechas2( rutaCarpeta, generarEvidencia);
			}
		}else {
			System.out.println("La automatización no se ejecutara");
		}
	}
	@DataProvider(name="Mercury")
	  public Object[][] datos5() throws Exception
	  {
		Object[][] arreglo=ExcelUtilidades.getTableArray("./Data/MercadoLibre.xlsx", "Mercury");
		      return arreglo; 
	 }
	@Test(dataProvider = "Mercury", priority=5)
	public void mercury(String ejecutarCaso, String generarEvidencia,String url,String Nombre, String Apellido, String Telefono,String email, String direccion, String ciudad, String pais,String codigopostal,String Lista,String usuario,String clave,String confirmacionclave) throws Exception {
		
		if (ejecutarCaso.equals("Si")) {
			// OBTENER EL NOMBRE DEL METODO A EJECUTAR
			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
			// CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
			File rutaCarpeta = claseBase.crearCarpeta( nomTest);
			if(generarEvidencia.contains("Si")) {
		//IMAGEN DEL ENCABEZADO
		generarReportePdf.setRutaImagen(rutaImagenTools);
		// ACCEDER A LA PAGINA PRINCIPAL
		registro.urlAcceso(url);
		//INICIA GRABACION DEL VIDEO
		MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
		//INICIA CREACION DE REPORTE PDF
		generarReportePdf.crearPlantilla(nomTest, rutaCarpeta);
		// ACCEDER AL METODO DE PRUEBA INICIAL
		registro.registroMercury(rutaCarpeta, generarEvidencia);
		// ACCEDER A LOS METODOS DE ALERTAS
		datosRegistro.datosRegistro( Nombre, Apellido, Telefono, email,  direccion, ciudad,  pais, codigopostal, Lista, usuario, clave, confirmacionclave,rutaCarpeta, generarEvidencia);
		//FINALIZA GRABACION DEL VIDEO
		MyScreenRecorder.stopRecording();
		//FINALIZA CREACION DE REPORTE PDF
		generarReportePdf.cerrarPlantilla();
			}else {
				// ACCEDER A LA PAGINA PRINCIPAL
				paginaPrincipal.urlAcceso(url);
				// ACCEDER AL METODO DE PRUEBA INICIAL
				//paginaPrincipal.paginaPrincipal( rutaCarpeta, generarEvidencia);
				// ACCEDER A LOS METODOS DE ALERTAS
				fecha.fechas2( rutaCarpeta, generarEvidencia);
			}
		}else {
			System.out.println("La automatización no se ejecutara");
		}
	}
	@AfterClass
	public void afterClass() {
		driver.close();
	}

}

package PagesObjects;

import static org.testng.Assert.assertEquals;

import java.io.File;



import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import MapsObjects.MapObjectDatosRegistro;


public class PageObjectDatosRegistro extends MapObjectDatosRegistro 
	
	{

	public PageObjectDatosRegistro(WebDriver driver) {
		super(driver);

	}
	public void datosRegistro( String Nombre, String Apellido, String Telefono,String email, String direccion, String ciudad, String pais,String codigopostal,String Lista,String usuario,String clave,String confirmacionclave,File rutaCarpeta, String generarEvidencia) throws Exception
	{
		// ENVIAR VALORES PARA EL REGISTRO
	    sendkey(Nombre, txtNombre, rutaCarpeta,generarEvidencia);
	    sendkey(Apellido, txtApellido, rutaCarpeta,generarEvidencia);
	    sendkey(Telefono, txtTelefono, rutaCarpeta,generarEvidencia);
	    sendkey(email, txtEmail, rutaCarpeta,generarEvidencia);
	    sendkey(direccion, txtDireccion, rutaCarpeta,generarEvidencia);
	    sendkey(ciudad, txtCiudad, rutaCarpeta,generarEvidencia);
	    sendkey(pais, txtPais, rutaCarpeta,generarEvidencia);
	    sendkey(codigopostal, txtCodigoPostal, rutaCarpeta,generarEvidencia);
	    click(btnLista, rutaCarpeta,generarEvidencia);
	    sendkey(Lista, btnLista, rutaCarpeta,generarEvidencia);
	    tiempoEspera(2000);
	    /*Select drpCountry = new Select(driver.findElement(By.name("country")));
	    drpCountry.selectByVisibleText("COLOMBIA");*/
		
	    sendkey(usuario, txtUsuario, rutaCarpeta,generarEvidencia);
	    sendkey(clave, txtClave, rutaCarpeta,generarEvidencia);
	    
	    sendkey(confirmacionclave, txtConfirmacionClave, rutaCarpeta,generarEvidencia);
	    //TIEMPO DE ESPERA
		tiempoEspera(2000);
		//DAMOS CLICK PARA ENVIAR LOS DATOS 
		click(btnEnviar, rutaCarpeta,generarEvidencia);
		//TIEMPO DE ESPERA
		//tiempoEspera(2000);
		//String aaa = "xxxxx"+obtenerTextoLocalizador(btnEnviar);
		//Assert.assertEquals(obtenerTextoLocalizador(txtConfirmacionClave), confirmacionclave,"Confirmación clave es igual, expected value");
		
		//System.out.println(aaa);
		
	}
}

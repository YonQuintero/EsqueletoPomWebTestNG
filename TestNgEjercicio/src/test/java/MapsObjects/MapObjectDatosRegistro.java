package MapsObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ClasesBase.ClaseBase;

public class MapObjectDatosRegistro extends ClaseBase {

	public MapObjectDatosRegistro(WebDriver driver) {
		super(driver);

	}

	// ELEMENTOS QUE VALIDAMOS PARA CONTINUAR CON EL REGISTRO
	protected By txtNombre = By.xpath("//input[@name='firstName']");
	protected By txtApellido = By.xpath("//input[@name='lastName']");
	protected By txtTelefono= By.xpath("//td/input[@name='phone']");
	protected By txtEmail= By.xpath("//input[@name='userName']");
	protected By txtDireccion= By.xpath("//input[@name='address1']");
	protected By txtCiudad= By.xpath("//input[@name='city']");
	protected By txtPais= By.xpath("//input[@name='state']");
	protected By txtCodigoPostal= By.xpath("//input[@name='postalCode']");
	protected By btnLista=By.name("country");
	protected By txtUsuario= By.xpath("//input[@name='email']");
	protected By txtClave= By.xpath("//input[@name='password']");
	protected By txtConfirmacionClave= By.xpath("//input[@name='confirmPassword']");
	protected By btnEnviar = By.xpath("//input[@name='submit']");
}

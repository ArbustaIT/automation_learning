package com.Arbusta.Steps;
import com.Arbusta.pagesobjects.FacebookAshokaPageObject;
import net.thucydides.core.annotations.Step;

public class FacebookAshokaSteps {

	FacebookAshokaPageObject Object;

	@Step
	public void Log(String strtxtUsuario, String strtxtContrasena, String strtxtBusqueda) {
		Object.open();
		Object.Login(strtxtUsuario, strtxtContrasena,strtxtBusqueda);

	}

}

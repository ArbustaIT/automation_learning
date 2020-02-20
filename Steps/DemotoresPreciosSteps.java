package com.Arbusta.Steps;
import com.Arbusta.pagesobjects.DemotoresPreciosPageObject;
import net.thucydides.core.annotations.Step;


public class DemotoresPreciosSteps {

	DemotoresPreciosPageObject Object;

	@Step
	public void Log(String strtxtUsuario, String strtxtContrasena, String strtxtBusqueda) {
		Object.open();
		Object.Login(strtxtUsuario, strtxtContrasena,strtxtBusqueda);

	}

}

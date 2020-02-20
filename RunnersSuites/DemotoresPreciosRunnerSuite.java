package com.Arbusta.RunnersSuites;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.Arbusta.Steps.DemotoresPreciosSteps;
import com.Arbusta.pagesobjects.DemotoresPreciosPageObject;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;



@RunWith(SerenityParameterizedRunner.class)


@UseTestDataFrom("dataDriven/DemotoresPrecios.csv")

public class DemotoresPreciosRunnerSuite {
	

	private String strtxtUsuario;
	private String strtxtContrasena;
	private String strtxtBusqueda;
	
	@Managed 
	DemotoresPreciosPageObject Object; 
	
	@Steps
	DemotoresPreciosSteps Steps;

	@Test
	public void Logueo() {
		Steps.Log(getstrtxtUsuario(),getstrtxtContrasena(),getstrtxtBusqueda());

	}

	public String getstrtxtUsuario() {
		return strtxtUsuario;
	}

	public void setstrtxtUsuario(String strtxtUsuario) {
		this.strtxtUsuario = strtxtUsuario;
	}

	public String getstrtxtContrasena() {
		return strtxtContrasena;
	}

	public void setstrtxtContrasena(String strtxtContrasena) {
		this.strtxtContrasena = strtxtContrasena;
	}

	public String getstrtxtBusqueda() {
		return strtxtBusqueda;
	}

	public void setstrtxtBusqueda(String strtxtBusqueda) {
		this.strtxtBusqueda = strtxtBusqueda;
	}
	
		
	}

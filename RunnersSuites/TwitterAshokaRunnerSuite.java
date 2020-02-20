package com.Arbusta.RunnersSuites;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.Arbusta.pagesobjects.TwitterAshokaPageObject;
import com.Arbusta.Steps.TwitterAshokaSteps;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;

@RunWith(SerenityParameterizedRunner.class)

@UseTestDataFrom("dataDriven/TwitterAshoka.csv")

public class TwitterAshokaRunnerSuite {
	
	private String strtxtUser;
	private String strtxtPass;
	private String strtxtSearch;
	private String strtxtKeywords;
	private String strtxtLanguage;
	private String strtxtSinceMonth;
	private String strtxtSinceDay;
	private String strtxtSinceYear;
	private String strtxtToMonth;
	private String strtxtToDay;
	private String strtxtToYear;
	
	@Managed 
	TwitterAshokaPageObject AshokaObject;
	
	@Steps
	TwitterAshokaSteps Steps;
	
	@Test
	public void BusquedaTwitter () {
		Steps.LoginTwitter(getstrtxtUser(),getstrtxtPass());
		Steps.Searching(getstrtxtSearch(), getstrtxtKeywords(), getstrtxtLanguage(), getstrtxtSinceMonth(), getstrtxtSinceDay(), 
				getstrtxtSinceYear(), getstrtxtToMonth(), getstrtxtToDay(), getstrtxtToYear());
	}
		public String getstrtxtUser() {
			return strtxtUser;
	}
		public void setstrtxtUser(String strtxtUser) {
			this.strtxtUser = strtxtUser;
	}
		public String getstrtxtPass() {
			return strtxtPass;
	}
		public void setstrtxtPass(String strtxtPass) {
			this.strtxtPass = strtxtPass;
	}
		public String getstrtxtSearch() {
			return strtxtSearch;
	}
		public void setstrtxtSearch(String strtxtSearch) {
			this.strtxtSearch = strtxtSearch;
	}
		public String getstrtxtKeywords() {
			return strtxtKeywords;
	}
		public void setstrtxtKeywords(String strtxtKeywords) {
			this.strtxtKeywords = strtxtKeywords;
	}
		public String getstrtxtLanguage() {
			return strtxtLanguage;
	}
		public void setstrtxtLanguage(String strtxtLanguage) {
			this.strtxtLanguage = strtxtLanguage;
	}
		public String getstrtxtSinceMonth() {
			return strtxtSinceMonth;
	}
		public void setstrtxtSinceMonth(String strtxtSinceMonth) {
			this.strtxtSinceMonth = strtxtSinceMonth;
	}
		public String getstrtxtSinceDay() {
			return strtxtSinceDay;
	}
		public void setstrtxtSinceDay(String strtxtSinceDay) {
			this.strtxtSinceDay = strtxtSinceDay;
	}
		public String getstrtxtSinceYear() {
			return strtxtSinceYear;
	}
		public void setstrtxtSinceYear(String strtxtSinceYear) {
			this.strtxtSinceYear = strtxtSinceYear;
	}
		public String getstrtxtToMonth() {
			return strtxtToMonth;
	}
		public void setstrtxtToMonth(String strtxtToMonth) {
			this.strtxtToMonth = strtxtToMonth;
	}
		public String getstrtxtToDay() {
			return strtxtToDay;
	}
		public void setstrtxtToDay(String strtxtToDay) {
			this.strtxtToDay = strtxtToDay;
	}
		public String getstrtxtToYear() {
			return strtxtToYear;
	}
		public void setstrtxtToYear(String strtxtToYear) {
			this.strtxtToYear = strtxtToYear;
	}
}

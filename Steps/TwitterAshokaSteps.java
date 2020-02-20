package com.Arbusta.Steps;

import com.Arbusta.pagesobjects.TwitterAshokaPageObject;
import net.thucydides.core.annotations.Step;
public class TwitterAshokaSteps {
	TwitterAshokaPageObject AshokaObject;
	@Step
	public void LoginTwitter(String strtxtUser, String strtxtPass) {
		AshokaObject.open();
		AshokaObject.Login(strtxtUser, strtxtPass);
	}
	@Step
	public void Searching(String strtxtSearch, String strtxtKeywords, String strtxtLanguage, String strtxtSinceMonth, String strtxtSinceDay, String strtxtSinceYear, 
			String strtxtToMonth, String strtxtToDay, String strtxtToYear) {
		AshokaObject.open();
		AshokaObject.Search(strtxtSearch, strtxtKeywords, strtxtLanguage, strtxtSinceMonth, strtxtSinceDay, strtxtSinceYear, strtxtToMonth, strtxtToDay, strtxtToYear);
	}
}
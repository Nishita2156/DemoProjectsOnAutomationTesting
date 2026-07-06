package com.etsy.hooks;

import com.etsy.base.Base;

public class Hooks extends Base{
	public void openBrowser() {
		setUp();
	}
	public void tearDown() {
		closeBrowser();
	}

}

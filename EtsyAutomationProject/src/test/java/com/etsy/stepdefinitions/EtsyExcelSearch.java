package com.etsy.stepdefinitions;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.etsy.base.Base;
import com.etsy.pages.EtsyHomePage;
import com.etsy.pages.EtsySearchResultPage;
import com.etsy.utils.ExcelUtils;
import com.etsy.utils.StepsLogger;

import io.cucumber.java.en.Then;


public class EtsyExcelSearch  extends Base{
	EtsyHomePage homePage;
	EtsySearchResultPage SearchResultPage;
	
	@Then("user searches all products from Excel sheets and validates results")
	public void user_searches_all_products_from_excel_sheets(WebDriver dr) {
		String step = "Then user searches and validates Excel-driven products";
		try {
			String excelPath = "src/test/resources/testdata/AmazonSearchData.xlsx";
			List<String> products = ExcelUtils.getProductsFromExcel(excelPath, "Sheet1");

			for (String product : products) {
				homePage.searchProduct(product);
				Assert.assertTrue(SearchResultPage.getSearchResultText().toLowerCase().contains(product.toLowerCase()),
						" Search result validation failed for: " + product);
				StepsLogger.logPass("🔍 Verified search result for: " + product);
			}

			StepsLogger.logPass(step);
		} catch (Exception e) {
			StepsLogger.logFail(step, e, dr);
			throw e;
		}
	}

}

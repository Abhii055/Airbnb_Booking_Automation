//package airbnb_testing;
//import java.time.Duration;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.*;
//
//public class Airbnb_Test {
//
//	String url ="https://www.airbnb.co.in/?locale=en&_set_bev_on_new_domain=1699857300_NTYzM2YzYjNmOTUx";
//	WebDriver driver;
//	@Test
//	public void invokeBrowser() {
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\abhin\\eclipse-workspace\\libs\\chromedriver.exe");
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
//		driver.get(url);
//	}
//	@Test(dependsOnMethods = "invokeBrowser")
//	public void setLocation() {
//
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));	
//		   JavascriptExecutor js = (JavascriptExecutor) driver;
//		
//		WebElement locationInput = driver.findElement(By.id("bigsearch-query-location-input"));
//		locationInput.clear();
//		locationInput.click();
//		locationInput.sendKeys("Kasol, Himachal Pradesh");
//
//		WebElement confirmationBtn  =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='s152dg4g atm_c8_2x1prs atm_fr_11a07z3 atm_cs_6adqpa atm_7l_dezgoh atm_g3_1jbyh58 atm_ks_15vqwwr atm_sq_1l2sidv atm_9s_cj1kg8 atm_6w_1e54zos atm_fy_ouytup atm_ks_zryt35__1rgatj2 dir dir-ltr']")));
//		confirmationBtn.click();
//
//
//	
//		 WebElement checkInElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@data-testid, 'structured-search-input-field-split-dates-0')]")));
//	        checkInElement.click();
//
//	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='structured-search-input-field-dates-panel']")));
//	        
//	        WebElement entryDate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-testid='calendar-day-2024-07-15']")));
//	        js.executeScript("arguments[0].scrollIntoView(true);", entryDate);
//	        js.executeScript("arguments[0].click();", entryDate);
//	}
//
//	//		@Test(dependsOnMethods = "invokeBrowser")
//	public void closeBrowser() {
//		driver.navigate().refresh();
//		driver.close();
//	}
//
//}



package airbnb_testing;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class Airbnb_Test {

	String url = "https://www.airbnb.co.in/?locale=en&_set_bev_on_new_domain=1699857300_NTYzM2YzYjNmOTUx";
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\abhin\\eclipse-workspace\\libs\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
	}

	@Test
	public void invokeBrowser() {
		driver.get(url);
	}

	@Test(dependsOnMethods = "invokeBrowser")
	public void setLocation() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement locationInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("bigsearch-query-location-input")));
		locationInput.clear();
		locationInput.sendKeys("Kasol");

		WebElement suggestion = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='s152dg4g atm_c8_2x1prs atm_fr_11a07z3 atm_cs_6adqpa atm_7l_dezgoh atm_g3_1jbyh58 atm_ks_15vqwwr atm_sq_1l2sidv atm_9s_cj1kg8 atm_6w_1e54zos atm_fy_ouytup atm_ks_zryt35__1rgatj2 dir dir-ltr']")));
		suggestion.click();
		//---------------------------------------DATE - check_IN-----------
		WebElement checkInElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@data-testid, 'structured-search-input-field-split-dates-0')]")));
		checkInElement.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='structured-search-input-field-dates-panel']")));

		WebElement entryDate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-testid='calendar-day-15/07/2024']")));
		entryDate.click();

		//=====--------------------------DATE - check_OUT-------------------------
		WebElement checkInElementExit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@data-testid, 'structured-search-input-field-split-dates-1')]")));
		checkInElementExit.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='structured-search-input-field-dates-panel']")));

		WebElement exitDate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-testid='calendar-day-20/07/2024']")));
		exitDate.click();


		driver.findElement(By.xpath("//span[@class='t1dqvypu atm_9s_1ulexfb atm_vy_1osqo2v atm_e2_1osqo2v atm_jb_uuw12j atm_2w_1egmwxu atm_k4_idpfg4 atm_uc_kn5pbq atm_2g_1mygper atm_k4_kb7nvz_1nos8r atm_uc_yz1f4_csw3t1 atm_k4_idpfg4_csw3t1 atm_tr_kftzq4_csw3t1 dir dir-ltr']")).click();
	}
	
	@Test(dependsOnMethods= "setLocation")
	public void applyingFilter() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// Filter set(Amazing view)
		WebElement addingFilter = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-testid='category-item--Amazing views--unchecked']")));
		addingFilter.click();	
	}
	
	@Test(dependsOnMethods="applyingFilter")
	public void bookingFirstHotel() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		//selecting first hotel
		WebElement booking = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='lxq01kf atm_9s_1txwivl atm_am_kyuy1d atm_ar_d67k9l l1tup9az atm_1p4glcj_1bp4okc dir dir-ltr']")));
		booking.click();
	}
	
	@Test(dependsOnMethods="bookingFirstHotel")
	public void changeLanguage()throws InterruptedException {
		//trying to change the language	

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement languageCurrencyButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='lloffz7 atm_h_1h6ojuz atm_9s_1txwivl atm_e2_1osqo2v atm_mk_h2mmj6 atm_wq_kb7nvz dir dir-ltr']/div[@class='_z5mecy']")));
		Thread.sleep(10000);
		languageCurrencyButton.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='p1psejvv atm_9s_1bgihbq dir dir-ltr']/div[@class='di536pa atm_ks_zryt35 atm_mk_h2mmj6 atm_26_1qwqy05 atm_vy_auwlz6 atm_j3_auwlz6 atm_iy_1osqo2v atm_9s_1txwivl atm_ar_1bp4okc atm_70_rgs8xj atm_6a_kitwna atm_6c_kitwna atm_16_kb7nvz atm_12_1hrf63d atm_1c_1kxd9fs atm_1k_1v897lg atm_y_t52gbv atm_tw_uaqxkr atm_im2n7a_1osqo2v atm_189k8xb_1osqo2v atm_ks_15vqwwr__1yj3dog atm_kd_glywfm_pfnrn2 atm_vy_1osqo2v__oggzyc atm_5j_kitwna__oggzyc atm_16_kb7nvz__oggzyc atm_12_1hrf63d__oggzyc atm_1c_1o0sogo__oggzyc atm_y_vegxqt__oggzyc atm_1k_so3mv5__oggzyc atm_tw_uaqxkr__oggzyc atm_im2n7a_n7od8j__oggzyc atm_189k8xb_n7od8j__oggzyc atm_1c_18bdofy__1rrf6b5 atm_y_t0utr__1rrf6b5 atm_1k_1ar7sfh__1rrf6b5 atm_j3_6tyhld__oggzyc dclclpo dir dir-ltr']")));
		driver.findElement(By.xpath("//div[text()='Azərbaycan']")).click();

		
	}


	@Test(dependsOnMethods ="changeLanguage")
	public void reserveHotel() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement Reserve = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='lloffz7 atm_h_1h6ojuz atm_9s_1txwivl atm_e2_1osqo2v atm_mk_h2mmj6 atm_wq_kb7nvz dir dir-ltr']/div[@class='_z5mecy']")));
		Reserve.click();	

		WebElement increaseGuest = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='stepper-adults-increase-button']")));
		increaseGuest.click();
	}
	
	//    @AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}





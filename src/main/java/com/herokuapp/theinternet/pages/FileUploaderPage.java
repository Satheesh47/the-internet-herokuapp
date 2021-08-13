package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploaderPage extends BasePageObject {
	
	private String pageURL = "http://the-internet.herokuapp.com/upload";
	private By uploadButtonLocator = By.id("file-submit");
	private By chooseFileFieldLocator = By.id("file-upload");
	private By uploadedFilesLocator = By.id("uploaded-files");

	public FileUploaderPage(WebDriver driver, Logger log)
	{
		super(driver, log);
	}
	
	public void openPage()
	{
		log.info("Opening page: " + pageURL);
		openUrl(pageURL);
		log.info("Page opened ..");
	}
	
	public void selectFile(String fileName)
	{
		log.info("Selecting '" + fileName + "' file from Files folder ...");
		String filePath = System.getProperty("user.dir") + "//src//main//resources//files//" + fileName;
		type(filePath,chooseFileFieldLocator);
		log.info("File selected");
	}
	
	public void pushUploadButton()
	{
		log.info("Clicking on upload button ..");
		click(uploadButtonLocator);
	}
	
	public String getUploadedFilesNames()
	{
		String names = find(uploadedFilesLocator).getText();
		log.info("Uploaded file name: " + names);
		return names;
	}

}

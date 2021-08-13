package com.herokuapp.theinternet.uploadtests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.FileUploaderPage;

public class UploadTests extends TestUtilities {
	@Test
	public void imageUploadTest() {
		log.info("Starting imageUploadTest ..");

		// Open File Uploader page
		FileUploaderPage fileUploaderPage = new FileUploaderPage(driver, log);
		fileUploaderPage.openPage();

		// Select file
		String fileName = "logo.png";
		fileUploaderPage.selectFile(fileName);

		// Push Upload button
		fileUploaderPage.pushUploadButton();

		String fileNames = fileUploaderPage.getUploadedFilesNames();

		// File name validation
		Assert.assertTrue(fileNames.contains(fileName),
				"Our file (" + fileName + ")is not one of the uploaded (" + fileNames + ")");

	}
}
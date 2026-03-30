package tests.ui;

import com.project.qa.pages.FileDownloadPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.io.File;

public class FileDownloadTest extends BaseTest {

    @Test
    public void testFileDownload() throws InterruptedException {
        FileDownloadPage downloadPage = new FileDownloadPage();
        downloadPage.open();

        // Download the first file dynamically and get its name
        String fileName = downloadPage.downloadFirstFile();

        // Define the path (same as in DriverFactory)
        String downloadPath = System.getProperty("user.dir") + File.separator + "target" + File.separator + "downloads";
        File downloadedFile = new File(downloadPath + File.separator + fileName);

        // Wait for file to appear (Downloads can be slow)
        boolean isPresent = false;
        for (int i = 0; i < 15; i++) {
            if (downloadedFile.exists() && downloadedFile.length() > 0) {
                isPresent = true;
                break;
            }
            Thread.sleep(1000);
        }

        Assert.assertTrue(isPresent, "Downloaded file not found: " + fileName);

        // Clean up
        if(isPresent) downloadedFile.delete();
    }
}

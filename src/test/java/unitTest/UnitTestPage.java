package unitTest;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

import org.testng.annotations.Test;

import geico.tdd.utils.HomeData;

public class UnitTestPage {
	@Test(enabled = false)
	public void unitTestHomeDataNull() {
		HomeData homeData = new  HomeData(null, "test", null, null);
		System.out.println(homeData.getZipCode2());
	}
	@Test(enabled = false)
	public void unitTestHomeDataZoroLeanth() {
		HomeData homeData = new HomeData("10467", "", null, null);
		System.out.println(homeData.getGetAHQPageTitle());
	}
	
	@Test(enabled = false)
	public void system_getPropertyTest() {
		System.out.println(System.getProperty("java.home"));
	}
	@Test(enabled = false)
	public void folderOps() {
		File folder =  new File("screenShot/ss1/ss2");
		System.out.println(folder.getAbsolutePath());
		System.out.println(folder.mkdirs());
		
	}
	@Test(enabled = true)
	public void timeUnitTest() {
		Date date = new Date();
		System.out.println(date);
		Instant time = Instant.now();
		System.out.println(time);
		
		System.out.println(LocalDateTime.now().plusYears(1));
		System.out.println("Test1" +time + ".png");
		SimpleDateFormat date_Format = new SimpleDateFormat("MM/dd/YYYY_hh:mm:ss");
		System.out.println(date_Format.format(date));
		
	}
	
}

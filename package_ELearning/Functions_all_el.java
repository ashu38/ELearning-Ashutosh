package package_ELearning;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Functions_all_el {	
	WebDriver driver;
	public int x=50, z=10;
	public String exp_text, exp_text2, exp_text3, act_res5, exp_txt, del, act_res20, act_res40;
	public String act_result;
	public void launch_page_el(){
		

		System.setProperty("webdriver.chrome.driver","E:\\New folder\\ProjAshutosh\\Driver\\chromedriver74.exe");
		 driver = new ChromeDriver(); 
		driver.get("http://elearningm1.upskills.in");
		
		driver.findElement(By.xpath("//*[@id='login-block']/div/ul/li[1]/a")).click();
	}
	
	public String register_teacher(String t_fname, String t_lname, String t_email, String t_uname, String t_pass1, String t_pass2, String t_phone, String lang){
	
		driver.findElement(By.xpath("//*[@id='status-group']/div[1]/div[2]")).click();
		driver.findElement(By.xpath("//*[@id='registration_firstname']")).sendKeys(t_fname);
		driver.findElement(By.xpath("//*[@id='registration_lastname']")).sendKeys(t_lname);
		driver.findElement(By.xpath("//*[@id='registration_email']")).sendKeys(t_email);
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys(t_uname);
		driver.findElement(By.xpath("//*[@id='pass1']")).sendKeys(t_pass1);
		driver.findElement(By.xpath("//*[@id='pass2']")).sendKeys(t_pass2);
		driver.findElement(By.xpath("//*[@id='registration_phone']")).sendKeys(t_phone);
		 
		WebElement we = driver.findElement(By.xpath("//*[@id='registration_language']"));
		Select sel = new Select(we);
		sel.selectByVisibleText(lang);
		driver.findElement(By.xpath("//*[@id='registration_submit']")).click();
		
		
		exp_text = driver.findElement(By.xpath("//*[@id='cm-content']/div/div/div/p[1]")).getText();
		return exp_text;
	}
	
	
	public String read_excel(int r, int c, String sheetname) throws IOException{
		String s;
			File f = new File("C:\\Users\\IBM\\Desktop\\Testing stuff\\registration.xlsx");
			FileInputStream fis = new FileInputStream(f);
		
		XSSFWorkbook xw = new XSSFWorkbook(fis);
		XSSFSheet xs = xw.getSheet(sheetname);
		XSSFRow xr = xs.getRow(r);
		XSSFCell cx = xr.getCell(c);
		
		s= cx.getStringCellValue(); 
		return(s);	
		}
	
	public String login_as_teacher(String uname, String pass, String c_name, String category, String code, String lang){
		
		System.setProperty("webdriver.chrome.driver","E:\\New folder\\ProjAshutosh\\Driver\\chromedriver74.exe");
		 driver = new ChromeDriver(); 
		driver.get("http://elearningm1.upskills.in/index.php");
		driver.findElement(By.xpath("//*[@id='login']")).sendKeys(uname);
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys(pass);
		driver.findElement(By.xpath("//*[@id='form-login_submitAuth']")).click();

		driver.findElement(By.xpath("//*[@id='coursesCollapse']/div/ul/li[1]/a")).click();
		driver.findElement(By.xpath("//*[@id='title']")).sendKeys(c_name);
		driver.findElement(By.xpath("//*[@id='advanced_params']")).click();
		
		driver.findElement(By.xpath("//*[@id='advanced_params_options']/div[1]/div[1]/div/button")).click();
		driver.findElement(By.xpath("//*[@id='advanced_params_options']/div[1]/div[1]/div/div/ul/li[8]/a/span[1]")).click();
		
		driver.findElement(By.xpath("//*[@id='add_course_wanted_code']")).sendKeys(code);
		
		driver.findElement(By.xpath("//*[@id='advanced_params_options']/div[3]/div[1]/div/button")).click();
		driver.findElement(By.xpath("//*[@id='advanced_params_options']/div[3]/div[1]/div/div/ul/li[6]/a/span[1]")).click();
		
		driver.findElement(By.xpath("//*[@id='add_course_submit']")).click();
		
		//driver.findElement(By.xpath("//*[@id='course_tools']/div[1]/div/div[2]/div/a[1]")).click();
		
		//WebDriverWait wait = new WebDriverWait(driver,6);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='introduction_text']/fieldset/div[1]/div[1]")));
		
		//driver.findElement(By.xpath("//*[@id='intro_content']")).sendKeys(text);
		
		//driver.findElement(By.xpath("//*[@id='introduction_text_intro_cmdUpdate']")).click();
		//*[@id="introduction_text_intro_cmdUpdate"]
		
		exp_text2 = driver.findElement(By.xpath("//*[@id='cm-content']/div/ul/li/a")).getText();
		System.out.println(exp_text2);
		return exp_text2;
	}
	
	public String change_pass(String uname, String pass, String new_pass){
		
		System.setProperty("webdriver.chrome.driver","E:\\New folder\\ProjAshutosh\\Driver\\chromedriver74.exe");
		 driver = new ChromeDriver(); 
		driver.get("http://elearningm1.upskills.in/index.php");
		driver.findElement(By.xpath("//*[@id='login']")).sendKeys(uname);
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys(pass);
		driver.findElement(By.xpath("//*[@id='form-login_submitAuth']")).click();
		
		driver.findElement(By.xpath("//*[@id='profileCollapse']/div/ul/li[4]/a")).click();

		driver.findElement(By.xpath("//*[@id='profile_password0']")).sendKeys(pass);
		
		driver.findElement(By.xpath("//*[@id='password1']")).sendKeys(new_pass);
		
		driver.findElement(By.xpath("//*[@id='profile_password2']")).sendKeys(new_pass);
		
		exp_text3 = driver.findElement(By.xpath("//*[@id='cm-content']/div/div/div/div[1]")).getText();
		//*[@id="cm-content"]/div/div/div/div[1]
		driver.findElement(By.xpath("//*[@id='profile_apply_change']")).click();
		
		return exp_text3;
		
	}
	
	 public String create_user_admin(String uname, String pass, String Title, String code){
		 
		 System.setProperty("webdriver.chrome.driver","E:\\New folder\\ProjAshutosh\\Driver\\chromedriver74.exe");
		 driver = new ChromeDriver(); 
		driver.get("http://elearningm1.upskills.in/index.php");
		driver.findElement(By.xpath("//*[@id='login']")).sendKeys(uname);
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys(pass);
		driver.findElement(By.xpath("//*[@id='form-login_submitAuth']")).click();
		
		
		driver.findElement(By.xpath("//*[@id='tabs-2']/div/div[2]/div[2]/ul/li[2]/a")).click();
		
		driver.findElement(By.xpath("//*[@id='update_course_title']")).sendKeys(Title);
		
		driver.findElement(By.xpath("//*[@id='visual_code']")).sendKeys(code);
		
		driver.findElement(By.xpath("//*[@id='update_course']/fieldset/div[3]/div[1]/div/button/span[1]")).click();
		driver.findElement(By.xpath("//*[@id='update_course']/fieldset/div[3]/div[1]/div/div/ul/li[3]/a")).click();
		
		/*driver.findElement(By.xpath("//*[@id='select2-course_teachers-results']/li")).sendKeys(teacher);
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='select2-course_teachers-results']/li[1]")));
		driver.findElement(By.xpath("//*[@id='select2-course_teachers-results']/li[1]")).click();*/
		
		driver.findElement(By.xpath("//*[@id='update_course']/fieldset/div[7]/div[1]/div/button/span[1]")).click();
		driver.findElement(By.xpath("//*[@id='update_course']/fieldset/div[7]/div[1]/div/div/ul/li[6]/a/span[1]")).click();
		
		driver.findElement(By.xpath("//*[@id='update_course_submit']")).click();
		
		String act_res5 = driver.findElement(By.xpath("//*[@id='cm-content']/div/div/div/div[2]/a")).getText();
		
		return act_res5;
		
	 }
	 
	 public String delete_class(String uname, String pass, String del) throws InterruptedException{
		
		 System.setProperty("webdriver.chrome.driver","E:\\New folder\\ProjAshutosh\\Driver\\chromedriver74.exe");
		 driver = new ChromeDriver(); 
		driver.get("http://elearningm1.upskills.in/index.php");
		driver.findElement(By.xpath("//*[@id='login']")).sendKeys(uname);
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys(pass);
		driver.findElement(By.xpath("//*[@id='form-login_submitAuth']")).click();
		
		driver.findElement(By.xpath("//*[@id='tabs-1']/div/div[2]/div[2]/ul/li[7]/a")).click();
		
		Thread.sleep(7000);
		
		driver.findElement(By.xpath("//*[@id='"+ x +"']/td[6]/a[5]/img")).click();
		Alert alert1 = driver.switchTo().alert();
		alert1.accept();
		x++;
		
		return "deleted";
	 }
	 
	 public String rate(String uname, String pass, String msg) throws InterruptedException{
		 
		 System.setProperty("webdriver.chrome.driver","E:\\New folder\\ProjAshutosh\\Driver\\chromedriver74.exe");
		 driver = new ChromeDriver(); 
		driver.get("http://elearningm1.upskills.in/index.php");
		driver.findElement(By.xpath("//*[@id='login']")).sendKeys(uname);
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys(pass);
		driver.findElement(By.xpath("//*[@id='form-login_submitAuth']")).click();
		 
		driver.findElement(By.xpath("//*[@id='page']/div/div[1]/div/div/div[2]/h4/a")).click();
		
		driver.findElement(By.xpath("//*[@id='istooldesc_3622']")).click();
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id='9']/td[3]/a")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='"+ z +"']/td[6]/div/a[2]/img")).click();
		z=z+3;
		
		Thread.sleep(8000);
		driver.switchTo().frame((WebElement)driver.findElement(By.xpath("//*[@id='cke_1_contents']/iframe")));
		driver.findElement(By.xpath("/html/body")).sendKeys(msg);
		driver.switchTo().defaultContent();
		
		driver.findElement(By.xpath("//*[@id='work_comment_button']")).click();
		
		String act_res = driver.findElement(By.xpath("//*[@id='cm-content']/div/div[2]/div/div[3]")).getText();
		return act_res;
	 }
	 
	 public String tc_39(String uname, String pass, String name) throws InterruptedException{
		 
		 System.setProperty("webdriver.chrome.driver","E:\\New folder\\ProjAshutosh\\Driver\\chromedriver74.exe");
		 driver = new ChromeDriver(); 
		driver.get("http://elearningm1.upskills.in/index.php");
		driver.findElement(By.xpath("//*[@id='login']")).sendKeys(uname);
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys(pass);
		driver.findElement(By.xpath("//*[@id='form-login_submitAuth']")).click();
		
		driver.findElement(By.xpath("//*[@id='navbar']/ul[1]/li[4]/a")).click();
		
		driver.findElement(By.xpath("//*[@id='search_user_keyword']")).sendKeys(name);
		
		driver.findElement(By.xpath("//*[@id='search_user_submit']")).click();
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("//td[5]/a/img")).click();
		
		driver.findElement(By.xpath("//*[@id='cm-content']/div/div[3]/table/tbody/tr[1]/td[7]/a")).click();
		
		driver.findElement(By.xpath("//*[@id='cm-content']/div/div[4]/table/tbody/tr/td[5]/a")).click();
		//*[@id="qf_f49408"]
		driver.findElement(By.name("send_notification")).click();
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id='form-email_submit']")).click();
		
		act_res20 = driver.findElement(By.xpath("//*[@id='cm-content']/div/div[2]")).getText();
		
		return act_res20;
	 }
	 
	 public String report(String uname, String pass) throws InterruptedException{
		 
		 System.setProperty("webdriver.chrome.driver","E:\\New folder\\ProjAshutosh\\Driver\\chromedriver74.exe");
		 driver = new ChromeDriver(); 
		driver.get("http://elearningm1.upskills.in/index.php");
		driver.findElement(By.xpath("//*[@id='login']")).sendKeys(uname);
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys(pass);
		driver.findElement(By.xpath("//*[@id='form-login_submitAuth']")).click();
		
		driver.findElement(By.xpath("//*[@id='navbar']/ul[1]/li[4]/a")).click();
		
		driver.findElement(By.xpath("//*[@id='search_user_submit']")).click();
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("//td[5]/a/img")).click();
		
		driver.findElement(By.xpath("//*[@id='cm-content']/div/div[3]/table/tbody/tr[1]/td[7]/a")).click();
		
		driver.findElement(By.xpath("//*[@id='cm-content']/div/div[4]/table/tbody/tr/td[5]/a")).click();
		//*[@id="qf_f49408"]
		driver.findElement(By.name("send_notification")).click();
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id='form-email_submit']")).click();
		
		act_res40 = driver.findElement(By.xpath("//*[@id='cm-content']/div/div[2]")).getText();
		
		driver.findElement(By.xpath("//*[@id='cm-content']/div/ul/li[1]/a")).click();
		
		return act_res40;
		 
	 }
	 
	 public String giveExam(String uname, String pass, String c_name) throws InterruptedException{
		 
		 System.setProperty("webdriver.chrome.driver","E:\\New folder\\ProjAshutosh\\Driver\\chromedriver74.exe");
		 driver = new ChromeDriver(); 
		driver.get("http://elearningm1.upskills.in/index.php");
		driver.findElement(By.xpath("//*[@id='login']")).sendKeys(uname);
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys(pass);
		driver.findElement(By.xpath("//*[@id='form-login_submitAuth']")).click();
		
		driver.findElement(By.xpath("//*[@id='coursesCollapse']/div/ul/li[3]/a")).click();
		
		driver.findElement(By.xpath("//*[@id='cm-content']/div/div[1]/div/div/div/div[1]/form/div/input")).sendKeys(c_name);
		
		driver.findElement(By.xpath("//*[@id='cm-content']/div/div[1]/div/div/div/div[1]/form/div/div/button")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='cm-content']/div/div[2]/div/div/div[2]/div[1]/h4/a")).click();
		
		driver.findElement(By.xpath("//*[@id='course-info-bottom']/div/div[2]/div[1]/div/div/a")).click();
		
		//act_result = driver.findElement(By.xpath("//*[@id='messages']/div")).getText();
		
		driver.findElement(By.xpath("//*[@id='toolimage_3625']")).click();
		
		driver.findElement(By.xpath("//*[@id='gradebook_list']/tbody/tr[2]/td[2]/a")).click();
		
		driver.findElement(By.xpath("//*[@id='cm-content']/div/div/div[1]/div/a")).click();
		
		if(driver.findElement(By.xpath("//*[@id='cm-content']/div/div/div[1]/div/a")).getText().equals("Start test"))
		{
		driver.findElement(By.xpath("//*[@id='cm-content']/div/div/div[1]/div/a")).click();
		}
		else   
		{
		driver.findElement(By.xpath("//*[@id='cm-content']/div/div/div[2]/div/a")).click();
		}
		List<WebElement> list = driver.findElements(By.className("checkradios"));
		((WebElement) list.get(3)).click();
		driver.findElement(By.xpath("//button[@name='save_now']")).click();
		
		//driver.findElement(By.xpath("//*[@id='choice-15-1']")).click();
		driver.findElement(By.xpath("//button[@name='save_now']")).click();
		
		//driver.findElement(By.xpath("//*[@id='choice-13-1']")).click();
		driver.findElement(By.xpath("//button[@name='save_now']")).click();
		//*[@id="question_div_16"]/div[3]/button[2]
		driver.findElement(By.xpath("//button[@name='save_now']")).click();
		
		driver.findElement(By.xpath("//button[@name='save_now']")).click();
		
		act_result = driver.findElement(By.xpath("//*[@id='cm-content']/div/div[1]/text()")).getText();
		
		return act_result; 
		
	 }

}

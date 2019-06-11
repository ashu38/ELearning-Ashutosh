package package_ELearning;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider_reg_el {
  
	String act_text;
	Object [][] data123 = new Object[2][8];
	Functions_all_el fae = new Functions_all_el();
	
	@BeforeClass
	public void dataGhe() throws IOException{
		//String s1 = "reg_sheet";
		for(int i=1;i<=2;i++){
			for(int j=0;j<=7;j++){
				data123[i-1][j] = fae.read_excel(i, j, "reg_sheet");
			}
		}
	}
	
	@BeforeMethod
  public void f123() {
  
		fae.launch_page_el();
	}
	
	@Test(dataProvider="abc")
	public void reg(String t_fname, String t_lname, String t_email, String t_uname, String t_pass1, String t_pass2, String t_phone, String lang) throws IOException{
		String s3 = fae.register_teacher(t_fname, t_lname, t_email, t_uname, t_pass1, t_pass2, t_phone, lang);
		
		act_text = fae.read_excel(1, 8, "reg_sheet");
				Assert.assertTrue(s3.contains(act_text));
	}
	
	@DataProvider(name="abc")
	public Object[][] getdata(){
		return data123;
	}
	
	
}

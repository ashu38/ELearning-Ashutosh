package package_ELearning;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ChangePass {
	Object[][] data;
  Functions_all_el fe = new Functions_all_el();
  String act_text3, exp_text4;
  
	@Test(dataProvider="abc123")
	public void second(String uname, String pass, String new_pass) throws IOException{
		String act_txt  = fe.change_pass(uname, pass, new_pass);
		System.out.println("Expected Result " + act_txt);
		exp_text4 = fe.read_excel(1, 3, "pass");
		Assert.assertEquals("Your new profile has been saved",act_txt);
	}
	@DataProvider(name="abc123")
	public Object[][] getdata() throws IOException{
		
		String s10 = "pass";
		Object[][] data3 = {{fe.read_excel(1, 0,s10), fe.read_excel(1, 1, s10), fe.read_excel(1, 2, s10)}};
		return data3;
		}
	
}

package package_ELearning;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC_39_Test_report {
  
	Functions_all_el f3 = new Functions_all_el();
	Object[][] data30 = new Object[2][3];
	String exp_res30j, exp_res30;
	
	@BeforeClass
	public void dataGhe123() throws IOException{
		//String s1 = "reg_sheet";
		for(int i=1;i<=2;i++){
			for(int j=0;j<=2;j++){
				data30[i-1][j] = f3.read_excel(i, j, "info");
			}
		}
	}
	
	@Test(dataProvider="dataprovider3")
	public void stud_info(String uname, String pass, String name) throws IOException, InterruptedException{
		String str3 = f3.tc_39(uname, pass, name);
		int j = 3;
		exp_res30 = f3.read_excel(1, j, "info");
		exp_res30j = f3.read_excel(2, j, "info");
		Assert.assertTrue(str3.contains(exp_res30));
	}
	
	@DataProvider(name="dataprovider3")
	public Object[][] getdata123(){
		return data30;

	}
	
  }


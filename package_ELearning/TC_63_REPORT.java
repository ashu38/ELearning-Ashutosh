package package_ELearning;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC_63_REPORT {
  
	Functions_all_el f4 = new Functions_all_el();
	Object[][] data40 = new Object[2][3];
	String exp_res40j, exp_res40;
	
	@BeforeClass
	public void dataGhe1234() throws IOException{
		//String s1 = "reg_sheet";
		for(int i=1;i<=2;i++){
			for(int j=0;j<=2;j++){
				data40[i-1][j] = f4.read_excel(i, j, "info2");
			}
		}
	}
	
	@Test(dataProvider="dataprovider4")
	public void stud_info(String uname, String pass, String name) throws IOException, InterruptedException{
		String str3 = f4.tc_39(uname, pass, name);
		int j = 3;
		exp_res40 = f4.read_excel(1, j, "info2");
		exp_res40j = f4.read_excel(2, j, "info2");
		Assert.assertTrue(str3.contains(exp_res40));
	}
	
	@DataProvider(name="dataprovider4")
	public Object[][] getdata123(){
		return data40;

	}
	
	@AfterClass
	public void display(){
		System.out.println("TEST passed.");
	}
	
}

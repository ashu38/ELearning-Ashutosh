package package_ELearning;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC_35_RATE {
  
	Functions_all_el f1 = new Functions_all_el();
	Object[][] data0 = new Object[2][3];
	String exp_res10j, exp_res10;
	
	@BeforeClass
	public void dataGhe123() throws IOException{
		//String s1 = "reg_sheet";
		for(int i=1;i<=2;i++){
			for(int j=0;j<=2;j++){
				data0[i-1][j] = f1.read_excel(i, j, "rate");
			}
		}
	}
	
	@Test(dataProvider="dataprovider1")
	public void rate_stud(String uname, String pass, String msg) throws IOException, InterruptedException{
		String str2 = f1.rate(uname, pass, msg);
		int j = 3;
		exp_res10 = f1.read_excel(1, j, "rate");
		exp_res10j = f1.read_excel(2, j, "rate");
		Assert.assertTrue(str2.contains(exp_res10));
	}
	
	@DataProvider(name="dataprovider1")
	public Object[][] getdata123(){
		return data0;

	}
}
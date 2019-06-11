package package_ELearning;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC_65_CREATE_TEST {
  
	Functions_all_el f5 = new Functions_all_el();
	Object[][] data50 = new Object[2][3];
	String exp_res50j, exp_res50;
	
	@BeforeClass
	public void dataGhe12345() throws IOException{
		//String s1 = "reg_sheet";
		for(int i=1;i<=2;i++){
			for(int j=0;j<=2;j++){
				data50[i-1][j] = f5.read_excel(i, j, "test");
			}
		}
	}
	
	@Test(dataProvider="dataprovider5")
	public void test_create(String uname, String pass, String c_name) throws IOException, InterruptedException{
		String str5 = f5.giveExam(uname, pass, c_name);
		int j = 3;
		exp_res50 = f5.read_excel(1, j, "test");
		exp_res50j = f5.read_excel(2, j, "test");
		Assert.assertTrue(str5.contains(exp_res50));
	}
	
	@DataProvider(name="dataprovider5")
	public Object[][] getdata123(){
		return data50;

	}
	
	
}

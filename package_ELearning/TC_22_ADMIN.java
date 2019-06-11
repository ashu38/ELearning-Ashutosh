package package_ELearning;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC_22_ADMIN {
  
	String exp_text5;
	Object [][] data12 = new Object[2][4];
	Functions_all_el fun = new Functions_all_el();
	
	@BeforeClass
	public void dataGheAniTaak() throws IOException{

		for(int i=1;i<=2;i++){
			for(int j=0;j<=3;j++){
				data12[i-1][j] = fun.read_excel(i, j, "admin");
			}
		}
	}
	
	@Test(dataProvider="abcxyz")
	public void admin_add_c(String uname, String pass, String Title, String code) throws IOException{
		
		String str = fun.create_user_admin(uname, pass, Title, code);
		System.out.println(str);
		//exp_text5 = fun.read_excel(1, 4, "admin");
		//exp_text5 = fun.read_excel(2, 4, "admin");
		Assert.assertTrue(str.contains(Title));
	}
	
	@DataProvider(name="abcxyz")
	public Object[][] dedata(){
		return data12;
	}
}

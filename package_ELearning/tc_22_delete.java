package package_ELearning;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class tc_22_delete {
  
	Functions_all_el f = new Functions_all_el(); 
	Object[][] data30 = new Object[2][3];
	
	@BeforeClass
	public void dataGheAniTaak() throws IOException{

		for(int i=1;i<=2;i++){
			for(int j=0;j<=2;j++){
				data30[i-1][j] = f.read_excel(i, j, "delete");
			}
		}
	}

		
	@Test(dataProvider="abcxyz1")
  public void f(String uname, String pass, String del) throws InterruptedException {
	  
	  String str1 = f.delete_class(uname, pass, del);
	  
	  Assert.assertTrue(str1.contains(del));
	  
  }
	
	@DataProvider(name="abcxyz1")
	public Object[][] dedata(){
		return data30;
	}
}

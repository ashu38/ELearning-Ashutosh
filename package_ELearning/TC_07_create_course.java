package package_ELearning;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC_07_create_course {
	Functions_all_el fae1 = new Functions_all_el();
	String act_text2;
	
	@Test(dataProvider="abc1")
	public void second(String uname, String pass, String c_name, String category, String code, String lang) throws IOException{
		String s4 = fae1.login_as_teacher(uname, pass, c_name, category, code, lang);
		
		act_text2 = fae1.read_excel(1, 6, "teacher_course");
				Assert.assertTrue(s4.contains(act_text2));
	}
	
	@DataProvider(name="abc1")
	public Object[][] getdata() throws IOException{
		
		String s2 = "teacher_course";
		Object[][] data2 = {{fae1.read_excel(1, 0,s2), fae1.read_excel(1, 1, s2), fae1.read_excel(1, 2, s2), fae1.read_excel(1, 3, s2), fae1.read_excel(1, 4, s2), fae1.read_excel(1, 5, s2)}} ;
		return data2;
	}
}

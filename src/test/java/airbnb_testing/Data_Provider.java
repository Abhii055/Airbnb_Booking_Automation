package airbnb_testing;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Data_Provider {
	@Test(dataProvider="getData")
	void Login(String name, String pass) {
		System.out.println(name+"  "+pass);
	}
	@DataProvider
	Object[][]getData(){
		Object data[][]= new Object[2][2];
		data[0][0]="user1";
		data[0][1]="Pass1";
		data[1][0]="user2";
		data[1][1]="pass2";
		return data;
	}
}

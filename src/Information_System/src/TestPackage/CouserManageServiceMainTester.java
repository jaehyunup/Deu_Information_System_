package TestPackage;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

import mainpackage.Model;
import mainpackage.loginSpec;
import mainpackage.loginType;
import CouserManageService.*;;


class CouserManageServiceMainTester {
	@Test
	void test() {
		loginSpec loginspec = new loginSpec("testid","testpw",loginType.STUDENT);
	}


}

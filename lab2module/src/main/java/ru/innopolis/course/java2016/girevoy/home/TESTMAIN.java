package ru.innopolis.course.java2016.girevoy.home;

import ru.innopolis.course.java2016.girevoy.home.web.profile.exeptions.WriteUserToDBExeption;
import ru.innopolis.course.java2016.girevoy.home.web.profile.models.UserAccount;
import ru.innopolis.course.java2016.girevoy.home.web.profile.services.UserAccountService;

/**
 * Created by Arxan on 30.10.2016.
 */
public class TESTMAIN {
	public static void main(String[] args) throws WriteUserToDBExeption {
		UserAccount userAccount = new UserAccount("test@test1223","qwqweqwee","Timur","Girevoy", "Andreyevich");
		UserAccountService.changeUserInDatabase(userAccount);
	}
}

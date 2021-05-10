import business.concretes.UserCheckManager;
import business.concretes.UserManager;
import core.concretes.GoogleManagerAdapter;
import core.concretes.SystemRegister;
import dataAccess.concretes.HibernateUserDao;
import entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		
		
		User rodi = new User(1,"Rodi","Goze","rodi.goze@gmail.com","1234567");
		User ali = new User(2,"Ali","blabla","ali.blabla@gmail.com","12345678");
		User veli = new User(3,"Veli","glagla","veli.glagla@gmail.com","123456789");
		
		UserManager userManager = new UserManager(new UserCheckManager(), new HibernateUserDao(null) , new SystemRegister());
		userManager.register(veli);
		userManager.register(rodi);
		
		System.out.println("-------------");
		
		UserManager userManager2 = new UserManager(new UserCheckManager(), new HibernateUserDao(null) , new GoogleManagerAdapter());
		userManager2.register(ali);
		
		System.out.println("---------------");
		
		userManager.SignIn("rodi.goze@gmail.com","1234567", rodi);
		userManager.SignIn("veli.glagla@gmail.com","123456789", veli);
		userManager2.SignIn("ali.blabla@gmail.com", "12345678", ali);
	
		
	}

}

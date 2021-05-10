package business.concretes;

import business.abstracts.AuthService;
import business.abstracts.UserService;
import business.abstracts.ValidityService;
import core.abstracts.RegisterService;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class UserManager implements UserService {
	private AuthService authService;
	private UserDao userDao;
	private RegisterService registerService;
	

	public UserManager(AuthService authService, UserDao userDao, RegisterService registerService) {
		super();
		this.authService = authService;
		this.userDao = userDao;
		this.registerService = registerService;
	}

	@Override
	public void register(User user) {
		ValidityService validityService = new ValidityManager(userDao);
		if(validityService.isValid(user.getEmail()) && authService.emailCheck(user.getEmail()) && authService.firstNameCheck(user.getFirstName()) &&
			authService.lastNameCheck(user.getLastName()) && authService.passwordCheck(user.getPassword())) {
			userDao.add(user);
			registerService.register();
			
			System.out.println("Verification link has been sent to "+user.getEmail());
			System.out.println(user.getFirstName() + " Registry completed");
		}
		
	}

	@Override
	public void SignIn(String email, String password,User user) {
		for(int i=0; i<userDao.getAll().size(); i++) {				
		    if(userDao.getAll().get(i).getEmail().equals(email) && userDao.getAll().get(i).getPassword().equals(password)) {
				System.out.println(user.getFirstName()+ " logged in");
			return;
			}		    
		}
		System.out.println("Uncorrect e-mail or password");
		
	}
	
		

		
	}




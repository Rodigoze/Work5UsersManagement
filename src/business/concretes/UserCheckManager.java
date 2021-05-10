package business.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import business.abstracts.AuthService;

public class UserCheckManager implements AuthService {
	public UserCheckManager() {
	}

	@Override
	public boolean emailCheck(String email) {
		 String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";

	        Pattern pattern = Pattern.compile(regex);
	        Matcher matcher = pattern.matcher(email);

	        if(matcher.matches()) {
	            return true;
	        }else if(email.isEmpty()){
	        	System.out.println("Email giriniz.");
	        	return false;
	        }else {
	        	System.out.println("Geçersiz email adresi.");
		    return false;
	        }
	}

	@Override
	public boolean firstNameCheck(String firstName) {
		if(firstName.length() <1 ) {
			System.out.println(" First name must be longer than one char");
			return false;
		}
		return true;
	}

	@Override
	public boolean lastNameCheck(String lastName) {
		if(lastName.length() <1 ) {
			System.out.println(" Last name must be longer than one char");
			return false;
		}
		return true;
	
	}

	@Override
	public boolean passwordCheck(String password) {
		if(password.length() < 6 ) {
			System.out.println(" Password must be longer than six char");
			return false;
		}
		return true;
	}

}

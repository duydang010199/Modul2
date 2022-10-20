package until;

import java.util.regex.Pattern;

public class ValidateUtils {
    public static final String PASSWORD_REGEX = "^([a-zA-Z0-9]{8,20})$";
    public static final String NAME_REGEX = "^([A-Z]+[a-z]*[ ]?)+$";
    public static final String USERNAME_REGEX = "^(?!.*\\.\\.)(?!.*\\.$)[^\\W][\\w.]{5,31}$";
    public static final String EMAIL_REGEX = "^[A-Za-z0-9]+\\.{0,1}[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    public static final String PHONE_REGEX = "^[0][1-9][0-9]{8}";
    public static boolean isPasswordValid(String password){
        return Pattern.compile(PASSWORD_REGEX).matcher(password).matches();
    }
    public static boolean isNameValid(String name){
        return Pattern.compile(NAME_REGEX).matcher(name).matches();
    }
    public static boolean isUserNameValid(String userName){
        return Pattern.compile(USERNAME_REGEX).matcher(userName).matches();
    }
    public static boolean isEmailValid(String email){
        return Pattern.compile(EMAIL_REGEX).matcher(email).matches();
    }
    public static boolean isPhoneValid(String phone){
        return Pattern.compile(PHONE_REGEX).matcher(phone).matches();
    }

}

package sen3004.project.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import sen3004.project.model.UserData;

@Component
public class ProjectValidator implements Validator{
    @Override
    public boolean supports(Class<?> clazz){
        return UserData.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors){
        UserData userData = (UserData)target;
        if(userData.getFirstName().contains("1") || 
           userData.getFirstName().contains("2") ||
           userData.getFirstName().contains("3") ||
           userData.getFirstName().contains("4") ||
           userData.getFirstName().contains("5") ||
           userData.getFirstName().contains("6") ||
           userData.getFirstName().contains("7") ||
           userData.getFirstName().contains("8") ||
           userData.getFirstName().contains("9") ||
           userData.getFirstName().contains("0") ){
            errors.rejectValue("firstName", "fname.custom.error");
        }

        if(userData.getLastName().contains("1") || 
           userData.getLastName().contains("2") ||
           userData.getLastName().contains("3") ||
           userData.getLastName().contains("4") ||
           userData.getLastName().contains("5") ||
           userData.getLastName().contains("6") ||
           userData.getLastName().contains("7") ||
           userData.getLastName().contains("8") ||
           userData.getLastName().contains("9") ||
           userData.getLastName().contains("0") ){
            errors.rejectValue("lastName", "lname.custom.error");
        }
    }
}

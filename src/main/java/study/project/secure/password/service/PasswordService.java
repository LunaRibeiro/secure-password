package study.project.secure.password.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class PasswordService {

    //Se a lista está vazia, é porque está tudo certo. Se a lista está cheia é porque tem algo inválido.
    public List<String> validatePass(String pass) {
        List<String> failures = new ArrayList<String>();

        validateLength(pass, failures);
        validateUpperCase(pass, failures);
        validateLowerCase(pass, failures);
        validateNumberCase(pass, failures);
        validateSpecialCharacter(pass, failures);

        return failures;
    }

    private void validateLength(String pass, List<String> failures) {
        if(pass != null && pass.length() < 8) {
            failures.add("A senha deve possuir pelo menos 8 caractesres");
        }
    }

    private void validateLowerCase(String pass, List<String> failures) {
        if(!Pattern.matches(".*[a-z].*", pass)){
            failures.add("A senha deve possuir pelo menos uma letra minúscula");
        }
    }

    private void validateNumberCase(String pass, List<String> failures) {
        if(!Pattern.matches(".*[0-9].*", pass)){
            failures.add("A senha deve possuir pelo menos um digito numérico");
        }
    }

    private void validateUpperCase(String pass, List<String> failures) {
        if(!Pattern.matches(".*[A-Z].*", pass)){
            failures.add("A senha deve possuir pelo menos um letra maiúscula");
        }
    }

    private void validateSpecialCharacter(String pass, List<String> failures) {
        if(!Pattern.matches(".*[\\W].*", pass)){
            failures.add("A senha deve possuir pelo menos um caracter especial");
        }
    }

}

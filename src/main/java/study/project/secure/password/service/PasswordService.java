package study.project.secure.password.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PasswordService {

    //Se a lista está vazia, é porque está tudo certo. Se a lista está cheia é porque tem algo inválido.
    public List<String> validatePass(String pass) {
        List<String> failures = new ArrayList<String>();

        return failures;
    }

}

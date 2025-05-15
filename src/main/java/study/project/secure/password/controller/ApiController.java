package study.project.secure.password.controller;

import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import study.project.secure.password.entity.request.BodyRequest;
import study.project.secure.password.entity.response.FailureResponse;
import study.project.secure.password.service.PasswordService;

@RestController
public class ApiController {

    private final PasswordService passwordService;

    public ApiController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @PostMapping("/validate-password")
    public ResponseEntity<FailureResponse> validatePassword(@RequestBody BodyRequest request) {

        var failures = passwordService.validatePass(request.password());

        if (failures.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

       return ResponseEntity.badRequest().body(new FailureResponse(failures));
    }
}

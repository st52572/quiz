package st52572.nnpia.project.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;
import st52572.nnpia.project.config.JwtTokenUtil;
import st52572.nnpia.project.model.ApiResponse;
import st52572.nnpia.project.model.AuthToken;
import st52572.nnpia.project.model.LoginUser;
import st52572.nnpia.project.model.User;
import st52572.nnpia.project.service.UserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/token")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/generate-token", method = RequestMethod.POST)
    public ApiResponse<AuthToken> generateToken(@RequestBody LoginUser loginUser) throws AuthenticationException {
        System.out.println(loginUser.getUsername());
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword()));
        final User user = userService.findOne(loginUser.getUsername());
        final String token = jwtTokenUtil.generateToken(user);
        System.out.println(user);
        System.out.println(loginUser.getUsername());
        return new ApiResponse<>(200, "success", new AuthToken(token, user.getUsername()));
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public ApiResponse<Void> logout() throws AuthenticationException {
        return new ApiResponse<>(200, "success", null);
    }

}

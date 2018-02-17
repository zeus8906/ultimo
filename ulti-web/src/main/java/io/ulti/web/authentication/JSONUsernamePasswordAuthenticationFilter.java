package io.ulti.web.authentication;

import java.io.IOException;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.ulti.web.authentication.domain.Credential;

public class JSONUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
            HttpServletResponse response) throws AuthenticationException {

        if (!request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException(
                    "Authentication method not supported: " + request.getMethod());
        }

        Credential credential = obtainCredentialObjectFromRequest(request);

        String username = credential.getEmail();
        String password = credential.getPassword();
        if (username == null) {
            credential.setEmail("");
        }

        if (password == null) {
            credential.setPassword("");
        }

        credential.setEmail(username.trim());

        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
                username, password);

        // Allow subclasses to set the "details" property
        setDetails(request, authRequest);
        return this.getAuthenticationManager().authenticate(authRequest);
    }

    private Credential obtainCredentialObjectFromRequest(HttpServletRequest request) {
        ObjectMapper mapper = new ObjectMapper();
        Credential credential = null;
        try {
            String credentialString = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
            credential = mapper.readerFor(Credential.class).readValue(credentialString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return credential == null ? new Credential() : credential;
    }
}

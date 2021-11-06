package ru.lis154.restServiceStock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;
import ru.lis154.restServiceStock.entity.UserSec;
import ru.lis154.restServiceStock.repository.UserRepository;

@Service
public class CustomOidcUserService extends OidcUserService {

    private final UserRepository userRepository;
    private final ProducerService producerService;

    @Autowired
    public CustomOidcUserService(UserRepository userRepository, ProducerService producerService) {
        this.userRepository = userRepository;
        this.producerService = producerService;
    }

//    @Autowired
//    public CustomOidcUserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    @Override
    public OidcUser loadUser(OidcUserRequest userRequest) throws OAuth2AuthenticationException {
        OidcUser oidcUser = super.loadUser(userRequest);
        if (userRepository.findByEmail(oidcUser.getEmail()).isEmpty()) {
            UserSec user = UserSec.builder()
                    .email(oidcUser.getEmail())
                    .firstName(oidcUser.getGivenName())
                    .lastName(oidcUser.getFamilyName())
                    .build();
            userRepository.save(user);
            producerService.produce(user);
        }
        return oidcUser;
    }

//    private OidcUser processOidcUser(OidcUserRequest userRequest, OidcUser oidcUser) {
//        GoogleUserInfo googleUserInfo = new GoogleUserInfo(oidcUser.getAttributes());
//
//        // see what other data from userRequest or oidcUser you need
//
//        Optional<User> userOptional = userRepository.findByEmail(googleUserInfo.getEmail());
//        if (!userOptional.isPresent()) {
//            User user = new User();
//            user.setEmail(googleUserInfo.getEmail());
//            user.setName(googleUserInfo.getName());
//
//            // set other needed data
//
//            userRepository.save(user);
//        }
//
//        return oidcUser;
//    }
}
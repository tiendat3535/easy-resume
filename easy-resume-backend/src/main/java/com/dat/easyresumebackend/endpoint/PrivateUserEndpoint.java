package com.dat.easyresumebackend.endpoint;

import com.dat.easyresumebackend.dto.UserDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Pham Tien Dat on 02/11/2017.
 */
@RestController
@RequestMapping("private")
public class PrivateUserEndpoint {

    @GetMapping("/user")
    public UserDto getPublic() {
        return new UserDto("concac", "");
    }

}

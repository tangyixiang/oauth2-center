package com.sky.oauth2.service;

import com.sky.oauth2.model.UserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "shop-user")
public interface UserClient {

    @RequestMapping(value = "/user/{identifier}",method = RequestMethod.GET)
    UserInfo findByUserIdentifier(@PathVariable("identifier") String identifier);

}

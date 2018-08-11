package com.udacity.gradle.builditbigger.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.keyeonacole.jokes.joker;
import javax.inject.Named;

/** An endpoint class we are exposing */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    /** A simple endpoint method that takes a name and says Hi back */
    @ApiMethod(name = "sayHi")
    public MyBean sayHi(@Named("name") String name) {
        MyBean response = new MyBean();
        joker joketeller = new joker();
        String joke = joketeller.getJoke(1);
        response.setData("Hi, " + joke);
        return response;
    }

    @ApiMethod(name = "makeJokes")
    public MyBean makeJokes(@Named("position")int position){
        MyBean response = new MyBean();
        joker joketeller = new joker();
        String joke = joketeller.getJoke(position);
        System.out.print(joke);
        response.setData(joke);
        return response;
    }

}

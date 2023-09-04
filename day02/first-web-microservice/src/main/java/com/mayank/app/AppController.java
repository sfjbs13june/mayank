package com.mayank.app;

import org.springframework.web.bind.annotation.*;

@RestController/*("/api")*/
public class AppController {

    @GetMapping("/get")
    public String getData(){
        return "from get Data";
    }

    @PostMapping("/post")
    public String postData(){
        return "from post data";
    }

    @PutMapping("/put")
    public String putData(){
        return "from put data";
    }

    @DeleteMapping("/delete")
    public String deleteData(){
        return "from delete data";
    }
}

package com.example.helloworld;

import com.example.helloworldbean.HelloWorldBean;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorldController {

  private MessageSource messageSource;
  public HelloWorldController(MessageSource messageSource){
    this.messageSource=messageSource;
  }
  @GetMapping(path="/hello-world")
  public String helloworld(){
    return "HelloWorld";
  }

  @GetMapping(path = "/hello-world-bean")
  public HelloWorldBean helloworldbean(){
    return new HelloWorldBean("HelloWorldBean");
  }

  @GetMapping(path = "/hello-world/path-variable/{name}")
  public HelloWorldBean helloWorldPathVariable(@PathVariable String name){
    return new HelloWorldBean("Hello world:"+name);
  }
  @GetMapping(path="/hello-world-internationlized")
  public String helloWorldInternationalized() {
    Locale locale= LocaleContextHolder.getLocale();
    return messageSource.getMessage
        ("good.morning.message",null,"Default Message",locale);
    //return "HelloWorld";
  }
}

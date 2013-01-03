package com.susanacabrera.guestbook.controller;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.susanacabrera.guestbook.bean.Greeting;
import com.susanacabrera.guestbook.service.GreetingsService;

@Controller
public class GuestbookController {

   private GreetingsService greetingsService;
   private UserService userService;

   @Required
   public void setGreetingsService(GreetingsService greetingsService) {
      this.greetingsService = greetingsService;
   }

   @Required
   public void setUserService(UserService userService) {
      this.userService = userService;
   }

   @RequestMapping(value = "/guestbook", method = RequestMethod.GET)
   public String doShowGuestbook(Model model) {

      final Collection<Greeting> greetings = greetingsService.getAllGreetings(0);
      model.addAttribute("greetings", greetings);
      return "guestbook/guestbook";

   }

   @RequestMapping(value = "/guestbook", method = RequestMethod.POST)
   public String doPost(@RequestParam("content") String content, Model model) {

      final User user = userService.getCurrentUser();
      final Date date = new Date();
      final Greeting greeting = new Greeting(user, content, date);
      greetingsService.create(greeting);
      return "redirect:guestbook";

   }
}
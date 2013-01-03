package com.susanacabrera.guestbook.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

import com.google.appengine.api.datastore.Key;
import com.susanacabrera.guestbook.bean.Greeting;
import com.susanacabrera.guestbook.dao.GreetingsJdoDao;

@Service
public class GreetingsServiceImpl implements GreetingsService {

   private GreetingsJdoDao greetingsJdoDao;

   @Required
   public void setGreetingsDao(final GreetingsJdoDao greetingsJdoDao) {
      this.greetingsJdoDao = greetingsJdoDao;
   }

   @Override
   public Key create(final Greeting greeting) {
      return greetingsJdoDao.create(greeting);
   }

   @Override
   public Collection<Greeting> getAllGreetings(int page) {
      return greetingsJdoDao.getAllGreetings(page);
   }

}

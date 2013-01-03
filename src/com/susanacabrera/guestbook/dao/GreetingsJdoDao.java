package com.susanacabrera.guestbook.dao;

import java.util.Collection;

import com.google.appengine.api.datastore.Key;
import com.susanacabrera.guestbook.bean.Greeting;


public interface GreetingsJdoDao {

   Key create(final Greeting greeting);
   Collection<Greeting> getAllGreetings(final int selectedPage) ;
}

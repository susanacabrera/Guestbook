package com.susanacabrera.guestbook.service;

import java.util.Collection;

import com.google.appengine.api.datastore.Key;
import com.susanacabrera.guestbook.bean.Greeting;

public interface GreetingsService {

   Key create(final Greeting greeting);

   Collection<Greeting> getAllGreetings(final int page);
}

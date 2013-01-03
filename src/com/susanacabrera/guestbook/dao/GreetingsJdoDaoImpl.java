package com.susanacabrera.guestbook.dao;

import java.util.Collection;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import org.springframework.orm.jdo.support.JdoDaoSupport;
import org.springframework.stereotype.Repository;

import com.google.appengine.api.datastore.Key;
import com.susanacabrera.guestbook.bean.Greeting;

@Repository
public class GreetingsJdoDaoImpl extends JdoDaoSupport implements GreetingsJdoDao {

   @Override
   public Key create(final Greeting greeting) {
      getJdoTemplate().makePersistent(greeting);
      return greeting.getKey();
   }

   @Override
   public Collection<Greeting> getAllGreetings(final int selectedPage) {

      final PersistenceManager pm = getPersistenceManager();

      try {

         final Query query = pm.newQuery(Greeting.class);
         query.setOrdering("date descending");

         @SuppressWarnings("unchecked")
         final Collection<Greeting> greetings = (Collection<Greeting>) query.execute();

         return pm.detachCopyAll((Collection<Greeting>) greetings);
      }

      finally {
         releasePersistenceManager(pm);
      }

   }

}

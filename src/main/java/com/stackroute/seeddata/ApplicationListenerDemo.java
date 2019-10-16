package com.stackroute.seeddata;

import com.stackroute.domain.Track;
import com.stackroute.repository.UserRepository;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class ApplicationListenerDemo implements ApplicationListener<ContextRefreshedEvent> {
   @Autowired
   private UserRepository userRepository;

   @Autowired
   Environment environment;

   @Override
   public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
      System.out.println("inside listener");
      userRepository.save(new Track(Integer.parseInt(environment.getProperty("id2")),
              environment.getProperty("name2"), environment.getProperty("comment2")));
   }
}

package com.stackroute.seeddata;

import com.stackroute.domain.Track;
import com.stackroute.myconfig.MyConfigurationProperty;
import com.stackroute.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@EnableConfigurationProperties(MyConfigurationProperty.class)
@Component
public class CommandLineRunnerDemo implements CommandLineRunner {
   @Autowired
   private UserRepository userRepository;
   @Value("${id1}")
   private int Id;
   @Value("${name1}")
   private String trackName;
   @Value("${comment1}")
   private String comment;

   @Autowired
   MyConfigurationProperty myConfigurationProperty;

   private int id;
   @Override
   public void run(String... args) throws Exception {
      System.out.println("inside runner");
       userRepository.save(new Track(Id, trackName, comment));

       userRepository.save(new Track(myConfigurationProperty.getId(),
               myConfigurationProperty.getName(),myConfigurationProperty.getComment()));

   }
}
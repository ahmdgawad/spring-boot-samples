package netgloo;

import netgloo.controllers.UserController;
import netgloo.models.User;
import netgloo.models.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAutoConfiguration
@EnableJpaRepositories
public class Application {

  public static void main(String[] args) {
    SpringApplication app = new SpringApplication(Application.class);


    app.setWebEnvironment(false);
    ConfigurableApplicationContext ctx = app.run(args);

    UserDao userDao = ctx.getBean("userDao", UserDao.class);

    User user = new User("agawad@stc.com.sa", "Ahmed Gawad");
    userDao.save(user);
  }

}

package langina.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/credentials.properties"})
public interface SelenoidConfig extends Config {
  String login();
  String password();
}

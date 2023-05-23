package treining.mongo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import treining.mongo.domain.User;
import treining.mongo.repository.UserRepository;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com", "senhaAqui");
        User alex = new User(null, "Alex Green", "alex@gmail.com", "sei_nao");
        User bob = new User(null, "Bob Grey", "bob@gmail.com", "aqui_vai_umaSenha");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));
    }
}

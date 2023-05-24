package treining.mongo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import treining.mongo.domain.Post;
import treining.mongo.domain.User;
import treining.mongo.dto.AuthorDTO;
import treining.mongo.dto.CommentDTO;
import treining.mongo.repository.PostRepository;
import treining.mongo.repository.UserRepository;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GTM"));


        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com", "senhaAqui");
        User alex = new User(null, "Alex Green", "alex@gmail.com", "sei_nao");
        User bob = new User(null, "Bob Grey", "bob@gmail.com", "aqui_vai_umaSenha");

        // need to save first so the id exist when associate with the Author
        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post p1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "vou viajar para sao paulo abracos!!!", new AuthorDTO(maria));
        Post p2 = new Post(null, sdf.parse("16/03/1997"), "Estou com fome", "comerei um docinho de banana", new AuthorDTO(maria));

        CommentDTO c1 = new CommentDTO("Boa viagem mano", sdf.parse("25/11/1998"), new AuthorDTO(alex));
        CommentDTO c2 = new CommentDTO("divirta-se", sdf.parse("5/05/1998"), new AuthorDTO(bob));

        p1.setCommentDTOList(Arrays.asList(c1, c2));

        postRepository.saveAll(Arrays.asList(p1, p2));

        maria.getPosts().addAll(Arrays.asList(p1, p2));
        userRepository.save(maria);
    }
}

package hh.swd20.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.BookRepository;
import hh.swd20.Bookstore.domain.Category;
import hh.swd20.Bookstore.domain.CategoryRepository;
import hh.swd20.Bookstore.domain.User;
import hh.swd20.Bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger Log = LoggerFactory.getLogger(BookstoreApplication.class);

	
    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }
    @Bean
    public CommandLineRunner demo(BookRepository repository, CategoryRepository cRepository, UserRepository uRepository) {
        return (args) -> {	
        	
        	
        	 Category c1 = new Category("Comedy");
             Category c2 = new Category("Documentary");
             Category c3 = new Category("Drama");
             cRepository.save(c1);
             cRepository.save(c2);
             cRepository.save(c3);
             
            Book b1 = new Book("Työmiehen päiväkirja", "Kari Tapio", 1990, "1324569781", 50.0, c1 );
            Book b2 = new Book("Aamupäivä", "Timo Jutila", 2010, "6894037481", 60.0, c2);
            Book b3 = new Book("Pelimies", "Pirkko Pitäjä", 1890, "5891287498", 200.0, c3);
            
            repository.save(b1);
            repository.save(b2);
            repository.save(b3);
            
            User user1 = new User("USER", "$2b$10$Bz9wToqfoDIvD8cP8rZTteiZx7HIly8fglEajwUS9ctv8r/OK7g6i", "ROLE_USER");
            User user2 = new User("ADMIN", "$2b$10$uxmkJ9AxEWiMyuxTteJgYOvryVwzOjq805hIbVHC37.9H8V.Aq9ya", "ROLE_ADMIN");
        	uRepository.save(user1);
        	uRepository.save(user2);
            
            for (Book book : repository.findAll()) {
                Log.info(book.toString());
            }
            for (Category category : cRepository.findAll()) {
                Log.info(category.toString());
            }
            for (User user : uRepository.findAll()) {
                Log.info(user.toString());
            }
        };
    }
}
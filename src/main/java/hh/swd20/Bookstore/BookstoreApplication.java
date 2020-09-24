package hh.swd20.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }
    @Bean
    public CommandLineRunner demo(BookRepository repository) {
        return (args) -> {
            Book b1 = new Book("Työmiehen päiväkirja", "Kari Tapio", 1990, "1324569781", 50.0 );
            Book b2 = new Book("Aamupäivä", "Timo Jutila", 2010, "6894037481", 60.0 );
            Book b3 = new Book("Pelimies", "Pirkko Pitäjä", 1890, "5891287498", 200.0);

            repository.save(b1);
            repository.save(b2);
            repository.save(b3);
        };
    }
}
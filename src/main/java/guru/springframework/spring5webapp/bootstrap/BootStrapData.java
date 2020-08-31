package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author murthy = new Author("Narayan", "Murthy");
        Book betterPlace = new Book("A Better India, A Better World", "123456");
        murthy.getBooks().add(betterPlace);
        betterPlace.getAuthors().add(murthy);

        authorRepository.save(murthy);
        bookRepository.save(betterPlace);

        Author gandhi = new Author("Mohandas", "Gandhi");
        Book mewt = new Book("My Experiments With Truth", "8986896");
        gandhi.getBooks().add(mewt);
        mewt.getAuthors().add(gandhi);

        authorRepository.save(gandhi);
        bookRepository.save(mewt);

        System.out.println("Book Count: " + bookRepository.count());

        Publisher publisher = new Publisher
                ("Penguins Pvt Ltd", "Fort", "Mumbai", "Maharashtra", "400001");
        publisherRepository.save(publisher);

        System.out.println("Publisher count: " + publisherRepository.count());


    }
}

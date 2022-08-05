package ma.hibernate.embeddable;

import ma.hibernate.embeddable.model.NewsPost;
import ma.hibernate.embeddable.model.PostMetadata;
import ma.hibernate.embeddable.service.PostService;
import ma.hibernate.embeddable.service.impl.PostServiceImpl;
import ma.hibernate.embeddable.util.HibernateUtil;
import org.hibernate.SessionFactory;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        NewsPost first = new NewsPost(LocalDate.of(2007, 12, 3),
                "topic",
                "content",
                new PostMetadata(14L, "hashcode"));

        NewsPost second = new NewsPost(LocalDate.of(2006, 11, 2),
                "murder",
                "in Castlevania",
                new PostMetadata(12L, "hashcode1"));

        NewsPost third = new NewsPost(LocalDate.of(2012, 2, 2),
                "Anton",
                "eating soap",
                new PostMetadata(2L, "hashcode2"));

        NewsPost fourth = new NewsPost(LocalDate.of(2015, 12, 3),
                "Kolya",
                "eating Anton",
                new PostMetadata(19L, "hashcode3"));

        NewsPost fifth = new NewsPost(LocalDate.of(2031, 8, 12),
                "Artem",
                "eating Kolya with Oleg",
                new PostMetadata(14L, "hashcode"));

        PostService postService = new PostServiceImpl();
        postService.add(first);
        postService.add(second);
        postService.add(third);
        postService.add(fourth);
        postService.add(fifth);
        postService.getWithSizeLargerThan(12L);
    }
}

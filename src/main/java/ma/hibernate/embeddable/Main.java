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
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        NewsPost first = new NewsPost(LocalDate.of(2007, 12, 3),
                "topic",
                "content",
                new PostMetadata(14L, "hashcode"));
        PostService postService = new PostServiceImpl();
        postService.add(first);

        NewsPost second = new NewsPost(LocalDate.of(2006, 11, 2),
                "murder",
                "in Castlevania",
                new PostMetadata(12L, "hashcode1"));
        PostService postService1 = new PostServiceImpl();
        postService1.add(second);

        NewsPost third = new NewsPost(LocalDate.of(2012, 2, 2),
                "Anton",
                "eating soap",
                new PostMetadata(2L, "hashcode2"));
        PostService postService2 = new PostServiceImpl();
        postService2.add(third);

        NewsPost fourth = new NewsPost(LocalDate.of(2015, 12, 3),
                "Kolya",
                "eating Anton",
                new PostMetadata(19L, "hashcode3"));
        PostService postService3 = new PostServiceImpl();
        postService3.add(fourth);

        NewsPost fifth = new NewsPost(LocalDate.of(2031, 8, 12),
                "Artem",
                "eating Kolya with Oleg",
                new PostMetadata(14L, "hashcode"));
        PostService postService4 = new PostServiceImpl();
        postService4.add(fifth);

        PostService postService5 = new PostServiceImpl();
        postService5.getWithSizeLargerThan(12L);
    }
}

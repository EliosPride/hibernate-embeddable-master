package ma.hibernate.embeddable.service;

import ma.hibernate.embeddable.model.NewsPost;

import java.util.List;

public interface PostService {
    NewsPost add(NewsPost post);

    List<NewsPost> getWithSizeLargerThan(long size);
}

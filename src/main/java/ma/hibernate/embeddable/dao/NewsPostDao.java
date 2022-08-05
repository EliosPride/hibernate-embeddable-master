package ma.hibernate.embeddable.dao;

import ma.hibernate.embeddable.model.NewsPost;

import java.util.List;

public interface NewsPostDao {
    NewsPost save(NewsPost post);

    List<NewsPost> getWithMetadataSizeLargerThan(long size);
}

package ma.hibernate.embeddable.dao;

import java.util.List;
import ma.hibernate.embeddable.model.NewsPost;

public interface NewsPostDao {
    NewsPost save(NewsPost post);

    List<NewsPost> getWithMetadataSizeLargerThan(long size);
}

package ma.hibernate.embeddable.dao.impl;

import java.util.List;
import ma.hibernate.embeddable.dao.NewsPostDao;
import ma.hibernate.embeddable.model.NewsPost;

public class NewsPostDaoImpl extends AbstractDao implements NewsPostDao {
    public NewsPostDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public NewsPost save(NewsPost post) {
        return null;
    }

    @Override
    public List<NewsPost> getWithMetadataSizeLargerThan(long size) {
        return null;
    }
}

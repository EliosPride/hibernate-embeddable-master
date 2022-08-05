package ma.hibernate.embeddable.service.impl;

import ma.hibernate.embeddable.dao.NewsPostDao;
import ma.hibernate.embeddable.factory.NewsPostDaoFactory;
import ma.hibernate.embeddable.model.NewsPost;
import ma.hibernate.embeddable.service.PostService;

import java.util.List;

public class PostServiceImpl implements PostService {
    private final NewsPostDao newsPostDao = NewsPostDaoFactory.getInstance();

    @Override
    public NewsPost add(NewsPost post) {
        return newsPostDao.save(post);
    }

    @Override
    public List<NewsPost> getWithSizeLargerThan(long size) {
        return newsPostDao.getWithMetadataSizeLargerThan(size);
    }
}

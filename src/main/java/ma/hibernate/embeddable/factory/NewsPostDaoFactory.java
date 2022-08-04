package ma.hibernate.embeddable.factory;

import ma.hibernate.embeddable.dao.NewsPostDao;
import ma.hibernate.embeddable.dao.impl.AbstractDao;
import ma.hibernate.embeddable.dao.impl.NewsPostDaoImpl;
import ma.hibernate.embeddable.util.HibernateUtil;
import org.hibernate.SessionFactory;

public class NewsPostDaoFactory extends AbstractDao {
    private static NewsPostDao newsPostDao;

    protected NewsPostDaoFactory(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public static NewsPostDao getInstance() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        if (newsPostDao == null) {
            newsPostDao = new NewsPostDaoImpl(sessionFactory);
        }
        return newsPostDao;
    }
}

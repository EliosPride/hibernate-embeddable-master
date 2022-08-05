package ma.hibernate.embeddable.dao.impl;

import ma.hibernate.embeddable.dao.NewsPostDao;
import ma.hibernate.embeddable.exception.DataProcessingException;
import ma.hibernate.embeddable.model.NewsPost;
import ma.hibernate.embeddable.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Property;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class NewsPostDaoImpl extends AbstractDao implements NewsPostDao {
    public NewsPostDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public NewsPost save(NewsPost post) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(post);
            transaction.commit();
            return post;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("can't save post to db", e);
        }
    }

    @Override
    public List<NewsPost> getWithMetadataSizeLargerThan(long size) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return (List<NewsPost>) session.createCriteria(NewsPost.class)
                    .add(Property.forName("metadata.size").gt(size))
                    .list();
        } catch (Exception e) {
            throw new DataProcessingException("Can't get post with big size", e);
        }
    }
}

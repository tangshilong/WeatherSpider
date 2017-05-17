package dao;

import Spider.DownInfo;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import po.Url;
import util.HibernateUtil;

import java.util.List;

/**
 * Created by tangshilong on 2017/5/16.
 */
@SuppressWarnings({"unchecked"})
public class UrlDao {

    public static void saveUrl(Url url) throws Exception {
        try {
            Session session = HibernateUtil.currentSession();
            Transaction transaction = session.beginTransaction();
            SQLQuery sqlQuery = session
                    .createSQLQuery("insert into url (url,flag) values (?,?)");
            sqlQuery.setString(0, url.getUrl());
            sqlQuery.setInteger(1, url.getFlag());
            sqlQuery.executeUpdate();
            transaction.commit();
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public static List<Url> getUrlByNum(int i) throws Exception {
        try {
            Session session = HibernateUtil.currentSession();
            SQLQuery query = session
                    .createSQLQuery("select * from url where flag = ? and id<=400000 and MOD(id,?) = ? limit 500");
            return (List<Url>) query.addEntity(Url.class).setInteger(0, 0).setInteger(1, DownInfo.MAX_THREAD).setInteger(2, i).list();
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public static void updateFlag(int id) throws Exception {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.currentSession();
            transaction = session.beginTransaction();
            session.createSQLQuery("update Url set flag=? where id =?").setInteger(0, 1).setInteger(1, id)
                    .executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public static Url get(){
        try {
            Session session = HibernateUtil.currentSession();
           return  session.get(Url.class,1);
        } finally {
            HibernateUtil.closeSession();
        }
    }
}

package dao;

import po.Station;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

/**
 * Created by tangshilong on 2017/5/15.
 */
public class StationDao {

    public static void saveStation(Station station) throws Exception {
        try {
            Session session = HibernateUtil.currentSession();
            Transaction transaction = session.beginTransaction();
            SQLQuery sqlQuery = session
                    .createSQLQuery("insert into station (num,stationName,city,lat,lon,height) values (?,?,?,?,?,?)");
            sqlQuery.setString(0, station.getNum());
            sqlQuery.setString(1, station.getStationName());
            sqlQuery.setString(2, station.getCity());
            sqlQuery.setString(3, station.getLat());
            sqlQuery.setString(4, station.getLon());
            sqlQuery.setString(5, station.getHeight());
            sqlQuery.executeUpdate();
            transaction.commit();
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public static List<Station> getStationById(int i) throws Exception {
        try {
            Session session = HibernateUtil.currentSession();
            SQLQuery query = session
                    .createSQLQuery("SELECT * FROM station WHERE id=?");
            return (List<Station>) query.addEntity(Station.class).setInteger(0, i).list();
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public static List<Station> getStationByNum(String i) throws Exception {
        try {
            Session session = HibernateUtil.currentSession();
            SQLQuery query = session
                    .createSQLQuery("select * from station where num =?");
            return (List<Station>)query.addEntity(Station.class).setString(0, i).list();
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public static void updateSelectName(int id,String flag) throws Exception {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.currentSession();
            transaction = session.beginTransaction();
            session.createSQLQuery("update station set selectName =? where id =?").setString(0, flag).setInteger(1, id)
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
}

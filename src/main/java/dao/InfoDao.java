package dao;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import po.Info;
import po.Station;
import util.HibernateUtil;

/**
 * Created by tangshilong on 2017/5/15.
 */
public class InfoDao {

    public static void saveInfo(Info info) throws Exception {
        try {
            Session session = HibernateUtil.currentSession();
            Transaction transaction = session.beginTransaction();
            SQLQuery sqlQuery = session
                    .createSQLQuery("insert into info (stationId, stationName, `date`, dateCST, temperature, dewPoint, pressure, visibility, windDirection, windSpeed, conditions, windDirDegrees, dateUTC) values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
            sqlQuery.setString(0, info.getStationId());
            sqlQuery.setString(1, info.getStationName());
            sqlQuery.setString(2, info.getDate());
            sqlQuery.setString(3, info.getDateCST());
            sqlQuery.setString(4, info.getTemperature());
            sqlQuery.setString(5, info.getDewPoint());
            sqlQuery.setString(6, info.getPressure());
            sqlQuery.setString(7, info.getVisibility());
            sqlQuery.setString(8, info.getWindDirection());
            sqlQuery.setString(9, info.getWindSpeed());
            sqlQuery.setString(10, info.getConditions());
            sqlQuery.setString(11, info.getWindDirDegrees());
            sqlQuery.setString(12, info.getDateUTC());
            sqlQuery.executeUpdate();
            transaction.commit();
        } finally {
            HibernateUtil.closeSession();
        }
    }
}

package simonadimitrova.electricitycompany.model.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import simonadimitrova.electricitycompany.model.configuration.HibernateUtil;
import simonadimitrova.electricitycompany.model.entities.Client;
import simonadimitrova.electricitycompany.model.entities.ClientPrice;

import java.math.BigDecimal;
import java.util.List;

public class ClientPriceDAO {
    static {
        List<ClientPrice> prices = ClientPriceDAO.getAll();
        if (prices.isEmpty()) {
            // add default prices if not there
            saveOrUpdate(new ClientPrice(Client.Type.PRIVATE, new BigDecimal(0.22)));
            saveOrUpdate(new ClientPrice(Client.Type.COMPANY, new BigDecimal(0.604)));
        }
    }

    public static void save(ClientPrice price) {
        try (Session session = HibernateUtil.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(price);
            transaction.commit();
        }
    }

    public static void saveOrUpdate(ClientPrice price) {
        try (Session session = HibernateUtil.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(price);
            transaction.commit();
        }
    }

    public static void save(List<ClientPrice> prices) {
        try (Session session = HibernateUtil.openSession()) {
            Transaction transaction = session.beginTransaction();
            prices.stream().forEach((p) -> session.save(p));
            transaction.commit();
        }
    }

    public static ClientPrice get(long id) {
        try (Session session = HibernateUtil.openSession()) {
            Transaction transaction = session.beginTransaction();
            ClientPrice price = session.get(ClientPrice.class, id);
            transaction.commit();
            return price;
        }
    }

    public static ClientPrice get(Client.Type clientType) {
        try (Session session = HibernateUtil.openSession()) {
            return session.createQuery("FROM ClientPrice where clientType=" + clientType.ordinal(), ClientPrice.class).getSingleResult();
        }
    }

    public static ClientPrice load(long id) {
        try (Session session = HibernateUtil.openSession()) {
            Transaction transaction = session.beginTransaction();
            ClientPrice price = session.load(ClientPrice.class, id);
            transaction.commit();
            return price;
        }
    }

    public static List<ClientPrice> getAll() {
        try (Session session = HibernateUtil.openSession()) {
            return session.createQuery("FROM ClientPrice", ClientPrice.class).list();
        }
    }

    public static void delete(ClientPrice price) {
        try (Session session = HibernateUtil.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(price);
            transaction.commit();
        }
    }
}

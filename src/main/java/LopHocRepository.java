import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class LopHocRepository {

    public List<LopHoc> getAll() {
        List<LopHoc> list = new ArrayList<>();
        try(Session session = hibernateUtil.getFACTORY().openSession()) {
            Query  query = session.createQuery("FROM LopHoc ",LopHoc.class);
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public LopHoc getById(Long id) {
        LopHoc lopHoc = null;
        try(Session session = hibernateUtil.getFACTORY().openSession()) {
            Query  query = session.createQuery("FROM LopHoc WHERE id=:id1"
                    ,LopHoc.class);
            query.setParameter("id1",id);
            lopHoc = (LopHoc) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lopHoc;
    }

    public Boolean add (LopHoc lopHoc) {
        Transaction transaction = null;
        try(Session session = hibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            //add
            session.persist(lopHoc);
            //commit
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean delete (LopHoc lopHoc) {
        Transaction transaction = null;
        try(Session session = hibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            //add
            session.delete(lopHoc);
            //commit
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        new LopHocRepository().getAll()
                .forEach(lopHoc -> System.out.println(lopHoc.toString()));

    }

}

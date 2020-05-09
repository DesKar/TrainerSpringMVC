package org.privateschool.trainermvc.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.privateschool.trainermvc.entities.Trainer;
import org.springframework.stereotype.Repository;

@Repository("trainerDao")
public class TrainerDaoImpl extends AbstractDao<Integer, Trainer> implements ITrainerDao {

    @Override
    public List<Trainer> findAll() {
        Criteria criteria = createEntityCriteria();
        return (List<Trainer>) criteria.list();
    }

    @Override
    public boolean save(Trainer trainer) {
        boolean notSaved = persist(trainer);
        if (notSaved) {
            return false;
        }
        return true;
    }

    public boolean delete(int id) {
        Trainer t = getByKey(id);
        if (t != null) {
            delete(t);
            if (getByKey(id) == null) {
                return true;
            }
        }
        return false;
    }

}

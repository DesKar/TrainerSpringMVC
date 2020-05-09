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
    public Trainer findById(int id) {
        Trainer t = getByKey(id);
        if (t != null) {
            return t;
        } else {
            return null;
        }
    }

    @Override
    public boolean save(Trainer trainer) {
        boolean notSaved = persist(trainer);
        
        return !notSaved;
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

    @Override
    public boolean update(Trainer trainer) {
        Trainer dbTrainer = findById(trainer.getId());
        dbTrainer.setFirstName(trainer.getFirstName());
        dbTrainer.setLastName(trainer.getLastName());
        dbTrainer.setSubject(trainer.getSubject());
        return save(dbTrainer);
    }

}

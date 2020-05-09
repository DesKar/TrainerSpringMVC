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

}

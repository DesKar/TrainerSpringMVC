package org.privateschool.trainermvc.services;

import java.util.List;
import org.privateschool.trainermvc.dao.TrainerDaoImpl;
import org.privateschool.trainermvc.entities.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("trainerService")
@Transactional
public class TrainerImpl implements ITrainer {

    @Autowired
    TrainerDaoImpl dao;

    @Override
    public List<Trainer> findAll() {
        List<Trainer> trainers = dao.findAll();
        return trainers;
    }

    public Trainer findById(int id) {
        Trainer t = dao.findById(id);
        if (t != null) {
            return t;
        } else {
            return null;
        }
    }

    @Override
    public boolean save(Trainer trainer) {
        return dao.save(trainer);

    }

    @Override
    public boolean delete(int id) {
        return dao.delete(id);
    }
    
    @Override
    public boolean update(Trainer trainer) {
        return dao.update(trainer);
    }
}

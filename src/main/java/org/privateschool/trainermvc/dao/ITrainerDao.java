package org.privateschool.trainermvc.dao;

import java.util.List;
import org.privateschool.trainermvc.entities.Trainer;

public interface ITrainerDao {

    public List<Trainer> findAll();

    public boolean save(Trainer trainer);

    public boolean delete(int id);

}

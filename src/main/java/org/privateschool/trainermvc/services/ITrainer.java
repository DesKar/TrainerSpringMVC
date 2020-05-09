package org.privateschool.trainermvc.services;

import java.util.List;
import org.privateschool.trainermvc.entities.Trainer;

public interface ITrainer {

    public List<Trainer> findAll();

    public Trainer findById(int id);

    public boolean save(Trainer trainer);

    public boolean delete(int id);

    public boolean update(Trainer trainer);

}

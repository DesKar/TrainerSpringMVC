package org.privateschool.trainermvc.services;

import java.util.List;
import org.privateschool.trainermvc.entities.Trainer;

public interface ITrainer {

    public List<Trainer> findAll();

    public boolean save(Trainer trainer);

}

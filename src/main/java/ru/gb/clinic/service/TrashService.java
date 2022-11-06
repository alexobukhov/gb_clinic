package ru.gb.clinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.clinic.model.Trash;
import ru.gb.clinic.repository.TrashRepository;

import java.util.List;

@Service
public class TrashService {

    @Autowired
    TrashRepository trashRepository;

    public List<Trash> getAll() {
        return trashRepository.findAll();
    }

    public Trash get(long id) {
        return trashRepository.findById(id).orElse(null);
    }

    public Trash save(Trash trash) {
        if (trash == null) {
            return null;
        }
        return trashRepository.save(trash);
    }

    public void delete(long id) {
        trashRepository.deleteById(id);
    }
}

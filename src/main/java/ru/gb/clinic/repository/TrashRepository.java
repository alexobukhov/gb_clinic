package ru.gb.clinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.clinic.model.Trash;

@Repository
public interface TrashRepository extends JpaRepository<Trash, Long> {
}

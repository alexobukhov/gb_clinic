package ru.gb.clinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.clinic.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}

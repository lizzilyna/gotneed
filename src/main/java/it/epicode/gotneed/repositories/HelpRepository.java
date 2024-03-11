package it.epicode.gotneed.repositories;

import it.epicode.gotneed.models.Help;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface HelpRepository extends JpaRepository<Help, Integer>, PagingAndSortingRepository<Help, Integer> {
}

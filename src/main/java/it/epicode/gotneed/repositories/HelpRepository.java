package it.epicode.gotneed.repositories;

import it.epicode.gotneed.models.Help;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface HelpRepository extends JpaRepository<Help, Integer>, PagingAndSortingRepository<Help, Integer> {
    Page<Help> findByOfferedByProvincia(String provincia, Pageable pageable);
    Page<Help> findByRequestedByProvincia(String provincia, Pageable pageable);


}

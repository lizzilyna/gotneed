package it.epicode.gotneed.repositories;

import it.epicode.gotneed.models.Girl;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.awt.print.Pageable;

public interface GirlRepository extends JpaRepository<Girl, Integer>, PagingAndSortingRepository<Girl, Integer> {

}

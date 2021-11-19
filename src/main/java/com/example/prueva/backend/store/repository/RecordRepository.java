package com.example.prueva.backend.store.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import com.example.prueva.backend.store.models.Record;

@Service
public interface RecordRepository extends JpaRepository<Record,Integer> {

	@Query(
			  value = "SELECT * FROM records e WHERE e.user_id=?1", 
			  nativeQuery = true)
	public Collection<Record> getRecords(Integer user_id);
}

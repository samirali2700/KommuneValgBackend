package com.example.kommunevalgbackend.Repository;

import com.example.kommunevalgbackend.Model.Parti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface PartiRepository extends JpaRepository<Parti,Integer> {


    @Modifying
    @Query(
            value = "UPDATE parti SET kandidat_count = kandidat_count + 1 WHERE parti_id = ?1",
            nativeQuery = true
    )
    void incrementKandidatCount(int partiId);

    @Modifying
    @Query(
            value = "UPDATE parti SET kandidat_count = kandidat_count - 1 WHERE parti_id = ?1",
            nativeQuery = true
    )
    void decrementKandidatCount(int partiId);

}

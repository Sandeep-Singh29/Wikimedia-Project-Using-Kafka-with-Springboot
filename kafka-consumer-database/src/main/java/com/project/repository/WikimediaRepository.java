package com.project.repository;

import com.project.entity.WikimediaData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author: SANDEEP
 * Date: 02/01/25
 */

@Repository
public interface WikimediaRepository extends JpaRepository<WikimediaData, Long> {
}

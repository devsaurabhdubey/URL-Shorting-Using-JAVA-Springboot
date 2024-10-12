package com.seroter.urlshortening.Repository;

import com.seroter.urlshortening.Model.URLMapping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface URLMappingRepository extends JpaRepository<URLMapping, Long>
{


   URLMapping findShortUrl(String shortUrl);
}

package com.example.vd;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by leandropozer on 06/06/17.
 */
public interface VdRepository extends MongoRepository<Vd, String> {

    public Vd findByTitle(String title);
    public Vd findById(Long Id);
}

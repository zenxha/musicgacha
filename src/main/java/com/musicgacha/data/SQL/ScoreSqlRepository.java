package com.musicgacha.data.SQL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.musicgacha.data.SQL.Score;
import java.util.List;

/*
This class has an instance of Java Persistence API (JPA)
-- @Autowired annotation. Allows Spring to resolve and inject collaborating beans into our bean.
-- Spring Data JPA will generate a proxy instance
-- Below are some CRUD methods that we can use with our database
*/
@Service
@Transactional
public class ScoreSqlRepository {

    @Autowired
    private ScoreJpaRepository jpa;

    public  List<Score>listAll() {
        return jpa.findAll();
    }

    // custom query to find anything containing term in name or email ignoring case
//    public  List<Score>listLike(String term) {
//        return jpa.findByNameContainingIgnoreCaseOrEmailContainingIgnoreCase(term, term);
//    }

    // custom query to find anything containing term in name or email ignoring case

    public void save(Score score) {
        jpa.save(score);
    }

    public Score get(long id) {
        return jpa.findById(id).get();
    }

    public void delete(long id) {
        jpa.deleteById(id);
    }
}

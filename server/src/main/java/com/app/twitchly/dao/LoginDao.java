package com.app.twitchly.dao;


import com.app.twitchly.entity.db.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDao {

    @Autowired
    private SessionFactory sessionFactory;

    // Verify if the given user Id and password are correct. Returns the user name when it passes
    public String verifyLogin(String userId, String password) {
        String name = "";

        // java: try with resouce
        // https://www.baeldung.com/java-try-with-resources
        try (Session session = sessionFactory.openSession()) {
            // first it's deseriablizable, second is primary key
            User user = session.get(User.class, userId);
            // check if the user is empty and if it matches the log-in info in the database
            if(user != null && user.getPassword().equals((password))) {
                name = user.getFirstName();
            }
            // the controller will check if the return name is empty
            // if it's empty, then log-in request fails => log-in error!
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return name;
    }
}

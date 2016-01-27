package com.chat;

import com.chat.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, String> {
    @Modifying
    @Query("update User u set u.online = ?2 where u.username=?1")
    void setOnline(String user, boolean online);

//    @Override
//    @Query("select User u where u.username=?1")
//    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}

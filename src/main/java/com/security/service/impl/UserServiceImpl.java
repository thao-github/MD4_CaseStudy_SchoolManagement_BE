package com.security.service.impl;

import com.security.model.User;
import com.security.repository.IUserRepo;
import com.security.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    IUserRepo userRepo;

    @Override
    public Optional<User> findByUsername(String name) {
        return userRepo.findByUsername(name);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return userRepo.existsByUsername(username);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return userRepo.existsByEmail(email);
    }

    @Override
    public User save(User user) {
        return userRepo.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepo.findById(id);
    }

    @Override
    public List<User> findAllStudentByCoach(Long id) {
        return userRepo.findAllStudentByCoach(id);
    }

    @Override
    public List<User> findAllStudentByName(Long id, String name) {
        return userRepo.findAllStudentByName(id, name);
    }

    @Override
    public User findUserById(Long classId, Long studentId) {
        return userRepo.findUserById(classId, studentId);
    }

    @Override
    public List<User> findUserByStatus(Long id, String status) {
        return userRepo.findUserByStatus(id, status);
    }

    @Override
    public List<User> findAllCoach(int pageable) {
        return userRepo.findAllCoach(pageable);
    }

    @Override
    public int countAllCoach() {
        return userRepo.countCoaches();
    }

    @Override
    public List<User> searchCoach(String name, int start) {
        return userRepo.searchCoach(name, start);
    }
}

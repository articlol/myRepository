package service;

import Entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.RoleRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RoleService implements RoleServiceInterface {
    private RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional
    public void addRole(Role role) {
        this.roleRepository.save(role);
    }

    @Override
    @Transactional
    public void removeRole(int id) {
        this.roleRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Role getRoleById(int id) {
        return this.roleRepository.getOne(id);
    }

    @Override
    @Transactional
    public List<Role> roleList() {
        return this.roleRepository.findAll();
    }
}

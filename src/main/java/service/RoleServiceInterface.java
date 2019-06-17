package service;

import Entity.Role;

import java.util.List;

public interface RoleServiceInterface {
    public void addRole(Role role);

    public void removeRole(int id);

    public Role getRoleById(int id);

    public List<Role> roleList();
}

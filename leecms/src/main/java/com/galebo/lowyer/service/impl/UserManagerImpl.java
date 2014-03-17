package com.galebo.lowyer.service.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.galebo.lowyer.dao.ibatis.iBatisDaoUtils;
import com.galebo.lowyer.model.Role;
import com.galebo.lowyer.model.User;
import com.galebo.lowyer.service.UserExistsException;
import com.galebo.lowyer.service.UserManager;
import com.galebo.lowyer.service.UserService;
import com.galebo.lowyer.services.impl.BaseService;


/**
 * Implementation of UserManager interface.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
@Service("userManager")
public class UserManagerImpl extends BaseService implements UserManager, UserService,UserDetailsService {
    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
    /**
     * {@inheritDoc}
     */
	public User getUser(String userId) {
        User user = _getUser(userId);

        if (user == null) {
            log.warn("uh oh, user not found...");
            throw new ObjectRetrievalFailureException(User.class, userId);
        } else {
            List<Role> roles = _getUserRoles(user);
            user.setRoles(new HashSet<Role>(roles));
        }

        return user;
    }

    /**
     * {@inheritDoc}
     */
    public List<User> getUsers() {
        return _getUsers();
    }

    /**
     * {@inheritDoc}
     */
    public User saveUser(User user) throws UserExistsException {

        if (user.getVersion() == null) {
            // if new user, lowercase userId
            user.setUsername(user.getUsername().toLowerCase());
        }

        // Get and prepare password management-related artifacts
        boolean passwordChanged = false;
        if (passwordEncoder != null) {
            // Check whether we have to encrypt (or re-encrypt) the password
            if (user.getVersion() == null) {
                // New user, always encrypt
                passwordChanged = true;
            } else {
                // Existing user, check password in DB
                String currentPassword = getUserPassword(user.getUsername());
                if (currentPassword == null) {
                    passwordChanged = true;
                } else {
                    if (!currentPassword.equals(user.getPassword())) {
                        passwordChanged = true;
                    }
                }
            }

            // If password was changed (or new user), encrypt it
            if (passwordChanged) {
                user.setPassword(passwordEncoder.encodePassword(user.getPassword(), null));
            }
        } else {
            log.warn("PasswordEncoder not set, skipping password encryption...");
        }

        try {
            return saveUser1(user);
        } catch (DataIntegrityViolationException e) {
            //e.printStackTrace();
            log.warn(e.getMessage());
            throw new UserExistsException("User '" + user.getUsername() + "' already exists!");
        } catch (JpaSystemException e) { // needed for JPA
            //e.printStackTrace();
            log.warn(e.getMessage());
            throw new UserExistsException("User '" + user.getUsername() + "' already exists!");
        }
    }

    /**
     * {@inheritDoc}
     */
    public void removeUser(String userId) {
        log.debug("removing user: " + userId);
        _removeUser(userId);
    }

    /**
     * {@inheritDoc}
     *
     * @param username the login name of the human
     * @return User the populated user object
     * @throws UsernameNotFoundException thrown when username not found
     */
	public User getUserByUsername(String username) throws UsernameNotFoundException {
        User user = (User) _getUserByUsername(username);

        if (user == null) {
            log.warn("uh oh, user not found...");
            throw new UsernameNotFoundException("user '" + username + "' not found...");
        } else {
            List<Role> roles = _getUserRoles(user);
            user.setRoles(new HashSet<Role>(roles));
        }

        return user;
    }

    /**
     * {@inheritDoc}
     */
    public List<User> search(String searchTerm) {
        return super.getUsers(searchTerm);
    }


    /**
     * {@inheritDoc}
     */
    public List<User> getUsers2() {
        List<User> users = _getUsers();

        // get the roles for each user
        for (int i = 0; i < users.size(); i++) {
            User user = (User) users.get(i);

            List<Role> roles =  _getUserRoles(user);
            user.setRoles(new HashSet<Role>(roles));
            users.set(i, user);
        }

        return users;
    }

    /**
     * Convenience method to delete roles
     * @param userId the id of the user to delete
     */
    private void deleteUserRoles(final Long userId) {
    	_deleteUserRoles(userId);
    }

    private void addUserRoles(final User user) {
        if (user.getRoles() != null) {
            for (Role role : user.getRoles()) {
                Map<String, Long> newRole = new HashMap<String, Long>();
                newRole.put("userId", user.getId());
                newRole.put("roleId", role.getId());

                List<Role> userRoles = _getUserRoles(user);
                if (userRoles.isEmpty()) {
                	_addUserRole(newRole);
                }
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    private User saveUser1(final User user) {
        iBatisDaoUtils.prepareObjectForSaveOrUpdate(user);

        if (user.getId() == null) {
            Long id =  _addUser(user);
            user.setId(id);
            addUserRoles(user);
        } else {
        	_updateUser(user);
            deleteUserRoles(user.getId());
            addUserRoles(user);
        }
        return user;
    }


     
     /**
      * {@inheritDoc}
      */
     public String getUserPassword(String username) {
         return _getUserPassword(username);
     }

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
		return getUserByUsername(username);
	}
}

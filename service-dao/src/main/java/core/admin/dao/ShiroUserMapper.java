package core.admin.dao;

import core.admin.domain.NetworkUser;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ShiroUserMapper {
	NetworkUser getByUserName(String username);

	Set<String> getRoles(String username);

	Set<String> getPermissions(String username);
	
}
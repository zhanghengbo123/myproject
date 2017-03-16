package core.admin.dao;

import core.admin.domain.NetworkUser;
import java.util.Set;


public interface ShiroUserMapper {
	NetworkUser getByUserName(String username);

	Set<String> getRoles(String username);

	Set<String> getPermissions(String username);
	
}
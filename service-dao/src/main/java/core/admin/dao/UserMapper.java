package core.admin.dao;

import core.admin.domain.NetworkUser;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
     public NetworkUser getUserByCredential(@Param("mobile") String mobile, @Param("password") String password);

     public  Integer countAdminUserList();

     public List<NetworkUser> findAdminUserList(Map<String, Object> params);

     public Integer resetPassword(@Param("id") Long id, @Param("cipher") String cipher, @Param("now") Long now);

     public Integer updateStatus(@Param("id") Integer id, @Param("status") Integer status, @Param("now") Long now);

     public Integer removeNetworkUser(Long id);

     public void createUser(NetworkUser user);

     public NetworkUser selectById(Long id);

     public void update(NetworkUser user);

     public Integer getUserByMobile(@Param("mobile") String mobile);

     public List proList();

      public List cityList(@Param("id") Long id);

     public List NetList(@Param("area_code") String areaCode);

    /* public String getProviceName(@Param("id")Integer id);*/

      public Long getCName(@Param("name") String cityCode);

     /*public List countryList(@Param("id")Long id);*/
 }

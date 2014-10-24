package com.uniweibo.privileges.service.redis;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Service;

import com.uniweibo.privileges.util.PrivilegeConstants;

/**
 * @author BillWu
 * @since 2014-10-13
 * @update 2014-10-16
 * @desc 权限模块  用户 redis层
 * @version 1.0
 * 
 */
@Service
public class UserRedis {

	public final String CLASS_NAME = this.getClass().getName();
	
	//注入redis Set集合的操作类
	@Resource(name="privilegesRedisTemplate")
	private SetOperations<String, String> setOperations;
	//注入redis List集合的操作类
	@Resource(name="privilegesRedisTemplate")
	private ListOperations<String, String> listOperations;
	
	/**
	 * @author BillWu
	 * @since 2014-10-13
	 * @update 2014-10-13
	 * @desc select List(role id) by userid.  
	 * @param String uid[用户id]
	 * @return List<String>[roleid组成的List]
	 */
	public List<String> selectRoidByUid(String uid){
		PrivilegeConstants.PRIVILEGE_LOGGER.debug(CLASS_NAME + ".selectRoidByUid . ");
		return listOperations.range(PrivilegeConstants.REDIS_USER_ROLE + uid, 0, -1);
	}

	/**
	 * @author BillWu
	 * @since 2014-10-16
	 * @update 2014-10-16
	 * @desc 根据 roleid 查出对应的resource列表 
	 * @param String roid[角色id]
	 * @return Set<String>[url组成的Set]
	 * @deprecated [此方法并不是out,只是没有业务用到]
	 */
	public Set<String> selectResourceByRoid(String roid) {
		PrivilegeConstants.PRIVILEGE_LOGGER.debug(CLASS_NAME + ".selectResourceByRoid . ");
		return setOperations.members(PrivilegeConstants.REDIS_ROLE_RESOURCE + roid);
	}
	
	/**
	 * @author BillWu
	 * @since 2014-10-16
	 * @update 2014-10-16
	 * @desc 根据 roidList 查出对应的resource列表 
	 * @param List<String> roidList[角色id组成的List]
	 * @return Set<String>[url组成的Set]
	 */
	public Set<String> selectResourceByRoidList(List<String> roidList) {
		PrivilegeConstants.PRIVILEGE_LOGGER.debug(CLASS_NAME + ".selectResourceByRoid . ");
		return setOperations.union(null, roidList);
	}

	/**
	 * @author BillWu
	 * @since 2014-10-16
	 * @update 2014-10-16
	 * @desc 根据 uid 查出对应的resource列表 
	 * @param List<String> uid[用户id]
	 * @return Set<String>[url组成的Set]
	 */
	public Set<String> selectResourceByUid(String uid) {
		PrivilegeConstants.PRIVILEGE_LOGGER.debug(CLASS_NAME + ".selectResourceByUid . ");
		return setOperations.members(PrivilegeConstants.REDIS_USER_RESOURCE + uid);
	}

	/**
	 * @author BillWu
	 * @since 2014-10-16
	 * @update 2014-10-16
	 * @desc 根据 uid 查出对应的reject resource列表 
	 * @param List<String> uid[用户id]
	 * @return Set<String>[url组成的Set]
	 */
	public Set<String> selectRejectResourceByUid(String uid) {
		PrivilegeConstants.PRIVILEGE_LOGGER.debug(CLASS_NAME + ".selectResourceByUid . ");
		return setOperations.members(PrivilegeConstants.REDIS_USER_REJECT_RESOURCE + uid);
	}
	
	/**
	 * @author BillWu
	 * @since 2014-10-17
	 * @update 2014-10-17
	 * @desc 判断Redis是否挂了
	 * @param 
	 * @return boolean[true:还没挂,false:挂了]
	 * @deprecated
	 */
	public boolean isRedisConnected() {
		//这里的具体实现方法，以后有待改进
		if (null == setOperations) {
			return false;
		} 
		return true;
	}
	
	
}

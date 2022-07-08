package model;

import java.util.ArrayList;
import java.util.List;


public class ManagementUser {
	public static List<User> list = new ArrayList<User>();

	public User findID(String userName) {
		for (User user : list) {
			if (user.getUserName().equals(userName))
				return user;
		}
		return null;
	}
	public int update (User user) {
		for (int i=0;i<list.size();i++) {
			if(user.getUserName().equals(list.get(i).getUserName())) {
				list.set(i, user) ;
				return i ;
			}
		}
		return -1;
	}
	public int save (User user) {
		if(findID(user.getUserName())!= null) {
			update(user);
		}else {
			list.add(user);
		}
		return 1;
	}
	public int delete (String Username) {
		User user = findID(Username) ;
		if(user!= null) {
			list.remove(user) ;
			return 1 ;
		}
		return -1;
	}
	public List<User> getAll (){
		return list ;
	}

}

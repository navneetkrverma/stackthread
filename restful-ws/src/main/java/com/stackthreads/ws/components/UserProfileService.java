package com.stackthreads.ws.components;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.stackthreads.ws.beans.UserProfile;

@Component
public class UserProfileService {

	private static List<UserProfile> users;
	private static int userCount = 3;
	static {
		users = new ArrayList<UserProfile>();
		users.add(new UserProfile(1, "adam", new Date()));
		users.add(new UserProfile(2, "eve", new Date()));
		users.add(new UserProfile(3, "jack", new Date()));
	}

	public List<UserProfile> getAllUsers() {
		return users;
	}

	public UserProfile getUser(int id) {
		UserProfile user = null;
		for (UserProfile usr : users) {
			if (usr.getId() == id) {
				user = usr;
				break;
			}
		}
		return user;
	}

	public UserProfile saveUser(UserProfile user) {
		user.setId(++userCount);
		users.add(user);
		return user;
	}

	public UserProfile deleteUser(int userId) {
		UserProfile user = null;

		Iterator<UserProfile> userItr = users.iterator();
		while (userItr.hasNext()) {
			UserProfile tmp = userItr.next();
			if (tmp.getId() == userId) {
				userItr.remove();
				user= tmp;
				break;
			}
		}
		return user;
	}

}

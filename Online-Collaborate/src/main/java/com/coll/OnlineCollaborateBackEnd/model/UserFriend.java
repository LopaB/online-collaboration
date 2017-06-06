package com.coll.OnlineCollaborateBackEnd.model;

import java.util.List;

public class UserFriend {
	List<User> usersToBeFriend;

	public List<User> getUsersToBeFriend() {
		return usersToBeFriend;
	}

	public void setUsersToBefriend(List<User> usersToBeFriend) {
		this.usersToBeFriend = usersToBeFriend;
	}
}

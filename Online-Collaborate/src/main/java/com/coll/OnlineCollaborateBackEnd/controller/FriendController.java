package com.coll.OnlineCollaborateBackEnd.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coll.OnlineCollaborateBackEnd.dao.IFriendDAO;
import com.coll.OnlineCollaborateBackEnd.dao.IUserDAO;
import com.coll.OnlineCollaborateBackEnd.model.Friend;
import com.coll.OnlineCollaborateBackEnd.model.User;

@RestController
public class FriendController {
	@Autowired
	IUserDAO userDAO;
	
	@Autowired
	IFriendDAO friendDAO;
	
	//Method to send friend request
			@PostMapping(value = {"/user/friendRequest/{id}"})
			public ResponseEntity<Friend> sendFriendRequest(@PathVariable("id") int id, @RequestBody Integer initId) {
					System.out.println("Sending friend request now!");
					Friend friend = new Friend();
					User user = userDAO.getUser(id); //Fetching friend by friend id
					friend.setFriendId(id);
					friend.setInitiatorId(initId);
					friend.setStatus("PENDING");
					friendDAO.addFriend(friend);
					return new ResponseEntity<Friend>(friend, HttpStatus.OK);
				}
			
			//Method to fetch friend requests
			@GetMapping(value = {"/user/friendRequest/list/{id}"})
			public ResponseEntity<List<User>> fetchRequest(@PathVariable("id") int userId) {
					System.out.println("Fetchng list of friend request received");
					List<Friend> friends = friendDAO.list(userId);
					List<User> users = new ArrayList<>();
					for(Friend fr : friends) {
						if(fr.getStatus().equals("PENDING")) {
							User user = userDAO.getUser(fr.getInitiatorId());
							users.add(user);
						}
					}
					return new ResponseEntity<List<User>>(users, HttpStatus.OK);
				}
			
			//Method to fetch friend requests
					@PostMapping(value = {"/user/friendRequest/approve/{userId}"})
					public ResponseEntity<Friend> approveRequest(@PathVariable("userId") int friendId, @RequestBody Integer userId) {
							System.out.println("Fetchng list of friend request received");
							List<Friend> friends = friendDAO.list(userId);
							List<User> users = new ArrayList<>();
							for(Friend fr : friends) {
								if(fr.getInitiatorId() == friendId) {
									fr.setStatus("APPROVED");
									friendDAO.updateFriend(fr);
								}
							}
							return new ResponseEntity<Friend>(HttpStatus.OK);
						}
			
					//Method to check user's friends
//					@RequestMapping(value = {"/user/friends/check/{id}"}, method = RequestMethod.GET)
//					public ResponseEntity<List<Friends>> fetchFriends(@PathVariable("id") int userId) {
//							System.out.println("Fetchng friends");
//							List<Friends> friends = friendsDAO.list(userId);
//							
//							return new ResponseEntity<List<Friends>>(friends, HttpStatus.OK);
//						}
					
					//Method to fetch friendsModel
					@GetMapping(value = {"/user/friends/model/{id}"})
					public ResponseEntity<List<User>> users(@PathVariable("id") int userId) {
							System.out.println("Fetching friends");
							List<User> users = friendDAO.noFriends(userId);  
							return new ResponseEntity<List<User>>(users, HttpStatus.OK);
						}
					
					/*//function to fetch user's friends
					@GetMapping(value = {"/my/friends/{id}"})
					public ResponseEntity<List<User>> fetchMyFriends(@PathVariable("id") int userId) {
							System.out.println("Fetchng friends");
							List<User> users = friendDAO.myFriends(userId);
							List<User> myFriends = new ArrayList<>();
							for(User user1 : users) {
								if(user1.getUserId() != userId) {
									myFriends.add(user1);
								}
							}
							System.out.println("Successfully fetch friends");
							return new ResponseEntity<List<User>>(myFriends, HttpStatus.OK);
						}*/

}

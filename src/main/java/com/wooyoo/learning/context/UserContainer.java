package com.wooyoo.learning.context;

import com.wooyoo.learning.model.domain.User;

import javax.servlet.http.HttpSession;

public class UserContainer {

   private  static ThreadLocal<User> userThreadLocal = new ThreadLocal();
   private static ThreadLocal<User> getThreadLocal(){return  userThreadLocal;}

   public UserContainer() {
   }

   public static User getUser() {
      return userThreadLocal.get();
   }

   public static void setUser(User user) {
      userThreadLocal.set(user);
   }

   public static void clear() {
      userThreadLocal.remove();
   }

}

package ru.bur.session;

import ru.bur.domain.db.tables.pojos.AppUser;

public class ThreadLocalCurrentUser {

    private static ThreadLocal<AppUser> userThreadLocal = new ThreadLocal<>();

    public static AppUser getAppUser() {
        return userThreadLocal.get();
    }

    public static void setAppUser(AppUser appUser) {
        userThreadLocal.set(appUser);
    }

}

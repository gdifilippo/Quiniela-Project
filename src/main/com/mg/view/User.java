package com.mg.view;

import com.mg.view.key.PoolKey;
import com.mg.view.key.UserKey;

import java.util.ArrayList;
import java.util.List;

public class User
{
    private final UserKey userKey;
    private final List<PoolKey> adminPool;
    private final List<PoolKey> playerPool;

    public User(UserKey userKey)
    {
        this.userKey = userKey;
        adminPool = new ArrayList<>();
        playerPool = new ArrayList<>();
    }

    public User(UserKey userKey, List<PoolKey> adminPool, List<PoolKey> playerPool)
    {
        this.userKey = userKey;
        this.adminPool = adminPool;
        this.playerPool = playerPool;
    }

    //TODO: create/join pool
    //TODO: submit predition (whatever those will be)

    //TODO: Create Editor to add/remove user in db.
}

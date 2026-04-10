package com.example.my_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class UsersDao {
    private UsersDatabaseHelper usersDatabaseHelper;
    //作用：只用进行一次，简化代码
    public UsersDao(Context context) {
        usersDatabaseHelper = new UsersDatabaseHelper(context,"user.db",null,1);
    }

    //在我这里register是登录，login是注册
    public boolean login(String username,String password){
        SQLiteDatabase db = usersDatabaseHelper.getWritableDatabase();

        //检查用户名是否存在
        if (isUsernameExists(username)){
            db.close();
            return false;
        }

        ContentValues values = new ContentValues();
        values.put("username",username);
        values.put("password",password);

        long result = db.insert("User",null,values);
        db.close();
        return result != -1;
    }

    public boolean register(String username,String password){
        SQLiteDatabase db = usersDatabaseHelper.getReadableDatabase();

        String selection = "username = ? AND password = ?";
        String[] selectionArgs = {username,password};

        Cursor cursor = db.query(
                "User",
                null,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        boolean success = cursor.getCount() > 0;
        cursor.close();
        db.close();

        return success;
    }

    public boolean isUsernameExists(String username){
        SQLiteDatabase db = usersDatabaseHelper.getReadableDatabase();
        //要查的东西
        String selection = "username = ?";
        String[] selectionArgs = {username};
        //查询
        Cursor cursor = db.query(
                "User",
                new String[]{"username"},
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        //返回查询结果的行数，如果大于0，说明匹配到了
        boolean exists = cursor.getCount() > 0;
        cursor.close();

        return exists;
    }
    //有一个根据用户名获取用户信息的方法没写，感觉可能用不到，用到再说吧
}

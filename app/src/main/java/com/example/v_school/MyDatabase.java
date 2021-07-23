package com.example.v_school;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyDatabase extends SQLiteOpenHelper {

    private final static String DATABASE_NAME = "mydbV";
    private final static String STUDENT_TABLE = "student";
    private final static String ACCOUNT_TABLE = "account";
    private final static String NOTIFICATION_TABLE = "notification";
    private final static String GRADE_TABLE = "grade";

    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    public MyDatabase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createAccount = "create table " + ACCOUNT_TABLE + " (id TEXT PRIMARY KEY,username TEXT,password TEXT, phone TEXT UNIQUE,address TEXT, role TEXT)";
        String createStudent = "create table " + STUDENT_TABLE + " (id TEXT PRIMARY KEY, name TEXT, classes TEXT,idSchool TEXT, idParent TEXT," +
                "FOREIGN KEY(idSchool) REFERENCES account(id)," +
                "FOREIGN KEY(idParent) REFERENCES account(id))";
        String createNoti = "create table " + NOTIFICATION_TABLE + " (id INTEGER PRIMARY KEY AUTOINCREMENT,idFrom TEXT, idTo TEXT, topic TEXT, message TEXT, day TEXT,isRead INTEGER DEFAULT 0," +
                "FOREIGN KEY(idFrom) REFERENCES account(id)," +
                "FOREIGN KEY(idTo) REFERENCES account(id))";
        String createGrade = "create table " + GRADE_TABLE + " (id INTEGER PRIMARY KEY AUTOINCREMENT,idStudent TEXT, year TEXT, sememter TEXT, toan REAL, van REAl, anh REAL, tb REAL," +
                "FOREIGN KEY(idStudent) REFERENCES student(id))";
        db.execSQL(createAccount);
        db.execSQL(createStudent);
        db.execSQL(createNoti);
        db.execSQL(createGrade);
        String a = "INSERT INTO account  VALUES ('nghia01', 'Phú Nghĩa', '123123', '0123456789', '123 Lê Văn Hiến', 'PARENT')";
        String b = "INSERT INTO account  VALUES ('binh01', 'Công Bình', '123123', '0987654321', '70 Nguyễn Hữu Cảnh', 'PARENT')";
        String c = "INSERT INTO account  VALUES ('khanh01', 'Ngọc Khánh', '123123', '0765926169', '51 Thành Vinh 1', 'PARENT')";
        String aa = "INSERT INTO account  VALUES ('lam01', 'Thanh Lâm', '123123', '0888888888', '31 Quang Trung', 'PARENT')";
        String bb = "INSERT INTO account  VALUES ('phuc01', 'Ngọc Phúc', '123123', '011111111', '10 Ngô Quyền', 'PARENT')";
        String d = "INSERT INTO account  VALUES ('bachdang001', 'Trường Tiểu học Bạch Đằng', '123123', '0123123123', '123 Trưng Nữ Vương', 'SCHOOL')";
        db.execSQL(a);
        db.execSQL(b);
        db.execSQL(c);
        db.execSQL(d);db.execSQL(aa);db.execSQL(bb);
        String e = "INSERT INTO student VALUES ('de1', 'Đinh Hoa', '2a', 'bachdang001', 'nghia01')";
        String f = "INSERT INTO student VALUES ('de2', 'Công Hoàng', '1a', 'bachdang001', 'binh01')";
        String g = "INSERT INTO student VALUES ('de3', 'Ngọc Bội', '3c', 'bachdang001', 'khanh01')";
        String gg = "INSERT INTO student VALUES ('de4', 'Thanh Trúc', '5c', 'bachdang001', 'lam01')";
        String ggg = "INSERT INTO student VALUES ('de5', 'Phúc Thọ', '4a', 'bachdang001', 'phuc01')";
        db.execSQL(e);
        db.execSQL(f);
        db.execSQL(g);db.execSQL(gg);db.execSQL(ggg);
        String h = "INSERT INTO grade VALUES (1, 'kì 1', '2020-2021','de1', 8, 8, 8, 8 )";
        String k = "INSERT INTO grade  VALUES (2, 'kì 2', '2020-2021','de1', 7, 7, 8, 7.3)";
        String i = "INSERT INTO grade  VALUES (3, 'kì 1', '2020-2021','de2', 9, 7, 8, 8 )";
        String m = "INSERT INTO grade  VALUES (4, 'kì 2', '2020-2021','de2', 6, 5, 10, 7 )";
        String l = "INSERT INTO grade VALUES (5, 'kì 1', '2020-2021','de3', 9, 9, 9, 9 )";
        String n = "INSERT INTO grade VALUES (6, 'kì 2', '2020-2021','de3', 8, 8, 7, 7.6 )";
        db.execSQL(h);
        db.execSQL(k);
        db.execSQL(i);
        db.execSQL(m);
        db.execSQL(l);
        db.execSQL(n);
        String a1 = "INSERT INTO notification(idFrom,idTo,topic,message,day) values('bachdang001','khanh01','Học phí','Học phí tháng 5: 100.000đ','22/05/2021')";
        String a2 = "INSERT INTO notification(idFrom,idTo,topic,message,day) values('bachdang001','khanh01','Học phí','Học phí tháng 6: 100.000đ','22/06/2021')";
        String a3 = "INSERT INTO notification(idFrom,idTo,topic,message,day) values('bachdang001','khanh01','Điểm số','-Toán: 8đ, Văn: 9đ, Anh: 9đ','22/07/2021')";
        String a4 = "INSERT INTO notification(idFrom,idTo,topic,message,day) values('bachdang001','binh01','Nghỉ học','Ngày mai hs được nghỉ học','22/08/2021')";
        String a5 = "INSERT INTO notification(idFrom,idTo,topic,message,day) values('bachdang001','nghia01','Học phí','Học phí tháng 5: 100.000đ','22/05/2021')";
        String a6 = "INSERT INTO notification(idFrom,idTo,topic,message,day) values('bachdang001','nghia01','Học phí','Học phí tháng 6: 100.000đ','22/06/2021')";
        String a7 = "INSERT INTO notification(idFrom,idTo,topic,message,day) values('bachdang001','nghia01','Điểm','Toán: 8đ,Văn: 9đ, Anh: 5đ','22/07/2021')";
        String a8 = "INSERT INTO notification(idFrom,idTo,topic,message,day) values('bachdang001','nghia01','Lịch học','T2 T3 T4','22/07/2021')";
        String a9 = "INSERT INTO notification(idFrom,idTo,topic,message,day) values('bachdang001','nghia01','Thu phí wc','100.000đ','22/07/2021')";
        String a10 = "INSERT INTO notification(idFrom,idTo,topic,message,day) values('bachdang001','binh01','Học phí','Học phí tháng 5: 100.000đ','22/07/2021')";
        db.execSQL(a1);db.execSQL(a2);db.execSQL(a3);db.execSQL(a4);db.execSQL(a5);db.execSQL(a6);db.execSQL(a7);db.execSQL(a8);db.execSQL(a9);db.execSQL(a10);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + ACCOUNT_TABLE);
        db.execSQL("drop table if exists " + STUDENT_TABLE);
        db.execSQL("drop table if exists " + NOTIFICATION_TABLE);
        db.execSQL("drop table if exists " + GRADE_TABLE);
    }

    //drop database
    public void dropDB() {
        String sql = "detach DATABASE" + DATABASE_NAME;
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
    }

    // insert Student
    public void insertStudent(String id, String name, String classes, String idSchool, String idParent) {
        String sql = "insert into " + STUDENT_TABLE + " values ('" + id + "','" + name + "','" + classes + "','" + idSchool + "','" + idParent + "')";
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
    }

    // insert Account
    public void insertAcc(String id, String username, String password, String phone, String address, String role) {
        String sql = "insert into " + ACCOUNT_TABLE + " values ('" + id + "','" + username + "','" + password + "','" + phone + "','" + address + "','" + role + "')";
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
    }

    //insert Notification
    public void insertNoti(String idFrom, String idTo, String topic, String message, String day) {
        String sql = "insert into " + NOTIFICATION_TABLE + "(idFrom,idTo,topic,message,day) values ('" + idFrom + "','" + idTo + "','" + topic + "','" + message + "','" + day + "')";
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
    }

    //insert Grade
    public void insertGrade(String idStudent, String semeter, String year, float toan, float van, float anh) {
        String sql = "insert into " + ACCOUNT_TABLE + " values ('" + idStudent + "','" + semeter + "','" + year + "'," + toan + "," + van + "," + anh + ")";
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
    }

    //get all Student by parent
    public ArrayList<Student> getStudentsByParent(String inputIdParent) {
        ArrayList<Student> listStudent = new ArrayList<>();
        String sql = "select * from " + STUDENT_TABLE + " where idParent= '" + inputIdParent + "'";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            int id = cursor.getColumnIndex("id");
            int name = cursor.getColumnIndex("name");
            int classes = cursor.getColumnIndex("classes");
            int idSchool = cursor.getColumnIndex("idSchool");
            int idParent = cursor.getColumnIndex("idParent");
            listStudent.add(new Student(cursor.getString(id), cursor.getString(name), cursor.getString(classes), cursor.getString(idSchool), cursor.getString(idParent)));
        }
        cursor.close();
        return listStudent;
    }

    // get Student by id
    public Student getOneStudent(String id) {
        String sql = "select * from " + STUDENT_TABLE + " where id = '" + id + "'";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor == null) {
            return null;
        }
        Student student = new Student();
        student.setId(cursor.getString(cursor.getColumnIndex("id")));
        student.setName(cursor.getString(cursor.getColumnIndex("name")));
        student.setClasses(cursor.getString(cursor.getColumnIndex("classes")));
        student.setIdSchool(cursor.getString(cursor.getColumnIndex("idSchool")));
        student.setIdParent(cursor.getString(cursor.getColumnIndex("idParent")));
        return student;

    }


    //Account login
    public Account loginAccount(String phone, String password) {
        String sql = "select * from " + ACCOUNT_TABLE + " where phone = '" + phone + "' and password = '" + password + "'";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToNext() == false) {
            return null;
        }
        Account account = new Account();
        account.setId(cursor.getString(cursor.getColumnIndex("id")));
        account.setUsername(cursor.getString(cursor.getColumnIndex("username")));
        account.setPhone(cursor.getString(cursor.getColumnIndex("phone")));
        account.setAddress(cursor.getString(cursor.getColumnIndex("address")));
        account.setRole(cursor.getString(cursor.getColumnIndex("role")));
        return account;

    }
    //Account login
    public Account getAccById(String id) {
        String sql = "select * from " + ACCOUNT_TABLE + " where id = '" + id  + "'";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToNext() == false) {
            return null;
        }
        Account account = new Account();
        account.setId(cursor.getString(cursor.getColumnIndex("id")));
        account.setUsername(cursor.getString(cursor.getColumnIndex("username")));
        account.setPhone(cursor.getString(cursor.getColumnIndex("phone")));
        account.setAddress(cursor.getString(cursor.getColumnIndex("address")));
        account.setRole(cursor.getString(cursor.getColumnIndex("role")));
        return account;

    }

    // get all noti
    public ArrayList<Notification> getAllNoti(Account loginAccount) {
        ArrayList<Notification> listNoti = new ArrayList<>();
        String sql = "select * from " + NOTIFICATION_TABLE + " where idTo = '" + loginAccount.getId() + "'";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            int id = cursor.getColumnIndex("id");
            int idFrom = cursor.getColumnIndex("idFrom");
            int idTo = cursor.getColumnIndex("idTo");
            int topic = cursor.getColumnIndex("topic");
            int message = cursor.getColumnIndex("message");
            int day = cursor.getColumnIndex("day");
            int isRead = cursor.getColumnIndex("isRead");
            listNoti.add(new Notification(cursor.getInt(id), cursor.getString(idFrom), cursor.getString(idTo), cursor.getString(topic), cursor.getString(message), cursor.getString(day), cursor.getInt(isRead)));
        }
        cursor.close();
        return listNoti;
    }

    // get one noti
    public Notification getOneNoti(int id) {
        String sql = "select * from " + NOTIFICATION_TABLE + " where id = " + id;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor == null) {
            return null;
        }
        Notification notification = new Notification();
        notification.setId(cursor.getInt(cursor.getColumnIndex("id")));
        notification.setIdFrom(cursor.getString(cursor.getColumnIndex("idFrom")));
        notification.setIdTo(cursor.getString(cursor.getColumnIndex("idTo")));
        notification.setTopic(cursor.getString(cursor.getColumnIndex("topic")));
        notification.setMessage(cursor.getString(cursor.getColumnIndex("message")));
        notification.setDay(cursor.getString(cursor.getColumnIndex("day")));
        return notification;

    }

    // get grade by idStudent
    public ArrayList<Grade> getGradeByStudent(String inputIdStudent) {
        ArrayList<Grade> listGrade = new ArrayList<>();
        String sql = "select * from " + GRADE_TABLE + " where idStudent = '" + inputIdStudent + "'";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            int id = cursor.getColumnIndex("id");
            int idStudent = cursor.getColumnIndex("idStudent");
            int semeter = cursor.getColumnIndex("semeter");
            int year = cursor.getColumnIndex("year");
            int toan = cursor.getColumnIndex("toan");
            int van = cursor.getColumnIndex("van");
            int anh = cursor.getColumnIndex("anh");
            listGrade.add(new Grade(cursor.getInt(id), cursor.getString(idStudent), cursor.getString(semeter), cursor.getString(year), cursor.getFloat(toan), cursor.getFloat(van), cursor.getFloat(anh)));
        }
        cursor.close();
        return listGrade;
    }

    // get parent
    public ArrayList<Account> getParents() {
        ArrayList<Account> listParent = new ArrayList<>();
        String sql = "select * from " + ACCOUNT_TABLE + " where role = 'PARENT'";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            int id = cursor.getColumnIndex("id");
            int username = cursor.getColumnIndex("username");
            int phone = cursor.getColumnIndex("phone");
            int address = cursor.getColumnIndex("address");
            int role = cursor.getColumnIndex("role");

            listParent.add(new Account(cursor.getString(id), cursor.getString(username), cursor.getString(phone), cursor.getString(address), cursor.getString(role)));
        }
        cursor.close();
        return listParent;
    }

    // set is Read
    public void setIsRead(int id) {
        String sql = "update " + NOTIFICATION_TABLE + " set isRead= " + 1 + " where id= " + "'" + id + "'";
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
    }

    //edit profile
    public void editProfile(String id, String newName, String newPhone, String newAdd) {
        String sql = "update " + ACCOUNT_TABLE + " set username= '" + newName + "', phone= '" + newPhone + "', address= '" + newAdd + "' where id= '" + id + "'";
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
    }

    //change password
    public void changePass(String id, String newPass) {
        String sql = "update " + ACCOUNT_TABLE + " set password= '" + newPass + "' where id= '" + id + "'";
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
    }

    // get noti newest
    public ArrayList<Notification> getNotiNewest(int top) {
        ArrayList<Notification> listNoti=new ArrayList<>();
        String sql = "select * from " + NOTIFICATION_TABLE + " order by id DESC LIMIT " + top;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            int id = cursor.getColumnIndex("id");
            int idFrom = cursor.getColumnIndex("idFrom");
            int idTo = cursor.getColumnIndex("idTo");
            int topic = cursor.getColumnIndex("topic");
            int message = cursor.getColumnIndex("message");
            int day = cursor.getColumnIndex("day");
            int isRead = cursor.getColumnIndex("isRead");
            listNoti.add(new Notification(cursor.getInt(id), cursor.getString(idFrom), cursor.getString(idTo), cursor.getString(topic), cursor.getString(message), cursor.getString(day), cursor.getInt(isRead)));
        }
        cursor.close();
        return listNoti;
    }

    // get account by phone
    public Account getAccountByPhone(String phone) {
        String sql = "select * from " + ACCOUNT_TABLE + " where phone = '" + phone + "'";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToNext() == false) {
            return null;
        }
        Account account = new Account();
        account.setId(cursor.getString(cursor.getColumnIndex("id")));
        account.setUsername(cursor.getString(cursor.getColumnIndex("username")));
        account.setPhone(cursor.getString(cursor.getColumnIndex("phone")));
        account.setAddress(cursor.getString(cursor.getColumnIndex("address")));
        account.setRole(cursor.getString(cursor.getColumnIndex("role")));
        account.setPassword(cursor.getString(cursor.getColumnIndex("password")));
        return account;

    }
}

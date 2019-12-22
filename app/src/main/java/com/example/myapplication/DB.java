package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.Toast;

import java.sql.Statement;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by ASUS A555L on 1/12/2018.
 */

public class DB extends SQLiteOpenHelper {        // making name of db to comunicate with it



    //Variables
    public static final String DBname = "carRent.db";
    public static ArrayList<CarInfo> cars_ArrayList;
    Context myContext;




    //Constructor
    public DB(Context context)
    {
        super(context, DBname, null, 1);
    }




    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create table CarTable (car_id INTEGER PRIMARY KEY AUTOINCREMENT,name VARCHAR(25) , number VARCHAR(25) , model VARCHAR(10) , new_car BOOLEAN)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS CarTable");
         onCreate(db);
    }





    //_____________________________________________________System Functionality Functions__________________________________________________________//


    public  boolean insertData(String carRegis, String carName , String carModel,Boolean carStatus)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("number", carRegis);
        contentValues.put("name", carName);
        contentValues.put("model", carModel);
        contentValues.put("new_car",carStatus);

        long result = db.insert("CarTable", null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }



     int updateCarInfo(String carID, String carRegis, String carName , String carModel,boolean carStatus)
    {
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put("number" , carRegis );
        contentValues.put("name"   , carName  );
        contentValues.put("model"  , carModel );
        contentValues.put("new_car", carStatus);

        int updateResult=db.update("CarTable",contentValues," car_id=? ", new String[] {carID} );
        Log.e("DB","_____________________________Number Of Updated Record: "+updateResult);
        db.close();
        return updateResult;
    }


     /**
      *   Get All The Cars From The Database
      */
       ArrayList<CarInfo> getCarsFromDB()
       {
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor res = db.rawQuery("SELECT * FROM CarTable ORDER BY car_id DESC", null);
            cars_ArrayList = new ArrayList<CarInfo>();

               while (res.moveToNext())
               {
                   String car_id      = res.getString(0);
                   String theCarName  = res.getString(1);
                   String carRigistNo = res.getString(2);
                   String carModel    = res.getString(3);
                   String carStatus   = res.getString(4);
                   cars_ArrayList.add(new CarInfo(car_id,theCarName,carModel,carRigistNo,carStatus));
               }

           db.close();
           return cars_ArrayList;
       }




       void deleteCarFromDB(String car_id)
       {
           SQLiteDatabase db=this.getWritableDatabase();
           db.execSQL("DELETE FROM CarTable  WHERE car_id="+car_id );
           db.close();
       }


    } //End Class






//        // Test Only
//        Iterator<CarInfo> ite = cars_ArrayList.iterator(); // to loop through the array list
//        while (ite.hasNext()) // as long as there are Titles(Categories) keep Retrieving
//        {
//            CarInfo currentPosistion=ite.next();
//            Log.e("TEST","---------------------------ArrayList From DB_________________"+"Car ID: "+currentPosistion.getCarID()+" CATE TITLE: "+currentPosistion.getCarName() +"\n");
//        }


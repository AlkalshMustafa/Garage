package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {


    //_____________Variables___________________
    public static DB db_object;
    ListView listViewOfCars;
    //_________________________________________


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_design);

        db_object = new DB(this); // Get a database connection


        // Add Car Button
        Button addcar = (Button) findViewById(R.id.addcarbutton_ID);
        addcar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddCar.class);
                startActivity(intent);
            }
        });



    } //End onCreate


    @Override
    protected void onResume() {
        super.onResume();


        //Add ArrayList of Cars from Database to the MainActivity
        if (db_object.getCarsFromDB() != null) {
            final CarsInfoAdapter carsInfo_Adapter;
            carsInfo_Adapter = new CarsInfoAdapter(db_object.getCarsFromDB(), getApplicationContext());
            listViewOfCars = (ListView) findViewById(R.id.displayCars_listView_ID);
            listViewOfCars.setAdapter(carsInfo_Adapter);
            carsInfo_Adapter.notifyDataSetChanged();


            //select car form the list to Delete or Update
            listViewOfCars.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    final CarInfo carInfo = db_object.getCarsFromDB().get(position);
                    Intent openCarDetailsIntent = new Intent(MainActivity.this, EditCar.class);

                    openCarDetailsIntent.putExtra("Car-ID", carInfo.getCarID());
                    openCarDetailsIntent.putExtra("Car-Regi", carInfo.getCarRegistrationNumber());
                    openCarDetailsIntent.putExtra("Car-Name", carInfo.getCarName());
                    openCarDetailsIntent.putExtra("Car-Model", carInfo.getCarModel());
                    openCarDetailsIntent.putExtra("Car-Status", carInfo.getCarStatus());
                    startActivity(openCarDetailsIntent);

                }
            });


        }


    }


}

package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;


public class AddCar extends AppCompatActivity {


     DB db_obj ;
    EditText carName_EditText , carRegis_EditText , carModel_EditText ;
    CheckBox carStatus_checkbox;
    Button addCarButton;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);







        carRegis_EditText  = (EditText) findViewById(R.id.carRegistration_editText_ID);
        carName_EditText   = (EditText) findViewById(R.id.carName_editText_ID);
        carModel_EditText  = (EditText) findViewById(R.id.carModel_editText_ID);
        carStatus_checkbox = (CheckBox) findViewById(R.id.carStatus_checkBox_ID);


//        carStatus_checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
//        {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked)
//            {
////                if(isChecked)
////                {
////                    Log.e("CheckBox","The Car is New ");
////                    //insert 1
////                } else
////                    {
////                    Log.e("CheckBox","The Car is NOT New ");
////                    //insert 0
////                    }
//            }
//        }
//        );



        addCarButton=(Button) findViewById(R.id.addCarButton_ID);
        addCarButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                db_obj=new DB(getApplicationContext());
                String  carRegis  = carRegis_EditText.getText().toString();
                String  carName   = carName_EditText.getText().toString();
                String  carModel  = carModel_EditText.getText().toString();
                boolean newOrNot  = carStatus_checkbox.isChecked();

                Boolean result = db_obj.insertData(carRegis,carName,carModel,newOrNot);
                if (result = true)
                {
                    Log.
                    Toast.makeText(AddCar.this, "Car Added Successfully ✔", Toast.LENGTH_LONG).show();
                    finish();
                }
                 else
                    if(result = false)
                    {
                      Toast.makeText(AddCar.this, " Failed to Add Car!", Toast.LENGTH_LONG).show();
                    }


            }//end Click Listener
        });








    } //End of onCreate()





}  //End CLass

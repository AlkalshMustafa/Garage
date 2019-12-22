package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;


public class EditCar extends AppCompatActivity {


    DB db = new DB(this);


    //______________Widgets__________________
    private EditText carNameEditText;
    private EditText carRegistEditText;
    private EditText carModelEditText;
    private CheckBox carStausCheckBox;
    private Button   saveButton;
    private Button   deleteButton;
    //_____________________________________




    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_car);

        carRegistEditText = (EditText)  findViewById(R.id.carRegis_Edittxt_ID);
        carNameEditText   = (EditText)  findViewById(R.id.carName_Edittxt_ID);
        carModelEditText  = (EditText)  findViewById(R.id.carModel_Edittxt_ID);
        carStausCheckBox  = (CheckBox)  findViewById(R.id.checkBox_ID);
        saveButton        = (Button)    findViewById(R.id.saveButton_ID);
        deleteButton      = (Button)    findViewById(R.id.deleteButton_ID);


        //Intent - Data from 'MainActivity'
        final String carID    =getIntent().getStringExtra("Car-ID");
        final String carRegis =getIntent().getStringExtra("Car-Regi");
        final String carName  =getIntent().getStringExtra("Car-Name");
        final String carModel =getIntent().getStringExtra("Car-Model");
        final String carStatus=getIntent().getStringExtra("Car-Status");

        carRegistEditText.setText(carRegis);
        carNameEditText  .setText(carName);
        carModelEditText .setText(carModel);
        if(carStatus.equals("1"))
        {
            carStausCheckBox.setChecked(!carStausCheckBox.isChecked());
        }




        /**
         *  Save/ Update Button
         */
        saveButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String car_reg=carRegistEditText.getText().toString();
                String car_name=carNameEditText.getText().toString();
                String car_model=carModelEditText.getText().toString();
                boolean car_status=carStausCheckBox.isChecked();

                int numberOfUpdatedRecord=db.updateCarInfo(carID,car_reg,car_name,car_model,car_status); //only car ID from Intent
                if (numberOfUpdatedRecord>0)
                {
                    Toast.makeText( EditCar.this, "Car Updated Successfully ✔", Toast.LENGTH_LONG).show();
                    } else
                    {
                        Toast.makeText(EditCar.this, "Nothing Updated!", Toast.LENGTH_LONG).show();
                    }
                finish();
            }
        });



        /**
         *  Delete Button
         */
        deleteButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                db.deleteCarFromDB(carID);
                Toast.makeText( EditCar.this, "Car Deleted Successfully ✔", Toast.LENGTH_LONG).show();
                finish();
            }
        });


    } //End OnCreate()



} //End Class
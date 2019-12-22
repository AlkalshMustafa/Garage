package com.example.myapplication;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;





public class CarsInfoAdapter extends ArrayAdapter<CarInfo> implements View.OnClickListener {

    private ArrayList<CarInfo> dataSet;
    Context mContext;



    //Main Constructor
    public CarsInfoAdapter(ArrayList<CarInfo> dataArrayList, Context mContext)
    {
        super(mContext, R.layout.main_activity_design,dataArrayList); //method
        this.dataSet=dataArrayList;
        this.mContext=mContext;
    }







    private class CatogViewHolder
    {
        TextView carNameTextView;
        TextView carRegistrationNumberTextView;

    } //END CLass




    @Override
    public void onClick(View v)
    {

        //to get the position of the clicked object and then retrive the data of this object
        int position=(Integer) v.getTag();
        Object obj= getItem(position);
        CarInfo catogModel=(CarInfo)obj;

    } //end onClick()







    private int lastPosition = -1;
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {


        // get the data for the object with this position
       CarInfo  obj=getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        CatogViewHolder catogViewHolderObj; // view lookup cache stored in tag

        final View result;

        if(convertView==null)
        {

            catogViewHolderObj=new CatogViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_design, parent, false);   //change the row_item
            catogViewHolderObj.carNameTextView= (TextView) convertView.findViewById(R.id.carName_TextView_ID); //change versionNnumberTextView_ID to the new ID
            catogViewHolderObj.carRegistrationNumberTextView=(TextView) convertView.findViewById(R.id.carRegis_TextView_ID);
            result=convertView;
            convertView.setTag(catogViewHolderObj);



        } else {
                 catogViewHolderObj=(CatogViewHolder) convertView.getTag();
                 result=convertView;
               } //end else




        //Set the values to the components
        if(obj.getCarName() != null)
        {
          catogViewHolderObj.carNameTextView.setText(obj.getCarName());
          catogViewHolderObj.carRegistrationNumberTextView.setText(obj.getCarRegistrationNumber());
          catogViewHolderObj.carNameTextView.setTag(position);
        }


        //Adding the animations
        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        convertView.startAnimation(animation);
        lastPosition = position;


        // Return the completed view to render on screen
        return convertView;


    } //End getView() method












} //END  CarsInfoAdapter{} class

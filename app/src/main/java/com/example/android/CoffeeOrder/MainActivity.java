package com.example.android.CoffeeOrder;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.CheckBox;
import android.widget.Toast;
//import android.util.Log;
//import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 99;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view) {
        if(quantity == 100){
            // show an error message as a Toast
            Toast.makeText(this, "You can not have more than 100 coffees",Toast.LENGTH_SHORT).show();
            //exit this method early because there's nothing left to do

            return;
        }
        quantity = quantity + 1;
        display(quantity);

    }

    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view) {
        if(quantity ==1){
            // show an error message as a Toast
            Toast.makeText(this, "You can not have less than one coffees",Toast.LENGTH_SHORT).show();
            //exit this method early because there's nothing left to do
            return;
        }
        quantity = quantity - 1;
        display(quantity);

    }

    /**
     * This method display the given text on screen
     * @param message
     * @return
     */
    private int displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
        return 0;
    }


    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        EditText nameField =(EditText) findViewById(R.id.name_field);
        String name = nameField.getText().toString();


        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_CheckBox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_CheckBox);
        boolean hasChocolate = chocolateCheckBox.isChecked();

        // Log.v("MainActivity", "Has whipped cream:" + hasWhippedCream);

        int price = calculatePrice(hasWhippedCream , hasChocolate);
        String priceMessage =createOrderSummary(name,price, hasWhippedCream,hasChocolate);
        displayMessage(priceMessage);
    }

    /**
     * calculate the price of the order.
     *@param addWhippedCream is whether or not the user want to whipped cream topping
     *@param addChocolate is whether or not the user want to whipped cream topping
     * @return total price
     */

    private int calculatePrice(boolean addWhippedCream , boolean addChocolate)
    {
        // price of one cup of coffee
        int basePrice = 5;
        //Add $1 if user wants to whipped cream
        if(addWhippedCream){
            basePrice = basePrice + 1;
        }
        //Add $2 if user wants to chocolate
         if(addChocolate){
             basePrice = basePrice + 2;
         }
         // calculate the total order price by multiplying by quantity
        return quantity * basePrice;}


    private String createOrderSummary(String name,int price,boolean addWhippedCream ,boolean addChocolate){
        String priceMessage = "Name: "+ name;
        priceMessage = priceMessage + "\nQuantity: " +  quantity;
        priceMessage = priceMessage +"\nAdd whipped cream ? " + addWhippedCream;
        priceMessage = priceMessage +"\nAdd chocolate ? " + addChocolate;
        priceMessage = priceMessage +"\nTotal : $" + price;
        priceMessage = priceMessage + "\nThank You!";

        return priceMessage;
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
          quantityTextView.setText("" + number);
    }

   // private void displayPrice(int number) {
       // TextView priceTextView = (TextView) findViewById(R.id.order_summary_text_view);
       // priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
   // }





}


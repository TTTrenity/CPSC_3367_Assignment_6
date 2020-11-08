package edu.ualr.intentsassignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import edu.ualr.intentsassignment.model.Contact;

public class ContactFormActivity extends AppCompatActivity {
    // TODO 01. Create a new layout file to define the GUI elements of the ContactFormActivity.
    // TODO 02. Define the basic skeleton of the ContactFormActivity. Inflate the layout defined in the first step to display the GUI elements on screen.
    EditText first_name_et;
    EditText last_name_et;
    EditText phone_et;
    EditText email_et;
    EditText address_et;
    EditText website_et;
    public static final String EXTRA_CONTACT = "ContactData";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_form);

        first_name_et = (EditText) findViewById(R.id.first_name_et);
        last_name_et = (EditText) findViewById(R.id.last_name_et);
        phone_et = (EditText) findViewById(R.id.phone_et);
        email_et = (EditText) findViewById(R.id.email_et);
        address_et = (EditText) findViewById(R.id.address_et);
        website_et = (EditText) findViewById(R.id.website_et);
    }

    // TODO 06. Create a new method that reads the values in the several EditText elements of the layout and then uses the Contact class to send those data to ContactInfoActivity
    public void saveContact(View view) {
        String first_name = first_name_et.getText().toString();
        String last_name = last_name_et.getText().toString();
        String phone = phone_et.getText().toString();
        String email = email_et.getText().toString();
        String address = address_et.getText().toString();
        String website = website_et.getText().toString();

        Contact contact = new Contact(first_name, last_name, phone, email, address, website);
        Intent intent = new Intent(this, ContactInfoActivity.class);
        intent.putExtra(EXTRA_CONTACT,contact);
        startActivity(intent);
    }
}

package edu.ualr.intentsassignment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import edu.ualr.intentsassignment.model.Contact;

public class ContactInfoActivity extends AppCompatActivity {
    // TODO 03. Create a new layout file to define the GUI elements of the ContactInfoActivity.
    // TODO 04. Define the basic skeleton of the ContactInfoActivity. Inflate the layout defined in the first step to display the GUI elements on screen.
    private TextView name_tv;
    private TextView phone_tv;
    private TextView email_tv;
    private TextView address_tv;
    private TextView website_tv;

    private String name;
    private String phone;
    private String email;
    private String address;
    private String website;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_info);
        Contact contact = getIntent().getParcelableExtra(ContactFormActivity.EXTRA_CONTACT);

        name_tv = (TextView) findViewById(R.id.name_tv);
        phone_tv = (TextView) findViewById(R.id.phone_tv);
        email_tv = (TextView) findViewById(R.id.email_tv);
        address_tv = (TextView) findViewById(R.id.address_tv);
        website_tv = (TextView) findViewById(R.id.website_tv);
        name = contact.getFullName();
        phone = contact.getPhoneNumber();
        email = contact.getEmailAddress();
        address = contact.getAddress();
        website = contact.getWebsite();

        populateData();
    }
    // TODO 07. Create a new method that reads the contact info coming from ContactFormActivity and use it to populate the several TextView elements in the layout.
    public void populateData() {
        name_tv.setText(name);
        phone_tv.setText(phone);
        email_tv.setText(email);
        address_tv.setText(address);
        website_tv.setText(website);
    }
    // TODO 08. Create a new method that invokes a Phone Dialer app, using as parameter the phone number included in the contact info received from ContactFormActivity in the previous step
    public void makeCall(View view) {
        Uri uri = Uri.parse("tel:" + Uri.encode(phone));
        Intent intent = new Intent(Intent.ACTION_DIAL, uri);
        startActivity(intent);
    }
    // TODO 09. Create a new method that invokes a Messages app, using as parameter the phone number included in the contact info received from ContactFormActivity in the 7th step
    public void sendMessage(View view) {
        Uri uri = Uri.parse("smsto:" + Uri.encode(phone));
        Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
        startActivity(intent);
    }
    // TODO 10. Create a new method that invokes a Maps app, using as parameter the address included in the contact info received from ContactFormActivity in the 7th step
    public void findAddress(View view) {
        Uri uri = Uri.parse("geo:0,0?q=" + Uri.encode(address));
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
    // TODO 11. Create a new method that invokes an Email app, using as parameter the email address included in the contact info received from ContactFormActivity in the 7th step
    public void sendEmail(View view) {
        Uri uri = Uri.parse("mailto:" + Uri.encode(email));
        Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
        startActivity(intent);
    }
    // TODO 12. Create a new method that invokes an Web Browser app, using as parameter the web url included in the contact info received from ContactFormActivity in the 7th step
    public void openWebsite(View view) {
        Uri uri = Uri.parse("http://" + website);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}

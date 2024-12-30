package com.example.message;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextMessage;
    private ImageButton sendButton;
    private LinearLayout messageContainer;
    private ScrollView scrollViewMessages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        editTextMessage = findViewById(R.id.editTextMessage);
        sendButton = findViewById(R.id.sendButton);
        messageContainer = findViewById(R.id.messageContainer);
        scrollViewMessages = findViewById(R.id.scrollViewMessages);

        // Set onClickListener for Send Button
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = editTextMessage.getText().toString().trim();

                if (!message.isEmpty()) {
                    addMessageToContainer(message);
                    editTextMessage.setText("");
                }
            }
        });
    }

    // Function to add a message to the message container
    private void addMessageToContainer(String message) {
        TextView messageView = new TextView(this);
        messageView.setText(message);
        messageView.setBackgroundResource(R.drawable.rounded_message);
        messageView.setPadding(16, 16, 16, 16);
        messageView.setTextColor(getResources().getColor(android.R.color.black));
        messageView.setTextSize(16);

        // Add message to container
        messageContainer.addView(messageView);

        // Scroll to the bottom
        scrollViewMessages.post(() -> scrollViewMessages.fullScroll(View.FOCUS_DOWN));
    }
}

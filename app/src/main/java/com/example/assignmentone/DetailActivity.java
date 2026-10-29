package com.example.assignmentone;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        int topicIndex = getIntent().getIntExtra(
                MainActivity.EXTRA_TOPIC_INDEX,
                0
        );

        String[] titles = getResources().getStringArray(
                R.array.string_array_titles
        );

        String[] contents = getResources().getStringArray(
                R.array.string_array_content
        );

        String[] imageNames = getResources().getStringArray(
                R.array.string_array_images
        );

        String[] topicNames = {
                getString(R.string.facilities),
                getString(R.string.events),
                getString(R.string.clubs),
                getString(R.string.support)
        };

        ImageView detailIcon = findViewById(R.id.detailIcon);
        TextView detailName = findViewById(R.id.detailName);
        TextView detailTitle = findViewById(R.id.detailTitle);
        TextView detailContent = findViewById(R.id.detailContent);

        String imageName = imageNames[topicIndex].trim();

        int imageResourceId = getResources().getIdentifier(
                imageName,
                "drawable",
                getPackageName()
        );

        detailIcon.setImageResource(imageResourceId);
        detailIcon.setContentDescription(topicNames[topicIndex]);
        detailName.setText(topicNames[topicIndex]);
        detailTitle.setText(titles[topicIndex]);
        detailContent.setText(contents[topicIndex]);
    }
}
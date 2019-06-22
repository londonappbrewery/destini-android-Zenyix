package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    int mIndex;
    int mStory;
    TextView mStoryText;
    Button mTopButton;
    Button mBottomButton;

    private Story[] mStoryLine = new Story[]{
            new Story(R.string.T1_Story,R.string.T1_Ans1,R.string.T1_Ans2),
            new Story(R.string.T2_Story,R.string.T2_Ans1,R.string.T2_Ans2),
            new Story(R.string.T3_Story,R.string.T3_Ans1,R.string.T3_Ans2),
            new Story(R.string.T4_End,0,0),
            new Story(R.string.T5_End,0,0),
            new Story(R.string.T6_End,0,0)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStoryText = findViewById(R.id.storyTextView);
        mTopButton = findViewById(R.id.buttonTop);
        mBottomButton = findViewById(R.id.buttonBottom);

        if(savedInstanceState != null){
            mIndex = savedInstanceState.getInt("IndexKey");
            if(mIndex < 3) {
                mTopButton.setText(mStoryLine[mIndex].getTopID());
                mBottomButton.setText(mStoryLine[mIndex].getBottomID());
            } else{
                mTopButton.setVisibility(View.INVISIBLE);
                mBottomButton.setVisibility(View.INVISIBLE);
            }
        } else {
            mIndex = 0;
        }

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mIndex == 0){
                    mIndex = 2;
                } else if(mIndex==1){
                    mIndex = 2;
                } else{
                    mIndex = 5;
                }
                updateStory();
            }
        });

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mBottomButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(mIndex == 0){
                    mIndex = 1;
                } else if(mIndex == 1){
                    mIndex = 3;
                } else{
                    mIndex = 4;
                }
                updateStory();
            }
        });

    }

    public void updateStory(){
         mStory = mStoryLine[mIndex].getStoryID();
         mStoryText.setText(mStory);
         if(mIndex < 3) {
             mTopButton.setText(mStoryLine[mIndex].getTopID());
             mBottomButton.setText(mStoryLine[mIndex].getBottomID());
         } else{
             mTopButton.setVisibility(View.INVISIBLE);
             mBottomButton.setVisibility(View.INVISIBLE);
         }
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);

        outState.putInt("IndexKey",mIndex);
    }
}

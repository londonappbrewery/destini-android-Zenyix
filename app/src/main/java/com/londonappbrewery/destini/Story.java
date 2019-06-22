package com.londonappbrewery.destini;

public class Story {
    public int mStoryID;
    public int mTopID;
    public int mBottomID;

    public Story(int storyID,int topID, int bottomID){
        mStoryID = storyID;
        mTopID = topID;
        mBottomID = bottomID;
    }

    public int getStoryID() {
        return mStoryID;
    }

    public void setStoryID(int storyID) {
        mStoryID = storyID;
    }

    public int getTopID() {
        return mTopID;
    }

    public void setTopID(int topID) {
        mTopID = topID;
    }

    public int getBottomID() {
        return mBottomID;
    }

    public void setBottomID(int bottomID) {
        mBottomID = bottomID;
    }
}

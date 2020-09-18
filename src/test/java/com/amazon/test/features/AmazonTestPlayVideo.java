package com.amazon.test.features;

import com.amazon.test.featurebase.AmazonPlayVideo;

import io.cucumber.java.en.Then;

public class AmazonTestPlayVideo extends AmazonPlayVideo {

	public AmazonTestPlayVideo() {
		// TODO Auto-generated constructor stub
	}

    @Then ("User plays the video demo and closes the popup")
    public void user_plays_video_demo_and_close_popup() throws Exception {
    	playVideoDemo();
    }

}

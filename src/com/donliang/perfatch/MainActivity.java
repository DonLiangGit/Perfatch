package com.donliang.perfatch;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TabHost;
import android.os.Build;
import android.provider.DocumentsContract.Root;

public class MainActivity extends FragmentActivity {

	private MyAdapter mAdapter;
	private ViewPager mPager;
	private static final String[] titles = { "one", "two", "three" };
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		MainUI();
//		if (savedInstanceState == null) {
//			getFragmentManager().beginTransaction()
//					.add(R.id.container, new PlaceholderFragment()).commit();
//		}
	}

	private void MainUI() {
		// TODO Auto-generated method stub
		
		final SlidingMenu menu = new SlidingMenu(this);
        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        menu.setFadeDegree(0.8f);
        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        
        mPager = (ViewPager) findViewById(R.id.MainPager);
        mAdapter = new MyAdapter(getSupportFragmentManager());
        mPager.setAdapter(mAdapter);
        
        mPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
        	
			@Override
			public void onPageSelected(int position) {
				// TODO Auto-generated method stub
				if (mAdapter!=null && mAdapter.getCount()>1) {
					if(position == 0) {
						menu.setMode(SlidingMenu.LEFT);
						menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);					
					} else {
						menu.setMode(SlidingMenu.LEFT_RIGHT);
                        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
					}
				}
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
        
        ImageButton menuButton = (ImageButton)findViewById(R.id.menuButton);
        menuButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				menu.showMenu();
			}
        	
        });
	
        PagerTabStrip strip = (PagerTabStrip)findViewById(R.id.pts_main);
        strip.setDrawFullUnderline(false);
        strip.setTextColor(Color.parseColor("#F7F8F8"));
        strip.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 40);
        strip.setTabIndicatorColor(Color.parseColor("#e72529"));
        strip.setNonPrimaryAlpha(0.5f);
        strip.setTextSpacing(50);
        
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

	public class MyAdapter extends FragmentPagerAdapter {

		public MyAdapter(FragmentManager fm) {
			super(fm);
			// TODO Auto-generated constructor stub
		}

		@Override
		public android.support.v4.app.Fragment getItem(int position) {
			// TODO Auto-generated method stub
			switch (position) {
			case 0:
				return new ImageFragment(R.drawable.frag_img2);
			case 1:
				return new ImageFragment(R.drawable.frag_img3);
			case 2:
				return new ImageFragment(R.drawable.frag_img4);
			}
			return null;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 3;
		}
		
		@Override
		public CharSequence getPageTitle(int position) {
		    return titles[position];
		}

	}
}

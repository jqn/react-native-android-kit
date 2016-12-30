package fr.aybadb.rnak.components.coordinatorLayout;

import android.graphics.Color;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.views.text.ReactTextView;
import com.facebook.react.views.viewpager.ReactViewPager;
import com.facebook.react.views.viewpager.ReactViewPagerManager;

import javax.annotation.Nullable;
import java.util.Locale;
import java.util.Map;

public class CoordinatorLayoutManager extends ViewGroupManager<CoordinatorLayout> {
	private final static String REACT_CLASS = "CoordinatorLayout";
	private final static int COMMAND_DEBUG = 0;

	@Override
	public String getName() {
		return REACT_CLASS;
	}

	@Override
	protected CoordinatorLayout createViewInstance(ThemedReactContext reactContext) {
		CoordinatorLayout coordinatorLayout = new CoordinatorLayout(reactContext);

//		AppBarLayout appBarLayout = new AppBarLayout(reactContext);
//		appBarLayout.setLayoutParams(new AppBarLayout.LayoutParams(AppBarLayout.LayoutParams.MATCH_PARENT, AppBarLayout.LayoutParams.WRAP_CONTENT));
//		Toolbar toolbar = new Toolbar(reactContext);
//		toolbar.setTitle("TOTOTOTOTOTTOTOT");
//		toolbar.setBackgroundColor(Color.parseColor("#FF8080"));
//		toolbar.setLayoutParams(new AppBarLayout.LayoutParams(AppBarLayout.LayoutParams.MATCH_PARENT, AppBarLayout.LayoutParams.WRAP_CONTENT));
//		appBarLayout.addView(toolbar);
//		coordinatorLayout.addView(appBarLayout);

		// Programmatically ViewPager from a ViewGroupManager without jsx: Works perfectly yeahhhhh !!!
		ReactTextView textView1 = new ReactTextView(reactContext);
		ReactTextView textView2 = new ReactTextView(reactContext);
		textView1.setText("TEXT 111111111111111111111111");
		textView1.setBackgroundColor(Color.parseColor("#808080"));
		textView1.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
		textView2.setText("TEXT 222222222222222222222222");
		textView2.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));


		ReactViewPagerManager test = new ReactViewPagerManager();
		// TODO: check JSResponderHandler jsResponderHandler and be sure that is good to set it to null !
		ReactViewPager reactViewPager = test.createView(reactContext, null);
		test.addView(reactViewPager, textView1, 0);
		test.addView(reactViewPager, textView2, 0);
		reactViewPager.setCurrentItemFromJs(0, false);
		coordinatorLayout.addView(reactViewPager);

		/*
		TabLayout tabLayout = new TabLayout(reactContext);
		ReactViewPager viewPager = new ReactViewPager(reactContext);
		viewPager.setLayoutParams(new CoordinatorLayout.LayoutParams(CoordinatorLayout.LayoutParams.MATCH_PARENT, CoordinatorLayout.LayoutParams.MATCH_PARENT));
		ReactTextView textView1 = new ReactTextView(reactContext);
		ReactTextView textView2 = new ReactTextView(reactContext);
		ReactViewPagerManager test = new ReactViewPagerManager();
		textView1.setText("TEXT 111111111111111111111111");
		textView1.setBackgroundColor(Color.parseColor("#808080"));
		textView1.setLayoutParams(new TabLayout.LayoutParams(TabLayout.LayoutParams.MATCH_PARENT, TabLayout.LayoutParams.WRAP_CONTENT));
		textView2.setText("TEXT 222222222222222222222222");
		viewPager.setCurrentItem(0);
		tabLayout.setupWithViewPager(viewPager);
		tabLayout.addTab(tabLayout.newTab().setText("Tab1"));
		tabLayout.addTab(tabLayout.newTab().setText("Tab2"));
		tabLayout.addView(textView1);
		tabLayout.addView(textView2);

		for(int i=0; i < viewPager.getChildCount(); i++) {
			System.out.println("CHILD VIEWPAGER AYOUB " + viewPager.getChildAt(i).toString());
		}

		for (Method method: test.getShadowNodeClass().getDeclaredMethods()) {
			System.out.println("METHODSSS AYOUB " + method.getName());
		}
		*/

		//TODO send children from js and http://stackoverflow.com/questions/30954460/configure-coordinatorlayout-from-code
		for (int i = 0; i < coordinatorLayout.getChildCount(); i++) {
			System.out.println("CHILD AYOUB " + coordinatorLayout.getChildAt(i).toString());
		}

		return coordinatorLayout;
	}

	@Override
	public void receiveCommand(CoordinatorLayout root, int commandId, @Nullable ReadableArray args) {
		Assertions.assertNotNull(root);

		System.out.println("AYOUBBBBBB PASSSE0");

		switch (commandId) {
			case COMMAND_DEBUG:
				System.out.println("AYOUBBBBBB " + this.getChildCount(root));
				for(int i=0; i < root.getChildCount(); i++) {
					System.out.println("CHILD AYOUB " + root.getChildAt(i).toString());
				}
			default:
				break;
		}
	}

	@Nullable
	@Override
	public Map<String, Integer> getCommandsMap() {
		return MapBuilder.of(
				"showDebug",
				COMMAND_DEBUG
		);
	}

}

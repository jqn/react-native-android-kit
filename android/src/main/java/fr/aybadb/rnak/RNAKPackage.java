package fr.aybadb.rnak;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import fr.aybadb.rnak.components.button.ButtonManager;
import fr.aybadb.rnak.components.floatingbutton.FabManager;
import fr.aybadb.rnak.components.tab.TabLayoutManager;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RNAKPackage implements ReactPackage {
	@Override
	public List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
		return Collections.emptyList();
	}

	@Override
	public List<Class<? extends JavaScriptModule>> createJSModules() {
		return Collections.emptyList();
	}

	@Override
	public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
		return Arrays.<ViewManager>asList(
				new ButtonManager(),
				new FabManager(),
				new TabLayoutManager()
		);
	}
}

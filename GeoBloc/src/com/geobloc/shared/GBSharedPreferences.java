/**
 * 
 */
package com.geobloc.shared;


import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Environment;
import android.preference.EditTextPreference;
import android.preference.PreferenceActivity;
import android.widget.EditText;

import com.geobloc.R;

/**
 * @author Dinesh Harjani (goldrunner192287@gmail.com)
 *
 */
public class GBSharedPreferences extends PreferenceActivity {
	
	private EditTextPreference uploadPackagesServletAddress;
	private EditTextPreference listOfAvailableFormsAddress;
	private EditTextPreference packagesPath;
	private EditTextPreference formsPath;
	private EditTextPreference numberOfInternetAttempts;
	
	private EditText et;
	private SharedPreferences prefs;
	
	public static String __UPLOAD_PACKAGES_SERVLET_ADDRESS_KEY__ = "uploadPackagesServletAddress";
	public static String __PACKAGES_PATH_KEY__ = "packagesPath";
	public static String __FORMS_PATH_KEY__ = "formsPath";
	public static String __NUMBER_OF_INTERNET_ATTEMPTS_KEY__ = "numberOfInternetConnectionAttempts";
	public static String __GET_AVAILABLE_FORMS_LIST_SERVLET_ADDRESS_KEY__ = "getAvailableFormsListFromServletAddress";
	
	// default internet addresses
	public static String __DEFAULT_UPLOAD_PACKACGES_SERVLET_ADDRESS__ = "http://ull-etsii-geobloc.appspot.com/upload_basicpackageform";
	public static String __DEFAULT_GET_AVAILABLE_FORMS_LIST_SERVLET_ADDRESS = "http://ull-etsii-geobloc.appspot.com/get_listofavailablebasicforms";
	// default directory paths
	public static String __DEFAULT_FORMS_PATH__ = Environment.getExternalStorageDirectory()+"/GeoBloc/forms/";
	public static String __DEFAULT_PACKAGES_PATH__ = Environment.getExternalStorageDirectory()+"/GeoBloc/packages/";
	
	// default filenames
	public static String __DEFAULT_PACKAGE_MANIFEST_FILENAME__ = "manifest.xml";
	public static String __DEFAULT_FORM_FILENAME__ = "form.xml";
	public static String __DEFAULT_NUMBER_OF_INTERNET_ATTEMPTS__ = "3";
	
	// server OK Signature
	public static String __OK_SIGNATURE__ = "12122009_ALL_OK";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initConfig();
	}
	
	private void initConfig() {
		addPreferencesFromResource(R.layout.settings);
		
		uploadPackagesServletAddress = (EditTextPreference) findPreference(GBSharedPreferences.__UPLOAD_PACKAGES_SERVLET_ADDRESS_KEY__);
		listOfAvailableFormsAddress = (EditTextPreference) findPreference(GBSharedPreferences.__GET_AVAILABLE_FORMS_LIST_SERVLET_ADDRESS_KEY__);
		formsPath = (EditTextPreference) findPreference(GBSharedPreferences.__FORMS_PATH_KEY__);
		packagesPath = (EditTextPreference) findPreference(GBSharedPreferences.__PACKAGES_PATH_KEY__);
		numberOfInternetAttempts = (EditTextPreference) findPreference(GBSharedPreferences.__NUMBER_OF_INTERNET_ATTEMPTS_KEY__);
		
		// default uploadPackagesServletAddress
		setEditTextDefaultConfig(uploadPackagesServletAddress, 
				GBSharedPreferences.__DEFAULT_UPLOAD_PACKACGES_SERVLET_ADDRESS__);
		
		// default listOfAvailableFormsAddress
		setEditTextDefaultConfig(listOfAvailableFormsAddress, 
				GBSharedPreferences.__DEFAULT_GET_AVAILABLE_FORMS_LIST_SERVLET_ADDRESS);
		
		// default numberOfInternetAttempts
		setEditTextDefaultConfig(numberOfInternetAttempts, 
				GBSharedPreferences.__DEFAULT_NUMBER_OF_INTERNET_ATTEMPTS__);
		
		// default forms path
		setEditTextDefaultConfig(formsPath, GBSharedPreferences.__DEFAULT_FORMS_PATH__);
		
		
		// default packages path
		setEditTextDefaultConfig(packagesPath, GBSharedPreferences.__DEFAULT_PACKAGES_PATH__);

	}
	
	private void setEditTextDefaultConfig(EditTextPreference edt, String defaultText) {
		if ((edt.getText() == null) || (edt.getText().length() == 0))
			edt.setText(defaultText);
	}
}

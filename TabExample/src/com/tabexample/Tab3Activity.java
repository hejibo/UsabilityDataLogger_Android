package com.tabexample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class Tab3Activity  extends Activity
{
	CheckBox key_checkBox;
	CheckBox url_checkBox;
	CheckBox touch_checkBox;
	CheckBox runtime_checkBox;

	Button saveSettingButton;
	Button clearDataButton;
	private static final String TAG = "UDL_tab3_Activity";
	
        @Override
        public void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT);
            setContentView(R.layout.activity_tab3);
            
            key_checkBox=(CheckBox)findViewById(R.id.checkBox_key);
            url_checkBox=(CheckBox)findViewById(R.id.checkBox_url);
            touch_checkBox=(CheckBox)findViewById(R.id.checkBox_touch);
            runtime_checkBox=(CheckBox)findViewById(R.id.checkBox_runtime);
            
            saveSettingButton=(Button)findViewById(R.id.button_save_setting);
            
            
            
            saveSettingButton.setOnClickListener(new View.OnClickListener() {
                
                public void onClick(View v)
                {
                    if(!key_checkBox.isChecked())
                    {
                    	keyboardSettingMarker();
                    }
                    else
                    {
                    	keyboardSettingMarkerDelete();
                    }
                	if(!url_checkBox.isChecked())
                	{
                		urlSettingMarker();
                	}
                	else
                	{
                		urlSettingMarkerDelete();
                	}
                	if(!touch_checkBox.isChecked())
                	{
                		touchSettingMarker();
                	} 
                	else
                	{
                		touchSettingMarkerDelete();
                	}
                	if(!runtime_checkBox.isChecked())
                	{
                		runtimeSettingMarker();
                	}
                	else
                	{
                		runtimeSettingMarkerDelete();
                	}
                	Log.v(TAG, "save Setting!!");
                	Toast.makeText(getBaseContext(), "Save Setting", Toast.LENGTH_SHORT).show();
                }
                
                
            });
            
            clearDataButton=(Button)findViewById(R.id.button_clear_data);
            
            clearDataButton.setOnClickListener(new View.OnClickListener() {
                
                public void onClick(View v)
                {

                	
                	Log.v(TAG, "clear data");
                	
          		   File rootDirect = new File(Environment.getExternalStorageDirectory() + "/");
         		   File file = new File(rootDirect,"RecordStartMarker.txt");

         		    if(!file.exists()) //clear when not during recording
                	
                	{
	        			File subjectDirect_activity = new File(Environment.getExternalStorageDirectory() + "/ActivityMonitor");
	        			File file_activity = new File(subjectDirect_activity,"activityLog.txt");
	        			file_activity.delete();
	        			
	        			File subjectDirect_activity_raw = new File(Environment.getExternalStorageDirectory() + "/ActivityMonitor");
	        			File file_activity_raw = new File(subjectDirect_activity_raw,"activityLogRaw.txt");
	        			file_activity_raw.delete();
	                	
	                	File subjectDirect_touch = new File(Environment.getExternalStorageDirectory() + "/");
	        			File file_touch = new File(subjectDirect_touch,"touchRecord.txt");
	        			file_touch.delete();	
	        			
	        			File subjectDirect_touch_raw = new File(Environment.getExternalStorageDirectory() + "/");
	        			File file_touch_raw = new File(subjectDirect_touch_raw,"touchRecordRaw.txt");
	        			file_touch_raw.delete();
	        			
	        			File subjectDirect_url_raw = new File(Environment.getExternalStorageDirectory() + "/");
	        			File file_url_raw = new File(subjectDirect_url_raw,"urlDataRaw.txt");
	        			file_touch_raw.delete();
	                	
	                	File subjectDirect_keyboard = new File(Environment.getExternalStorageDirectory() + "/uKeyboardLogger/"+"keyboardRecord");
	        			File file_keyboard = new File(subjectDirect_keyboard,"KeyEvent-keyboardRecord.txt");
	        			file_keyboard.delete();                              	
                	}
                	else 
                	{
                		Toast.makeText(getBaseContext(), "Can't clear during recording", Toast.LENGTH_SHORT).show();
                	}
                }
            });
          
     	}
        @Override
        public void onBackPressed() {
            // your code.
        	Log.d(TAG, "onBackPressed");
        }
		public void touchSettingMarker()
		{
			try 
			{				
				File subjectDirect = new File(Environment.getExternalStorageDirectory() + "/MobildDataLogger/setting");								
				File file = new File(subjectDirect,"touchDisable.txt");
				FileOutputStream fos_mark = new FileOutputStream(file, true);
				String outline=" ";
				fos_mark.write(outline.getBytes());									
				fos_mark.close();
			} 
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			}	
		    catch (IOException e) 
			{
		    	e.printStackTrace();
		    }
		}
		
		public void keyboardSettingMarker()
		{
			try 
			{				
				File subjectDirect = new File(Environment.getExternalStorageDirectory() + "/MobildDataLogger/setting");								
				File file = new File(subjectDirect,"keyboardDisable.txt");
				FileOutputStream fos_mark = new FileOutputStream(file, true);
				String outline=" ";
				fos_mark.write(outline.getBytes());									
				fos_mark.close();
			} 
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			}	
		    catch (IOException e) 
			{
		    	e.printStackTrace();
		    }
		}
		public void urlSettingMarker()
		{
			try 
			{				
				File subjectDirect = new File(Environment.getExternalStorageDirectory() + "/MobildDataLogger/setting");								
				File file = new File(subjectDirect,"urlDisable.txt");
				FileOutputStream fos_mark = new FileOutputStream(file, true);
				String outline=" ";
				fos_mark.write(outline.getBytes());									
				fos_mark.close();
			} 
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			}	
		    catch (IOException e) 
			{
		    	e.printStackTrace();
		    }
		}
		public void runtimeSettingMarker()
		{
			try 
			{				
				File subjectDirect = new File(Environment.getExternalStorageDirectory() + "/MobildDataLogger/setting");								
				File file = new File(subjectDirect,"runtimeDisable.txt");
				FileOutputStream fos_mark = new FileOutputStream(file, true);
				String outline=" ";
				fos_mark.write(outline.getBytes());									
				fos_mark.close();
			} 
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			}	
		    catch (IOException e) 
			{
		    	e.printStackTrace();
		    }
		}
            
		public void touchSettingMarkerDelete()
		{
			File subjectDirect = new File(Environment.getExternalStorageDirectory() + "/MobildDataLogger/setting");
			File file = new File(subjectDirect,"touchDisable.txt");
			file.delete();
		}
		
		public void keyboardSettingMarkerDelete()
		{
			File subjectDirect = new File(Environment.getExternalStorageDirectory() + "/MobildDataLogger/setting");
			File file = new File(subjectDirect,"keyboardDisable.txt");
			file.delete();
		}
		
		public void urlSettingMarkerDelete()
		{
			File subjectDirect = new File(Environment.getExternalStorageDirectory() + "/MobildDataLogger/setting");
			File file = new File(subjectDirect,"urlDisable.txt");
			file.delete();
		}
		
		public void runtimeSettingMarkerDelete()
		{
			File subjectDirect = new File(Environment.getExternalStorageDirectory() + "/MobildDataLogger/setting");
			File file = new File(subjectDirect,"runtimeDisable.txt");
			file.delete();
		}
		
		
		
		
		
		
		
}

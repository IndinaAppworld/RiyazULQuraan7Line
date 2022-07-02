package com.app.riyazulquran7line;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;

import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;

import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.com.page.CurlPage;
import com.com.page.CurlView;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.touch.ExtendedViewPager;
import com.touch.TouchImageView;
import com.utils.Constants;
import com.utils.Contact;
import com.utils.DatabaseHandler;

/**
 * Simple Activity for curl testing.
 * 
 * @author harism
 * 15 para ka 755 page missing hai
 */
public class CurlActivity extends Activity implements OnPageChangeListener, OnLoadCompleteListener {

	

	int lastread=0;
	String bookmarkPage="";
	TextView pagenotxt;
	int currentPage=0;
PDFView pdfView;
ImageView fav;
int rediRectPage=0;
	public Vector indexVector=new Vector();
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); 
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON, WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);		
  		setContentView(R.layout.paging);
		pdfView=(PDFView)findViewById(R.id.pdfView);
		fav=(ImageView)findViewById(R.id.fav);
//		flipper=(ViewFlipper)findViewById(R.id.flipper);
//		Constants.loadBitmap();
//		int index = 0;
//		if (getLastNonConfigurationInstance() != null) {
//			index = (Integer) getLastNonConfigurationInstance();
//		}
//		int counter=0;
//		for(int i=Constants.TOTAL_PAGES-1;i>=0;i--)
//		{
//
//			mynames[counter]="image"+(i+1)+".png";
//			counter++;
//		}
//		mCurlView = (CurlView) findViewById(R.id.curl);
//		mCurlView.setPageProvider(new PageProvider());
//		mCurlView.setSizeChangedObserver(new SizeChangedObserver());





		if(getIntent().getExtras()!=null)
		{

			if(getIntent().getExtras().containsKey("noQurran")==true)
			{
				isQuraan=false;
				rediRectPage=Integer.parseInt(getIntent().getExtras().getString("noQurran"));
			}
			if(getIntent().getExtras().containsKey("page")==true)
			currentPage=getIntent().getExtras().getInt("page");
//			bookmarkPage=""+pageno;
//			if(getIntent().getExtras().containsKey("bookmarkPage"))
//			bookmarkPage=getIntent().getExtras().getString("bookmarkPage");
			
//			Toast.makeText(getApplicationContext(),""+pageno+","+m,Toast.LENGTH_SHORT).show();
		}

		if(isQuraan==true)
		{
			pdfView.fromAsset("quraan.pdf")
					.defaultPage(currentPage)
					.onPageChange(this)
//				.enableAnnotationRendering(true)
					.onLoad(this)
					.scrollHandle(new DefaultScrollHandle(this))
					.spacing(0) // in dp
					.load();
		}
		else
		{
			pdfView.fromAsset("fazilat.pdf")
					.defaultPage(rediRectPage)
					.onPageChange(this)
//				.enableAnnotationRendering(true)
					.onLoad(this)
					.scrollHandle(new DefaultScrollHandle(this))
					.spacing(0) // in dp
					.load();
		}
		
//		mCurlView.setCurrentIndex(pageno);
//		mCurlView.setBackgroundColor(0xFF202830);
		

		// This is something somewhat experimental. Before uncommenting next
		// line, please see method comments in CurlView.
		// mCurlView.setEnableTouchPressure(true);
		

		
		
		
//		if(Constants.sp.getBoolean("readingmode", false)==false)
//			showBookMarkDialog();

//	      ;
//
//	      flipper.setDisplayedChild(Constants.sp.getInt("readType", 0));
//	      if(flipper.getDisplayedChild()==0)

//	      else lastread=pageno-1;
//
//
//	      pagenotxt=(TextView)findViewById(R.id.pageno);
//	       Timer timer = new Timer();
//	       TimerTask timerTask;
//	      timerTask = new TimerTask() {
//	       @Override
//	       public void run() {
//	          //refresh your textview
//	    	   runOnUiThread(new Runnable() {
//                 @Override
//                 public void run() {
//
////              	   if(flipper.getDisplayedChild()==0)
////              	   pagenotxt.setText(""+(mBitmapIds1.length-mCurlView.getCurrentIndex()+1));
////              	   else
////              	   {
////              		   pagenotxt.setText(""+(mBitmapIds1.length-mViewPager.getCurrentItem()));
////              	   }
//                 }
//             });
//
//	       }
//	      };
//	      timer.schedule(timerTask, 0, 100);


//		findViewById(R.id.bookmarkadd).setOnClickListener(new OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				back("Bookmark", "Do you want to add this page to bookmark");
//			}
//		});


		if(isQuraan==false)
		{
			fav.setVisibility(View.INVISIBLE);
//            fav.setLayoutParams(new ImageView);
		}
		fav.setImageResource(R.drawable.favunsel);
		fav.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{

				AddToBarmak();
			}
		});

		findViewById(R.id.backicon).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				finish();
			}
		});

		findViewById(R.id.iconup).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {


				pdfView.jumpTo(pdfView.getCurrentPage()-1);

			}
		});
		findViewById(R.id.icondown).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				pdfView.jumpTo(pdfView.getCurrentPage()+1);
			}
		});

	}
	public void AddToBarmak()
	{

//        AlertDialog.Builder builder=	new AlertDialog.Builder(MainActivity.this);
//        builder.setIcon(android.R.drawable.ic_dialog_alert);
//
//        String yes="Yes",no="No";
//        int temp,temp1;
//
//            builder.setTitle("Add to Book Mark");
//
//            builder.setMessage("Would you like to add to Book Mark");
//
//        builder.setPositiveButton(yes, new DialogInterface.OnClickListener() {
//
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//
//                //Stop the activity

		DatabaseHandler db = new DatabaseHandler(CurlActivity.this);

		String str=""+(pdfView.getCurrentPage()+1);
		System.out.println("Current Page-------"+str);

		if(db.getContactsCount(""+str)==0)
		{

			String dataStr="";
//			try
//			{
//				String t[] = indexVector.get(Integer.parseInt(str)-2).toString().split(",");
//				String paraName=Utils.PARAA_NAME[Integer.parseInt(t[0])-1]+":"+Utils.paraname_english[Integer.parseInt(t[0])-1];
//				String surahName=Utils.SURAH_NAME[Integer.parseInt(t[1])-1]+":"+Utils.surehname_english[Integer.parseInt(t[1])-1];
//				dataStr=paraName+"~"+surahName;
//			}
//			catch (Exception e
//					)
			{


				dataStr=Constants.getCurrentTimeStamp();
			}
			System.out.println("Data Strr;;;"+dataStr);
			db = new DatabaseHandler(CurlActivity.this);
			db.addContact(new Contact("", ""+str,dataStr));
			db.close();


			fav.setImageResource(R.drawable.faxsel);
//                    Toast.makeText(getApplicationContext(),"Added to bookmark",Toast.LENGTH_SHORT).show();

			Toast toast = Toast.makeText(getApplicationContext(),"Added to Bookmark",Toast.LENGTH_LONG);
//			View view = toast.getView();
//			view.setBackgroundColor(Color.parseColor(Constants.TOASTCOLOR));
//			TextView text = (TextView) view.findViewById(android.R.id.message);
////				text.setTextColor(Color.parseColor(Constants.TOASTCOLOR_TEXT));
//
//			text.setTextColor(Color.parseColor(Constants.TOASTCOLOR_TEXT));
//			text.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 18);
			toast.show();
		}
		else
		{
			db = new DatabaseHandler(CurlActivity.this);
			db.deleteExistingBookmark(str);
			db.close();


			fav.setImageResource(R.drawable.favunsel);
//                    Toast.makeText(getApplicationContext(),"Bookmark deleted",Toast.LENGTH_SHORT).show();

			Toast toast = Toast.makeText(getApplicationContext(),"Bookmark Deleted",Toast.LENGTH_LONG);
//			View view = toast.getView();
//			view.setBackgroundColor(Color.parseColor(Constants.TOASTCOLOR));
//			TextView text = (TextView) view.findViewById(android.R.id.message);
////				text.setTextColor(Color.parseColor(Constants.TOASTCOLOR_TEXT));
//
//			text.setTextColor(Color.parseColor(Constants.TOASTCOLOR_TEXT));
//			text.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 18);
			toast.show();
		}


	}
	boolean isQuraan=true;
	@Override
	public void onPause() {
		super.onPause();

		
	}

	@Override
	public void onResume() {
		super.onResume();
	}

	public void back(final String title,final String message)
	{
		

		
	}

    @Override
    public void onActivityResult(int req,int res,Intent data)
    {
    	if(res==100)
    	{
    		
//    		if(flipper.getDisplayedChild()==0)
//    	        Constants.editor.putInt("lastread", mBitmapIds1.length-lastread+1);
//    	        else Constants.editor.putInt("lastread", mBitmapIds1.length-lastread-1);
//    	        

    	}
    	
    }
    public boolean onKeyDown(int keyCode, KeyEvent event) 
    { 
       if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN || keyCode == KeyEvent.KEYCODE_VOLUME_UP) { 
           // Do your thing 
    	   
//    	   showSettingDialog();

		   finish();
           return true;
       } else {
           return super.onKeyDown(keyCode, event); 
       }
    }

	@Override
	public void onPageChanged(int page, int pageCount) {
//        pageNumber = page;
//        setTitle(String.format("%s %s / %s", pdfFileName, page + 1, pageCount));

		if(isQuraan) {
			if (Constants.sp == null) {
				Constants.sp = getSharedPreferences(Constants.prefName, Activity.MODE_PRIVATE);
			}
			if (Constants.editor == null) {
				Constants.editor = Constants.sp.edit();
			}
			Constants.editor.putInt("lastread", page + 1);
			Constants.editor.commit();
			DatabaseHandler db = new DatabaseHandler(this);
			if (db.getContactsCount("" + (page + 1)) == 0) {
				fav.setImageResource(R.drawable.favunsel);
			} else {
				fav.setImageResource(R.drawable.faxsel);
			}

			db.close();
		}

	}
	@Override
	public void loadComplete(int nbPages) {

	}


	@Override
	public void onBackPressed()
	{
		finish();
	}
}
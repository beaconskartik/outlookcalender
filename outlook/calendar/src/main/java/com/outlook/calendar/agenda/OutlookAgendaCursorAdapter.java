package com.outlook.calendar.agenda;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateUtils;

import com.outlook.calendar.event.OutlookDayEventQueryHanlder;

/**
 * Created by ksachan on 7/6/17.
 */

public class OutlookAgendaCursorAdapter extends OutlookAgendaAdapter
{
	public OutlookAgendaCursorAdapter(Context context)
	{
		super(context);
		mHandler = new OutlookDayEventQueryHanlder(context.getContentResolver(), this);
	}
	
	@Override
	public void onDetachedFromRecyclerView(RecyclerView recyclerView)
	{
		deactivate();
	}
	
	@Override
	protected void loadEvents(long timeMillis)
	{
		mHandler.startQuery(timeMillis, timeMillis, timeMillis + DateUtils.DAY_IN_MILLIS);
	}
	
	private final OutlookDayEventQueryHanlder mHandler;
}

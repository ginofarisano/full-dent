package com.project.fulldentandroid.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.project.fulldentclientandroid.activity.R;
import com.project.fulldentclientandroid.bean.Visita;
/**
 * Adapeter utilizzato per popolare la listview
 * contenente lo storico dell'utente
 * 
 * @author ginofarisano
 *
 */
public class VisiteAdapter extends ArrayAdapter<Visita> {

	public VisiteAdapter(Context context, int textViewResourceId,
			List<Visita> objects) {
		super(context, textViewResourceId, objects);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		return getViewOptimize(position, convertView, parent);
	}

	public View getViewOptimize(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder = null;
		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) getContext()
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.row_list_visite, null);
			viewHolder = new ViewHolder();
			viewHolder.name = (TextView) convertView
					.findViewById(R.id.txtViewVisita);

			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		Visita visita = getItem(position);
		viewHolder.name.setText(visita.getNomePrestazione() + " del "
				+ visita.getData());

		return convertView;
	}

	private class ViewHolder {
		public TextView name;
	}
}
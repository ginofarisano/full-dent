package com.project.fulldentandroid.adapter;

import java.util.List;





import com.project.fulldentclientandroid.activity.R;
import com.project.fulldentclientandroid.bean.Servizio;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


/**
 * Adapeter utilizzato per popolare la listview
 * contenente i servizi offerti dal centro
 * 
 * @author ginofarisano
 *
 */
public class ServiziAdapter extends ArrayAdapter<Servizio> {

	public ServiziAdapter(Context context, int textViewResourceId,
			List<Servizio> objects) {
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
			convertView = inflater.inflate(R.layout.row_list_servizi, null);
			viewHolder = new ViewHolder();
			viewHolder.name = (TextView) convertView
					.findViewById(R.id.txtViewServizio);

			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		Servizio visita = getItem(position);
		viewHolder.name.setText(visita.getNome()+ " (€ "+visita.getCosto()+") - "+" (ore "+visita.getDurata()+")");

		return convertView;
	}

	private class ViewHolder {
		public TextView name;
	}
}
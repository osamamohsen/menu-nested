package app.testing4.Menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import app.testing4.R;


public class SlidingMenuAdapter extends BaseAdapter {
    private Context context;
    private List<ItemSlideMenu> lstItems;
    AdapterInterface adapterInterface;
    LayoutInflater mInflater;
    public SlidingMenuAdapter(Context context, ArrayList<ItemSlideMenu> lstItems, AdapterInterface adapterInterface) {
        this.context = context;
        this.lstItems = lstItems;
        this.adapterInterface = adapterInterface;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return lstItems.size();
    }

    @Override
    public Object getItem(int position) {
        return lstItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

   /*@Override
    public View getView(final int position, final View convertView, ViewGroup parent) {
        View v = View.inflate(context, R.layout.menu_item,null);
        TextView text =  v.findViewById(R.id.tv_menu_item);
        ImageView img =  v.findViewById(R.id.img_menu_item);
        LinearLayout ll_menu_item = v.findViewById(R.id.ll_menu_item);

        ItemSlideMenu item = lstItems.get(position);
        text.setText(item.getTitle());
        ll_menu_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapterInterface.OnClickListener(view,position);
                notifyDataSetChanged();
            }
        });

        img.setImageResource(item.getImgId());
        return v;
    }
    */

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
         ViewHolder vh=null;


        if(convertView==null) {
            vh= new ViewHolder();
            convertView = mInflater.inflate(R.layout.menu_item, null);
            //inflate custom layour
            vh.text =  convertView.findViewById(R.id.tv_menu_item);
            vh.ll_menu_item = convertView.findViewById(R.id.ll_menu_item);
            vh.img_arrow =  convertView.findViewById(R.id.img_arrow);
            convertView.setTag(vh);
        }
        else {
          vh =(ViewHolder) convertView.getTag();
        }
        //vh.tv2.setText("Position = "+position);
        String item = lstItems.get(position).getTitle().toString();
        if(lstItems.get(position).getType().toString().equals("0")){
            vh.img_arrow.setVisibility(View.GONE);
        }else if(lstItems.get(position).getType().toString().equals("1")){
            vh.img_arrow.setVisibility(View.VISIBLE);
            vh.img_arrow.setImageResource(R.drawable.ic_arrow);
        }else if(lstItems.get(position).getType().toString().equals("2")){
            vh.img_arrow.setVisibility(View.VISIBLE);
            vh.img_arrow.setImageResource(R.drawable.ic_plus);
        }
        vh.text.setText(item);
        vh.ll_menu_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapterInterface.OnClickListener(view,position);
                notifyDataSetChanged();
            }
        });



        return convertView;
    }

    class ViewHolder
    {
        TextView text;
        LinearLayout ll_menu_item;
        ImageView img_arrow;
    }

}

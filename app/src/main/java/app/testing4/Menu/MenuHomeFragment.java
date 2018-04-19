package app.testing4.Menu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import app.testing4.R;


public class MenuHomeFragment extends Fragment {
    public DrawerLayout drawerLayout;

    View rootView;
    ImageView img_menu, ic_back;
    ListView lst_menu_item;
    public ArrayList<ItemSlideMenu> items = new ArrayList<>();
    SlidingMenuAdapter slidingMenuAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_menu_home, container, false);
        init();
        addMenuItems();
        return rootView;
    }




    private void init() {
        lst_menu_item  = rootView.findViewById(R.id.lst_menu_item);
        img_menu = getActivity().findViewById(R.id.img_menu);
        drawerLayout = getActivity().findViewById(R.id.drawer_layout);
        ic_back  = getActivity().findViewById(R.id.ic_back);
        ic_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(drawerLayout.isDrawerOpen(GravityCompat.START))
                    drawerLayout.closeDrawer(GravityCompat.START);
            }
        });

    }

    private void addMenuItems() {
        items.add(new ItemSlideMenu("title","0"));
        items.add(new ItemSlideMenu("asd asda ","1"));
        items.add(new ItemSlideMenu("message sad","1"));
        items.add(new ItemSlideMenu("welcome here","0"));

        slidingMenuAdapter = new SlidingMenuAdapter(getActivity(), items, new AdapterInterface() {
            @Override
            public void OnClickListener(View view, int position) {
                ItemSlideMenu selected = items.get(position);
                if(selected.getType().equals("1")){
                    android.support.v4.app.FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                    ft.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left);
                    ft.replace(R.id.container_content_menu, new MenuNestedFragment()).commit();
                }
            }
        });
        img_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(drawerLayout.isDrawerOpen(GravityCompat.START))
                    drawerLayout.closeDrawer(GravityCompat.START);
                else
                    drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        lst_menu_item.setAdapter(slidingMenuAdapter);
    }

}
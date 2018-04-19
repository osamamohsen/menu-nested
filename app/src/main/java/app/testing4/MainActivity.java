package app.testing4;

import android.content.Context;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

import app.testing4.Menu.AdapterInterface;
import app.testing4.Menu.ItemSlideMenu;
import app.testing4.Menu.MenuHomeFragment;
import app.testing4.Menu.SlidingMenuAdapter;


public class MainActivity extends AppCompatActivity {
    public DrawerLayout drawerLayout;
    ImageView img_menu, img_back_home;
    ListView lst_menu_item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        getSupportFragmentManager().beginTransaction().replace(R.id.container_content_menu,new MenuHomeFragment()).commit();
    }

    private void init() {
        drawerLayout = findViewById(R.id.drawer_layout);
        img_menu = findViewById(R.id.img_menu);
        lst_menu_item  = findViewById(R.id.lst_menu_item);

    }

}

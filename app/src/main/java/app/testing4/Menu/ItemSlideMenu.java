package app.testing4.Menu;

/**
 * Created by osama on 25/11/2017.
 */

public class ItemSlideMenu {
    private String title;
    private String type;

    public ItemSlideMenu(String title,String type) {
        this.title = title;
        this.type = type;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

   @Override
   public boolean equals(Object obj) {
       if(obj == null) return  false;
        if(this == obj) return true;
        if(this.getClass() != obj.getClass()) return  false;
        ItemSlideMenu item = (ItemSlideMenu) obj;
        return this.getTitle().equals(item.getTitle());
    }



}

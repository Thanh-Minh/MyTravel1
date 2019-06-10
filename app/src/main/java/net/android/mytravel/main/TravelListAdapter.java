package net.android.mytravel.main;

import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import net.android.mytravel.R;

import androidx.appcompat.widget.PopupMenu;

public class TravelListAdapter extends RecyclerView.Adapter<TravelListAdapter.TravelViewHolder>{

    class TravelViewHolder extends RecyclerView.ViewHolder {
        private final TextView titleTxt;
        private final TextView placeTxt;
        private final TextView dateTxt;
        private final ImageView photo;
        private final ImageButton moreButton;

        private TravelViewHolder(View v) {
            super(v);

            moreButton = v.findViewById(R.id.moreButton);
            photo = v.findViewById(R.id.photo);
            titleTxt = v.findViewById(R.id.title_txt);
            placeTxt = v.findViewById(R.id.place_txt);
            dateTxt = v.findViewById(R.id.date_txt);
            moreButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    PopupMenu popupMenu = new PopupMenu(mContext, moreButton);
                    popupMenu.inflate(R.menu.menu_edit_delete_travel);
                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            switch (item.getItemId()) {
                                case R.id.mniEdit:
                                    listItemClickListener.onEditItemClick(getItem(getAdapterPosition()));
                                    break;
                                case R.id.mniDelete:
                                    listItemClickListener.onDeleteItemClick(getItem(getAdapterPosition()));
                                    break;
                            }
                            return false;
                        }
                    });
                    popupMenu.show();
                }
            });
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listItemClickListener.onListItemClick(getItem(getAdapterPosition()));
                }
            });
        }
    }
}
